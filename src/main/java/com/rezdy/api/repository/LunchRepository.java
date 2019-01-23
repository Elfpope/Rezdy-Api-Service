package com.rezdy.api.repository;

import java.util.List;
import com.rezdy.api.model.Recipe;

/**
 * Provide persistent layer gateway to lunch data.
 * 
 * @author junfeng
 *
 */
public interface LunchRepository {
  /**
   * Find all recipes whose ingredients are all available.
   * 
   * @return all recipes whose ingredients are all available
   */
  List<Recipe> findRecipesIfIngredientsAvailable();

  /**
   * Find all recipes whose ingredients are all before the use-by date.
   * 
   * @return all recipes whose ingredients are all before the use-by date
   */
  List<Recipe> findRecipesBeforeUseBy();

  /**
   * Find all recipes whose ingredients are all between the best-before date and the use-by date.
   * 
   * @return all recipes whose ingredients are all between the best-before date and the use-by date.
   */
  List<Recipe> findRecipesBetweenBestBeforeAndUseBy();
}
