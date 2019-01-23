package com.rezdy.api.model.comparator;

import java.time.LocalDate;
import java.time.Period;
import java.util.Comparator;
import org.springframework.util.StringUtils;
import com.rezdy.api.model.Recipe;
import com.rezdy.api.util.DateUtils;

/**
 * It encapsulates custom comparison logic for {@link Recipe}.
 * 
 * @author junfeng
 *
 */
public class RecipeComparatorByIngredientBestBefore implements Comparator<Recipe> {

  /**
   * Compare the two given recipes by comparing the total past-best-before days of each ingredient
   * in the recipe. If all ingredients of both recipes are before best-before-date, then compare
   * their titles instead.
   */
  @Override
  public int compare(Recipe recipe1, Recipe recipe2) {
    int daysPastBestBefore1 = getDaysAfterBestBefore(recipe1);
    int daysPastBestBefore2 = getDaysAfterBestBefore(recipe2);

    return daysPastBestBefore1 == daysPastBestBefore2
        ? recipe1.getTitle().compareTo(recipe2.getTitle())
        : daysPastBestBefore1 - daysPastBestBefore2;
  }

  private int getDaysAfterBestBefore(Recipe recipe) {
    LocalDate today = LocalDate.now();
    return recipe.getIngredients().stream()
        .filter(ingredient -> !StringUtils.isEmpty(ingredient.getBestBefore()))
        .map(ingredient -> DateUtils.toDate(ingredient.getBestBefore()))
        .filter(bestBefore -> bestBefore.isBefore(today))
        .mapToInt(bestBefore -> Period.between(bestBefore, today).getDays()).sum();
  }
}

