package guru.springframework.recipeproject.service;

import static com.google.common.collect.Sets.newHashSet;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collection;
import java.util.Optional;

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

    @Test
    public void getRecipeById() throws Exception {
        Recipe recipe = this.createRecipe();
        Optional<Recipe> recipeOptional = Optional.of(recipe);

        when(this.recipeRepository.findById(anyLong())).thenReturn(recipeOptional);

        Optional<Recipe> recipeReturned = this.recipeService.findById(1L);

        assertNotNull("Null recipe returned", recipeReturned);
        assertTrue(recipeReturned.isPresent());
        verify(this.recipeRepository, times(1)).findById(anyLong());
        verify(this.recipeRepository, never()).findAll();
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