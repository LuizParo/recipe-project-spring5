package guru.springframework.recipeproject.service;

import guru.springframework.recipeproject.domain.Recipe;
import guru.springframework.recipeproject.repository.RecipeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}