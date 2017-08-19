package guru.springframework.recipeproject.service;

import static com.google.common.collect.Sets.newHashSet;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import guru.springframework.recipeproject.domain.Difficulty;
import guru.springframework.recipeproject.domain.Recipe;
import guru.springframework.recipeproject.repository.RecipeRepository;

@RunWith(MockitoJUnitRunner.class)
public class RecipeServiceTest {

    @InjectMocks
    private RecipeService recipeService;

    @Mock
    private RecipeRepository recipeRepository;

    @Test
    public void getRecipes() {
        Recipe recipe = this.createRecipe();

        when(this.recipeRepository.findAll()).thenReturn(newHashSet(recipe));
        Iterable<Recipe> recipes = this.recipeService.getRecipes();

        verify(this.recipeRepository, only()).findAll();
        assertEquals(1, ((Collection<Recipe>) recipes).size());
    }

    private Recipe createRecipe() {
        return new Recipe(
                "test",
                1,
                1,
                1,
                "",
                "",
                "",
                new Byte[0],
                Difficulty.EASY
            );
    }
}