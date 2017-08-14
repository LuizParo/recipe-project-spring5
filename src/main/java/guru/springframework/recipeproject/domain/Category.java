package guru.springframework.recipeproject.domain;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import static java.util.Objects.requireNonNull;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Access(AccessType.FIELD)
    private Long id;

    @Access(AccessType.FIELD)
    private final String description;

    @ManyToMany(mappedBy = "categories")
    @Access(AccessType.FIELD)
    private final Collection<Recipe> recipes = new HashSet<>();

    public Category(String description) {
        this.description = requireNonNull(description, "description can't be null when creating " + this.getClass().getSimpleName());
    }

    public Optional<Long> getId() {
        return Optional.ofNullable(this.id);
    }

    public String getDescription() {
        return description;
    }

    public Collection<Recipe> getRecipes() {
        return new HashSet<>(this.recipes);
    }
}