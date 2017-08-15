package guru.springframework.recipeproject.repository;

import guru.springframework.recipeproject.domain.Recipe;

import org.springframework.data.repository.Repository;

public interface RecipeRepository extends Repository<Recipe, Long> {

    <S extends Recipe> Iterable<S> saveAll(Iterable<S> entities);

    Iterable<Recipe> findAll();
}