package guru.springframework.recipeproject.repository;

import guru.springframework.recipeproject.domain.UnitOfMeasure;
import java.util.Optional;

import org.springframework.data.repository.Repository;

public interface UnitOfMeasureRepository extends Repository<UnitOfMeasure, Long> {

    Optional<UnitOfMeasure> findByDescription(String description);
}