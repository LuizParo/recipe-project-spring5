package guru.springframework.recipeproject.domain;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Access(AccessType.FIELD)
    private Long id;

    @Access(AccessType.FIELD)
    private final String description;

    @Access(AccessType.FIELD)
    private final Integer prepTime;

    @Access(AccessType.FIELD)
    private final Integer cookTime;

    @Access(AccessType.FIELD)
    private final Integer servings;

    @Access(AccessType.FIELD)
    private final String source;

    @Access(AccessType.FIELD)
    private final String url;

    @Access(AccessType.FIELD)
    private final String directions;

    @Lob
    @Access(AccessType.FIELD)
    private final Byte[] image;

    @Enumerated(value = EnumType.STRING)
    private final Difficulty difficulty;

    @OneToOne(cascade = CascadeType.ALL)
    @Access(AccessType.FIELD)
    private Note note;

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL)
    private Collection<Ingredient> ingredients = new HashSet<>();

    @Deprecated
    Recipe() {
        this.description = "";
        this.prepTime = 0;
        this.cookTime = 0;
        this.servings = 0;
        this.source = "";
        this.url = "";
        this.directions = "";
        this.image = new Byte[0];
        this.difficulty = null;
    }

    public Recipe(String description, Integer prepTime, Integer cookTime, Integer servings, String source, String url, String directions, Byte[] image, Difficulty difficulty) {
        this.description = Objects.requireNonNull(description, "description can't be null when creating " + this.getClass().getSimpleName());
        this.prepTime = Objects.requireNonNull(prepTime, "prepTime can't be null when creating " + this.getClass().getSimpleName());
        this.cookTime = Objects.requireNonNull(cookTime, "cookTime can't be null when creating " + this.getClass().getSimpleName());
        this.servings = Objects.requireNonNull(servings, "servings can't be null when creating " + this.getClass().getSimpleName());
        this.source = Objects.requireNonNull(source, "source can't be null when creating " + this.getClass().getSimpleName());
        this.url = Objects.requireNonNull(url, "url can't be null when creating " + this.getClass().getSimpleName());
        this.directions = Objects.requireNonNull(directions, "directions can't be null when creating " + this.getClass().getSimpleName());
        this.image = Objects.requireNonNull(image, "image can't be null when creating " + this.getClass().getSimpleName());
        this.difficulty = Objects.requireNonNull(difficulty, "difficulty can't be null when creating " + this.getClass().getSimpleName());
    }

    public Optional<Long> getId() {
        return Optional.ofNullable(this.id);
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

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public Optional<Note> getNote() {
        return Optional.ofNullable(this.note);
    }

    public void setNote(Note note) {
        this.note = note;
    }

    public Collection<Ingredient> getIngredients() {
        return new HashSet<>(this.ingredients);
    }

    public void addIngredients(Ingredient... ingredients) {
        for(Ingredient ingredient : ingredients) {
            this.ingredients.add(ingredient);
        }
    }
}