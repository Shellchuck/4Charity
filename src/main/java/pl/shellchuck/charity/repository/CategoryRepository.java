package pl.shellchuck.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.shellchuck.charity.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
