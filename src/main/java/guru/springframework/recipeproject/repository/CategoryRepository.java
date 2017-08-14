package guru.springframework.recipeproject.repository;

import guru.springframework.recipeproject.domain.Category;
import java.util.Optional;

import org.springframework.data.repository.Repository;

public interface CategoryRepository extends Repository<Category, Long> {

    Optional<Category> findByDescription(String description);
}