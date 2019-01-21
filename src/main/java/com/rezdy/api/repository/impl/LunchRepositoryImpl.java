package com.rezdy.api.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.rezdy.api.model.Ingredient;
import com.rezdy.api.model.Recipe;
import com.rezdy.api.repository.IngredientRepository;
import com.rezdy.api.repository.LunchRepository;
import com.rezdy.api.repository.RecipeRepository;

@Repository
public class LunchRepositoryImpl implements LunchRepository {

  @Autowired
  private IngredientRepository ingredientRepo;

  @Autowired
  private RecipeRepository recipeRepo;

  @Override
  public List<Recipe> findRecipesIfIngredientsAvailable() {
    List<Recipe> result = new ArrayList<>();

    for (Recipe recipe : recipeRepo.findAll()) {
      boolean hasAllIngredients = true;
      for (Ingredient ing : recipe.getIngredients()) {
        if (ingredientRepo.findByTitle(ing.getTitle()) == null) {
          hasAllIngredients = false;
          break;
        }
      }

      if (hasAllIngredients) {
        result.add(recipe);
      }
    }

    return result;
  }

  @Override
  public List<Recipe> findRecipesBeforeUseBy() {
    List<Recipe> result = new ArrayList<>();
    List<Recipe> availableRecipes = findRecipesIfIngredientsAvailable();

    List<String> ingredientsBeforeUseBy = ingredientRepo.findIngredientsBeforeUseBy().stream()
        .map(Ingredient::getTitle).collect(Collectors.toList());

    for (Recipe recipe : availableRecipes) {
      boolean beforeUseBy = true;
      for (Ingredient ingredient : recipe.getIngredients()) {
        if (!ingredientsBeforeUseBy.contains(ingredient.getTitle())) {
          beforeUseBy = false;
          break;
        }
      }

      if (beforeUseBy) {
        result.add(recipe);
      }
    }
    return result;
  }

  @Override
  public List<Recipe> findRecipesBetweenBestBeforeAndUseBy() {
    List<Recipe> recipesBeforeUseBy = findRecipesBeforeUseBy();

    // Comparator to sort

    /*
     * List<Recipe> result = new ArrayList<>(); for (Recipe recipe : recipesBeforeUseBy) { boolean
     * beforeUseBy = true; for (Ingredient ingredient : recipe.getIngredients()) { if
     * (!ingredientsBeforeUseBy.contains(ingredient.getTitle())) { beforeUseBy = false; break; } }
     * 
     * if (beforeUseBy) { result.add(recipe); } } return result;
     */

    return null;
  }

}
