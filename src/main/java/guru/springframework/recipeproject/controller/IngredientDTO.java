package guru.springframework.recipeproject.controller;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import guru.springframework.recipeproject.domain.Ingredient;

public final class IngredientDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private final Long id;
    private final String description;
    private final BigDecimal amount;
    private final String unit;

    @JsonCreator
    public IngredientDTO(@JsonProperty("id") Long id,
                         @JsonProperty("description") String description,
                         @JsonProperty("amount") BigDecimal amount,
                         @JsonProperty("unit") String unit) {
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.unit = unit;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getUnit() {
        return unit;
    }

    public static IngredientDTO toDTO(Ingredient ingredient) {
        Long id = ingredient.getId().orElse(null);
        return new IngredientDTO(id, ingredient.getDescription(), ingredient.getAmount(), ingredient.getUnit().getDescription());
    }

    public static Iterable<IngredientDTO> toDTO(Iterable<Ingredient> ingredients) {
        return StreamSupport.stream(ingredients.spliterator(), false)
            .map(IngredientDTO::toDTO)
            .collect(Collectors.toList());
    }
}
