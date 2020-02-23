package pl.shellchuck.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.shellchuck.charity.entity.Institution;

public interface InstitutionRepository extends JpaRepository<Institution, Long> {
}
