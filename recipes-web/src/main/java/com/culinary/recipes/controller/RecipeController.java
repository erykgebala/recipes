package com.culinary.recipes.controller;

import com.culinary.recipes.dto.RecipeDto;
import com.culinary.recipes.service.RecipeService;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api")
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping(value = "/recipes")
    public String getRecipes(Model model) {
        model.addAttribute("recipes", recipeService.getAll());
        return "recipes";
    }

    @Secured({"ROLE_ADMIN"})
    @GetMapping(value = "/recipes/{id}")
    public String getRecipe(Model model, @PathVariable Long id) {
        model.addAttribute("recipe", recipeService.getRecipe(id));
        return "recipe";
    }

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @PostMapping(value = "/recipes")
    public String saveRecipe(Model model, @RequestBody RecipeDto recipeDto) {
        model.addAttribute("recipe", recipeService.saveRecipe(recipeDto));
        return "recipe";
    }
}
