package com.rezdy.api.model.comparator;

import java.time.LocalDate;
import java.time.Period;
import java.util.Comparator;
import com.rezdy.api.model.Recipe;
import com.rezdy.api.util.DateUtils;

public class RecipeComparatorByIngredientBestBefore implements Comparator<Recipe> {

  @Override
  public int compare(Recipe recipe1, Recipe recipe2) {
    int daysPastBestBefore1 = getDaysAfterBestBefore(recipe1);
    int daysPastBestBefore2 = getDaysAfterBestBefore(recipe2);
    return daysPastBestBefore1 - daysPastBestBefore2;
  }

  private int getDaysAfterBestBefore(Recipe recipe) {
    LocalDate today = LocalDate.now();
    return recipe.getIngredients().stream()
        .map(ingredient -> DateUtils.toDate(ingredient.getBestBefore()))
        .filter(bestBefore -> bestBefore.isBefore(today))
        .mapToInt(bestBefore -> Period.between(bestBefore, today).getDays()).sum();
  }
}

