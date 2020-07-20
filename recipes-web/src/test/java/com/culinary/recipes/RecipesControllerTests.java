package com.culinary.recipes;

import com.culinary.recipes.dto.RecipeDto;
import com.culinary.recipes.service.RecipeService;
import com.culinary.recipes.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@WebMvcTest
class RecipesControllerTests {

    @Autowired
    protected MockMvc mockMvc;

    @MockBean
    RecipeService recipeService;

    @MockBean
    UserService userService;

    @Test
    void getAllRecipesTest() throws Exception {
        RecipeDto recipe = new RecipeDto();
        recipe.setTitle("Test");
        RecipeDto recipe2 = new RecipeDto();
        recipe2.setTitle("Test 2");
        List<RecipeDto> recipes = Arrays.asList(recipe, recipe2);
        when(recipeService.getAll()).thenReturn(recipes);


        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/recipes")
                .with(user("a").password("123").roles("USER","ADMIN")))
                .andExpect(status().isOk())
                .andReturn();

        ModelAndView modelAndView = mvcResult.getModelAndView();
        assertEquals(modelAndView.getModel().get("recipes"), recipes);
    }

    @Test
    void getRecipeTest() throws Exception {
        RecipeDto recipe = new RecipeDto();
        recipe.setId(1L);
        recipe.setTitle("Test");
        when(recipeService.getRecipe(1L)).thenReturn(recipe);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/recipes/" + 1)
                .with(user("b").password("123").roles("ADMIN")))
                .andExpect(status().isOk())
                .andReturn();

        ModelAndView modelAndView = mvcResult.getModelAndView();
        assertEquals(modelAndView.getModel().get("recipe"), recipe);
    }

    void saveRecipeTest() throws Exception {
        RecipeDto recipeDto = new RecipeDto();


        when(recipeService.saveRecipe(recipeDto)).thenReturn(recipeDto);
    }
}
