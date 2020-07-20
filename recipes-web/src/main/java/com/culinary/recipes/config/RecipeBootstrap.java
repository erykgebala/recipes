package com.culinary.recipes.config;

import com.culinary.recipes.domain.*;
import com.culinary.recipes.repository.IngredientRepository;
import com.culinary.recipes.repository.RecipeRepository;
import com.culinary.recipes.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@Component
public class RecipeBootstrap implements CommandLineRunner {

    @Autowired
    RecipeRepository recipeRepository;

    @Autowired
    IngredientRepository ingredientRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        User user = new User();
        user.setLogin("a");
        user.setPassword(passwordEncoder.encode("123"));
        user.setRole("ROLE_ADMIN");
        userRepository.save(user);

        User user2 = new User();
        user2.setLogin("b");
        user2.setPassword(passwordEncoder.encode("123"));
        user2.setRole("ROLE_USER");
        userRepository.save(user2);

        addRecipeWithIngredient();
        addRecipeWithIngredient2();
        recipeRepository.findAll().forEach(System.out::println);
    }

    private void addRecipeWithIngredient() {
        Note note = new Note();
        note.setDescription("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");

        Recipe recipe = new Recipe();
        recipe.setTitle("Pizza");
        recipe.setNote(note);
        recipe.setCategories(addCategory());
        recipeRepository.save(recipe);

        Ingredient ingredient = new Ingredient();
        ingredient.setName("3 x jajka");
        ingredient.setType(IngredientType.EGG);
        ingredient.setRecipe(recipe);
        ingredientRepository.save(ingredient);

        Ingredient ingredient2 = new Ingredient();
        ingredient2.setName("100 ml mleka");
        ingredient2.setType(IngredientType.MILK);
        ingredient2.setRecipe(recipe);
        ingredientRepository.save(ingredient2);
    }

    private List<Category> addCategory() {
        Category category = new Category();
        category.setName("Deser");
        return Arrays.asList(category);
    }

    private void addRecipeWithIngredient2() {
        Note note = new Note();
        note.setDescription("Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur");

        Recipe recipe = new Recipe();
        recipe.setTitle("Nalesniki");
        recipe.setNote(note);
        recipe.setCategories(addCategory());
        recipeRepository.save(recipe);

        Ingredient ingredient = new Ingredient();
        ingredient.setName("2 x jajka");
        ingredient.setType(IngredientType.EGG);
        ingredient.setRecipe(recipe);
        ingredientRepository.save(ingredient);

        Ingredient ingredient2 = new Ingredient();
        ingredient2.setName("200 ml mleka");
        ingredient2.setType(IngredientType.MILK);
        ingredient2.setRecipe(recipe);
        ingredientRepository.save(ingredient2);

        Ingredient ingredient3 = new Ingredient();
        ingredient3.setName("150 ml wody");
        ingredient3.setType(IngredientType.WATER);
        ingredient3.setRecipe(recipe);
        ingredientRepository.save(ingredient3);

        Ingredient ingredient4 = new Ingredient();
        ingredient4.setName("1 lyzeczka cukru");
        ingredient4.setType(IngredientType.SUGAR);
        ingredient4.setRecipe(recipe);
        ingredientRepository.save(ingredient4);
    }
}
