package com.culinary.recipes.converter;

import com.culinary.recipes.domain.*;
import com.culinary.recipes.dto.IngredientDto;
import com.culinary.recipes.dto.RecipeDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class RecipeConverter implements AbstractConverter<Recipe, RecipeDto> {

    @Override
    public RecipeDto toDto(Recipe recipe) {
        RecipeDto dto = new RecipeDto();
        dto.setId(recipe.getId());
        dto.setTitle(recipe.getTitle());
        dto.setNote(recipe.getNote() != null ? recipe.getNote().getDescription() : null);
        dto.setTime(recipe.getTime());
        Stream<IngredientDto> ingredientDtoStream = recipe.getIngredients().stream().map((ingredient) -> {
            return new IngredientDto(ingredient.getName(), ingredient.getType().name());
        });
        dto.setIngredients(ingredientDtoStream.collect(Collectors.toList()));
        Stream<String> categoryStream = recipe.getCategories().stream().map(Category::getName);
        dto.setCategories(categoryStream.collect(Collectors.toList()));
        return dto;
    }

    @Override
    public List<RecipeDto> toDto(List<Recipe> domain) {
        return domain.stream().map(this::toDto).collect(Collectors.toList());
    }


    @Override
    public Recipe toDomain(RecipeDto recipeDto) {
        Recipe recipe = new Recipe();
        recipe.setId(recipeDto.getId());
        recipe.setTitle(recipeDto.getTitle());
        recipe.setTime(recipeDto.getTime());
        Note note = new Note();
        note.setDescription(recipeDto.getNote());
        recipe.setNote(note);

        Stream<Ingredient> ingredientStream = recipeDto.getIngredients().stream().map((ingredientDto) -> {
            Ingredient ingredient = new Ingredient();
            ingredient.setName(ingredientDto.getName());
            ingredient.setType(IngredientType.valueOf(ingredientDto.getType()));
            ingredient.setRecipe(recipe);
            return ingredient;
        });
        recipe.setIngredients(ingredientStream.collect(Collectors.toList()));

        Stream<Category> categoryStream = recipeDto.getCategories().stream().map(Category::new);
        recipe.setCategories(categoryStream.collect(Collectors.toList()));
        return recipe;
    }

    @Override
    public List<Recipe> toDomain(List<RecipeDto> dto) {
        return dto.stream().map(this::toDomain).collect(Collectors.toList());
    }
}
