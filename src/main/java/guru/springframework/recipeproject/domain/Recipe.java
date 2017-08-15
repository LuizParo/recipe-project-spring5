package guru.springframework.recipeproject.domain;

import java.util.Collection;
import java.util.HashSet;
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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import static java.util.Objects.requireNonNull;

@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Lob
    @Access(AccessType.FIELD)
    private final String directions;

    @Lob
    @Access(AccessType.FIELD)
    private final Byte[] image;

    @Enumerated(value = EnumType.STRING)
    @Access(AccessType.FIELD)
    private final Difficulty difficulty;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "recipe")
    @Access(AccessType.FIELD)
    private Note note;

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL)
    @Access(AccessType.FIELD)
    private final Collection<Ingredient> ingredients = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "recipe_category",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    @Access(AccessType.FIELD)
    private final Collection<Category> categories = new HashSet<>();

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
        this.description = requireNonNull(description, "description can't be null when creating " + this.getClass().getSimpleName());
        this.prepTime = requireNonNull(prepTime, "prepTime can't be null when creating " + this.getClass().getSimpleName());
        this.cookTime = requireNonNull(cookTime, "cookTime can't be null when creating " + this.getClass().getSimpleName());
        this.servings = requireNonNull(servings, "servings can't be null when creating " + this.getClass().getSimpleName());
        this.source = requireNonNull(source, "source can't be null when creating " + this.getClass().getSimpleName());
        this.url = requireNonNull(url, "url can't be null when creating " + this.getClass().getSimpleName());
        this.directions = requireNonNull(directions, "directions can't be null when creating " + this.getClass().getSimpleName());
        this.image = requireNonNull(image, "image can't be null when creating " + this.getClass().getSimpleName());
        this.difficulty = requireNonNull(difficulty, "difficulty can't be null when creating " + this.getClass().getSimpleName());
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

    public Collection<Category> getCategories() {
        return new HashSet<>(this.categories);
    }

    public void addIngredients(Ingredient... ingredients) {
        for(Ingredient ingredient : ingredients) {
            if(!this.ingredients.contains(ingredient)) {
                this.ingredients.add(ingredient);
            }
        }
    }

    public void addCategories(Category... categories) {
        for(Category category : categories) {
            if(!this.categories.contains(category)) {
                this.categories.add(category);
            }
        }
    }
}