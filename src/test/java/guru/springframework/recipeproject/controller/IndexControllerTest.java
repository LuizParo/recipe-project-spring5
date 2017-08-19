package guru.springframework.recipeproject.controller;

import static com.google.common.collect.Sets.newHashSet;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.ModelAndView;

import guru.springframework.recipeproject.domain.Difficulty;
import guru.springframework.recipeproject.domain.Recipe;
import guru.springframework.recipeproject.service.RecipeService;

@RunWith(MockitoJUnitRunner.class)
public class IndexControllerTest {

    @InjectMocks
    private IndexController indexController;

    @Mock
    private RecipeService recipeService;

    @Test
    public void getIndexPage() {
        Iterable<Recipe> recipes = newHashSet(this.createRecipe());
        when(this.recipeService.getRecipes()).thenReturn(recipes);

        ModelAndView modelAndView = this.indexController.index();
        assertEquals("index", modelAndView.getViewName());
    }

    @Test
    public void testMockMvc() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(this.indexController).build();
        mockMvc.perform(get("/"))
            .andExpect(status().isOk())
            .andExpect(view().name("index"));
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