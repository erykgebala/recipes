package com.culinary.recipes.service;

import com.culinary.recipes.domain.Ingredient;
import com.culinary.recipes.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientServiceImpl implements IngredientService {

    @Autowired
    IngredientRepository ingredientRepository;

    public List<Ingredient> getAll() {
        return (List<Ingredient>) ingredientRepository.findAll();
    }
}
