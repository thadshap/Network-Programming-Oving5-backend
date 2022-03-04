package no.ntnu.oving5.Oving5.backend.controller;

import no.ntnu.oving5.Oving5.backend.model.CompilerModel;
import no.ntnu.oving5.Oving5.backend.repo.CompilerRepo;
import no.ntnu.oving5.Oving5.backend.service.CompilerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/compiler")
@CrossOrigin("http://localhost:8081")
public class CompilerController {
    @Autowired
    CompilerService service;
    @Autowired
    CompilerRepo repo;

    @GetMapping("/code")
    public List<CompilerModel> getcode(){
        return repo.findAll();
    }

    @PostMapping(path ="/code",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public CompilerModel sendCode(@RequestBody CompilerModel compilerModel) throws Exception {

        String output = service.compiler(compilerModel.getCode());
        System.out.println("completed compilation");
        CompilerModel newProgram = new CompilerModel();
        newProgram.setCode(compilerModel.getCode());
        newProgram.setOutput(output);
        System.out.println("saving now");
        repo.save(newProgram);
        return newProgram;
    }

}
