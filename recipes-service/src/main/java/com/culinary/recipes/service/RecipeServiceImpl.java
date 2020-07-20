package com.culinary.recipes.service;

import com.culinary.recipes.converter.RecipeConverter;
import com.culinary.recipes.domain.Recipe;
import com.culinary.recipes.dto.RecipeDto;
import com.culinary.recipes.repository.RecipeRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RecipeServiceImpl implements RecipeService {

    private RecipeRepository recipeRepository;
    private RecipeConverter recipeConverter;


    public RecipeServiceImpl(RecipeRepository recipeRepository,
                             RecipeConverter recipeConverter) {
        this.recipeRepository = recipeRepository;
        this.recipeConverter = recipeConverter;
    }

    @Transactional
    public List<RecipeDto> getAll() {
        return this.recipeConverter.toDto((List<Recipe>) this.recipeRepository.findAll());
    }

    @Transactional
    public RecipeDto getRecipe(Long id) {
        return this.recipeConverter.toDto(this.recipeRepository.findById(id).orElseThrow(IllegalArgumentException::new));
    }

    @Override
    public RecipeDto saveRecipe(RecipeDto recipeDto) {
        return null;
    }
}
