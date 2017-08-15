package guru.springframework.recipeproject.domain;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Optional;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Access(AccessType.FIELD)
    private Long id;

    @Access(AccessType.FIELD)
    private final String description;

    @Access(AccessType.FIELD)
    private final BigDecimal amount;

    @ManyToOne
    @Access(AccessType.FIELD)
    private final Recipe recipe;

    @ManyToOne
    @Access(AccessType.FIELD)
    private final UnitOfMeasure unit;

    @Deprecated
    Ingredient() {
        this.description = "";
        this.amount = BigDecimal.ZERO;
        this.recipe = null;
        this.unit = null;
    }

    public Ingredient(String description, BigDecimal amount, UnitOfMeasure unit, Recipe recipe) {
        this.description = Objects.requireNonNull(description, "description can't be null when creating " + this.getClass().getSimpleName());
        this.amount = Objects.requireNonNull(amount, "amount can't be null when creating " + this.getClass().getSimpleName());
        this.unit = Objects.requireNonNull(unit, "unit can't be null when creating " + this.getClass().getSimpleName());
        this.recipe = Objects.requireNonNull(recipe, "recipe can't be null when creating " + this.getClass().getSimpleName());
    }

    public Optional<Long> getId() {
        return Optional.ofNullable(this.id);
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public UnitOfMeasure getUnit() {
        return unit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ingredient)) return false;
        Ingredient that = (Ingredient) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}