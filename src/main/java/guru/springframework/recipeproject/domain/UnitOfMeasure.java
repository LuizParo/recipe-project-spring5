package guru.springframework.recipeproject.domain;

import java.util.Objects;
import java.util.Optional;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UnitOfMeasure {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Access(AccessType.FIELD)
    private Long id;

    @Access(AccessType.FIELD)
    private final String description;

    @Deprecated
    UnitOfMeasure() {
        this.description = "";
    }

    public UnitOfMeasure(String description) {
        this.description = Objects.requireNonNull(description, "description can't be null when creating " + this.getClass().getSimpleName());
    }

    public Optional<Long> getId() {
        return Optional.ofNullable(this.id);
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UnitOfMeasure)) return false;
        UnitOfMeasure that = (UnitOfMeasure) o;
        return Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description);
    }
}