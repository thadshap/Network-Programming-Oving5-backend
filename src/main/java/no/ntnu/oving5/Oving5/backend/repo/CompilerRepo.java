package no.ntnu.oving5.Oving5.backend.repo;

import no.ntnu.oving5.Oving5.backend.model.CompilerModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompilerRepo extends JpaRepository<CompilerModel, Long> {
}
