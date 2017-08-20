package guru.springframework.recipeproject.controller;

import java.io.Serializable;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import guru.springframework.recipeproject.domain.Category;

public final class CategoryDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private final Long id;
    private final String description;

    @JsonCreator
    public CategoryDTO(@JsonProperty("id") Long id,
                       @JsonProperty("description") String description) {
        this.id = id;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public static CategoryDTO toDTO(Category category) {
        Long id = category.getId().orElse(null);
        return new CategoryDTO(id, category.getDescription());
    }

    public static Iterable<CategoryDTO> toDTO(Iterable<Category> categories) {
        return StreamSupport.stream(categories.spliterator(), false)
            .map(CategoryDTO::toDTO)
            .collect(Collectors.toList());
    }
}
