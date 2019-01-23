package com.rezdy.api.repository;

import java.util.List;
import com.rezdy.api.model.Recipe;

/**
 * Provide persistent layer gateway to {@link Recipe} data.
 * 
 * @author junfeng
 *
 */
public interface RecipeRepository {

  /**
   * Find all recipes.
   * 
   * @return all recipes
   */
  List<Recipe> findAll();
}
