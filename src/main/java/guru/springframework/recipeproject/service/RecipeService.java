package guru.springframework.recipeproject.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import guru.springframework.recipeproject.domain.Recipe;
import guru.springframework.recipeproject.repository.RecipeRepository;

@Service
public class RecipeService {
    private final RecipeRepository recipeRepository;

    @Autowired
    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public Iterable<Recipe> getRecipes() {
        return this.recipeRepository.findAll();
    }

    public Optional<Recipe> findById(Long id) {
        return this.recipeRepository.findById(id);
    }
}