package pl.shellchuck.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.shellchuck.charity.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

}
