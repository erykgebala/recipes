package com.culinary.recipes;

import com.culinary.recipes.converter.RecipeConverter;
import com.culinary.recipes.domain.Recipe;
import com.culinary.recipes.dto.RecipeDto;
import com.culinary.recipes.repository.RecipeRepository;
import com.culinary.recipes.service.RecipeService;
import com.culinary.recipes.service.RecipeServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.annotation.Profile;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RecipesServiceTests {

    @Mock
    RecipeRepository recipeRepository;

    @Mock
    RecipeConverter recipeConverter;

    RecipeService recipeService;

    @Test
    void contextLoads() {
        this.recipeService = new RecipeServiceImpl(recipeRepository, recipeConverter);
        Recipe recipe = new Recipe();
        recipe.setTitle("Test");

        RecipeDto recipeDto = new RecipeDto();
        recipeDto.setTitle("Test");
        when(recipeRepository.findAll()).thenReturn(Arrays.asList(recipe));
        when(recipeConverter.toDto(Arrays.asList(recipe))).thenReturn(Arrays.asList(recipeDto));
        assertEquals(1, recipeService.getAll().size());
    }
}
