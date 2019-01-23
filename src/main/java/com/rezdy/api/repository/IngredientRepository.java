package com.rezdy.api.repository;

import java.util.List;
import com.rezdy.api.model.Ingredient;

/**
 * Provide persistent layer gateway to {@link Ingredient} data.
 * 
 * @author junfeng
 *
 */
public interface IngredientRepository {

  /**
   * Find all ingredients.
   * 
   * @return all ingredients
   */
  List<Ingredient> findAll();

  /**
   * Find an ingredient matching the given title.
   * 
   * @param title ingredient title to match
   * @return an ingredient matching the given title
   */
  Ingredient findByTitle(String title);

  /**
   * Find a collection of ingredients that are not past the use-by date.
   * 
   * @return a collection of ingredients that are not past the use-by date
   */
  List<Ingredient> findIngredientsBeforeUseBy();

}
