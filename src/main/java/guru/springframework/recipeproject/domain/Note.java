package guru.springframework.recipeproject.domain;

import java.util.Objects;
import java.util.Optional;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

@Entity
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Access(AccessType.FIELD)
    private Long id;

    @Lob
    @Access(AccessType.FIELD)
    private final String recipeNote;

    @OneToOne
    @Access(AccessType.FIELD)
    private final Recipe recipe;

    @Deprecated
    Note() {
        this.recipeNote = "";
        this.recipe = null;
    }

    public Note(String recipeNote, Recipe recipe) {
        this.recipeNote = Objects.requireNonNull(recipeNote, "recipeNote can't be null when creating " + this.getClass().getSimpleName());
        this.recipe = Objects.requireNonNull(recipe, "recipe can't be null when creating " + this.getClass().getSimpleName());

        this.init();
    }

    private void init() {
        this.recipe.setNote(this);
    }

    public Optional<Long> getId() {
        return Optional.ofNullable(this.id);
    }

    public String getRecipeNote() {
        return recipeNote;
    }

    public Recipe getRecipe() {
        return recipe;
    }
}