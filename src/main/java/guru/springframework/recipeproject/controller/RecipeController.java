package guru.springframework.recipeproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import guru.springframework.recipeproject.domain.Recipe;
import guru.springframework.recipeproject.service.RecipeService;

@Controller
@RequestMapping("/recipes")
public class RecipeController {
    private final RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/{id}")
    public ModelAndView gerById(@PathVariable("id") Long id) {
        Recipe recipe = this.recipeService.findById(id).orElseThrow(() -> new RuntimeException("Recipe not found with id " + id));

        return new ModelAndView("recipe/show")
                .addObject("recipe", RecipeDTO.toDTO(recipe));
    }
}