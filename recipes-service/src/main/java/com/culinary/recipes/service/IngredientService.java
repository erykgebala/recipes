package com.culinary.recipes.service;

import com.culinary.recipes.domain.Ingredient;
import com.culinary.recipes.dto.IngredientDto;

import java.util.List;

public interface IngredientService {
    List<Ingredient> getAll();
}
