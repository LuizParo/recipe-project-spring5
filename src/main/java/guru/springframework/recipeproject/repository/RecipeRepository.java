package guru.springframework.recipeproject.repository;

import java.util.Optional;

import org.springframework.data.repository.Repository;

import guru.springframework.recipeproject.domain.Recipe;

public interface RecipeRepository extends Repository<Recipe, Long> {

    <S extends Recipe> Iterable<S> saveAll(Iterable<S> entities);

    Iterable<Recipe> findAll();

    Optional<Recipe> findById(Long id);
}