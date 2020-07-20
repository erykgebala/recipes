package com.culinary.recipes.service;

import com.culinary.recipes.dto.RecipeDto;

import java.util.List;

public interface RecipeService {

    List<RecipeDto> getAll();

    RecipeDto getRecipe(Long id);

    RecipeDto saveRecipe(RecipeDto recipeDto);
}
