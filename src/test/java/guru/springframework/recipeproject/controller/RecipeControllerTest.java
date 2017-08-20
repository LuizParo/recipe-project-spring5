package guru.springframework.recipeproject.controller;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import guru.springframework.recipeproject.domain.Difficulty;
import guru.springframework.recipeproject.domain.Recipe;
import guru.springframework.recipeproject.service.RecipeService;

@RunWith(MockitoJUnitRunner.class)
public class RecipeControllerTest {

    @InjectMocks
    private RecipeController recipeController;

    @Mock
    private RecipeService recipeService;

    @Test
    public void testGetRecipe() throws Exception {
        Recipe recipe = this.createRecipe();

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(this.recipeController).build();

        when(this.recipeService.findById(anyLong())).thenReturn(Optional.of(recipe));

        mockMvc.perform(get("/recipes/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("recipe/show"));
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