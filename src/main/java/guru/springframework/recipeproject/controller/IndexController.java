package guru.springframework.recipeproject.controller;

import guru.springframework.recipeproject.service.RecipeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
    private final RecipeService recipeService;

    @Autowired
    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping({"", "/", "/index"})
    public ModelAndView index() {
        return new ModelAndView("index")
            .addObject("recipes", this.recipeService.getRecipes());
    }
}