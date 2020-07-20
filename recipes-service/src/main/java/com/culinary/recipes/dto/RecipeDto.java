package com.culinary.recipes.dto;

import com.culinary.recipes.domain.Ingredient;
import lombok.Data;

import java.util.List;

@Data
public class RecipeDto {
    private Long id;
    private String title;
    private String note;
    private Integer time;
    private List<IngredientDto> ingredients;
    private List<String> categories;

    private List<Ingredient> allIngredients;
}
