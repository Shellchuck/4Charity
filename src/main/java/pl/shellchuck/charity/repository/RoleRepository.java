package pl.shellchuck.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.shellchuck.charity.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);
}
