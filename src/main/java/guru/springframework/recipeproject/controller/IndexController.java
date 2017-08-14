package guru.springframework.recipeproject.controller;

import guru.springframework.recipeproject.repository.CategoryRepository;
import guru.springframework.recipeproject.repository.UnitOfMeasureRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    @Autowired
    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @GetMapping({"", "/", "/index"})
    public String index() {
        this.categoryRepository.findByDescription("American").ifPresent(System.out::println);
        this.unitOfMeasureRepository.findByDescription("Teaspoon").ifPresent(System.out::println);
        return "index";
    }
}