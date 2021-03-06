package guru.springframework.recipeproject.controller;

import static com.google.common.collect.Lists.newArrayList;

import java.io.Serializable;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import guru.springframework.recipeproject.domain.Recipe;

public final class RecipeDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private final Long id;
    private final String description;
    private final Integer prepTime;
    private final Integer cookTime;
    private final Integer servings;
    private final String source;
    private final String url;
    private final String directions;
    private final Byte[] image;
    private final String difficulty;
    private final String note;
    private final Iterable<IngredientDTO> ingredients;
    private final Iterable<CategoryDTO> categories;

    @JsonCreator
    public RecipeDTO(@JsonProperty("id") Long id,
                     @JsonProperty("description") String description,
                     @JsonProperty("prepTime") Integer prepTime,
                     @JsonProperty("cookTime") Integer cookTime,
                     @JsonProperty("servings") Integer servings,
                     @JsonProperty("source") String source,
                     @JsonProperty("url") String url,
                     @JsonProperty("directions") String directions,
                     @JsonProperty("image") Byte[] image,
                     @JsonProperty("difficulty") String difficulty,
                     @JsonProperty("note") String note,
                     @JsonProperty("ingredients") Iterable<IngredientDTO> ingredients,
                     @JsonProperty("categories") Iterable<CategoryDTO> categories) {
        this.id = id;
        this.description = description;
        this.prepTime = prepTime;
        this.cookTime = cookTime;
        this.servings = servings;
        this.source = source;
        this.url = url;
        this.directions = directions;
        this.image = image;
        this.difficulty = difficulty;
        this.note = note;
        this.ingredients = ingredients;
        this.categories = categories;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Integer getPrepTime() {
        return prepTime;
    }

    public Integer getCookTime() {
        return cookTime;
    }

    public Integer getServings() {
        return servings;
    }

    public String getSource() {
        return source;
    }

    public String getUrl() {
        return url;
    }

    public String getDirections() {
        return directions;
    }

    public Byte[] getImage() {
        return image;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public String getNote() {
        return note;
    }

    public Iterable<IngredientDTO> getIngredients() {
        return ingredients;
    }

    public Iterable<CategoryDTO> getCategories() {
        return newArrayList(categories);
    }

    public static RecipeDTO toDTO(Recipe recipe) {
        Long id = recipe.getId().orElse(null);
        String difficulty = recipe.getDifficulty().toString();
        Iterable<IngredientDTO> ingredients = IngredientDTO.toDTO(recipe.getIngredients());
        Iterable<CategoryDTO> categories = CategoryDTO.toDTO(recipe.getCategories());

        return new RecipeDTO(
                id,
                recipe.getDescription(),
                recipe.getPrepTime(),
                recipe.getCookTime(),
                recipe.getServings(),
                recipe.getSource(),
                recipe.getUrl(),
                recipe.getDirections(),
                recipe.getImage(),
                difficulty,
                recipe.getNoteDescription(),
                ingredients,
                categories);
    }

    public static Iterable<RecipeDTO> toDTO(Iterable<Recipe> recipes) {
        return StreamSupport.stream(recipes.spliterator(), false)
            .map(RecipeDTO::toDTO)
            .collect(Collectors.toList());
    }
}