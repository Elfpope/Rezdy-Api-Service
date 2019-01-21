package com.rezdy.api.repository;

import java.util.List;
import com.rezdy.api.model.Recipe;

public interface LunchRepository {
  List<Recipe> findRecipesIfIngredientsAvailable();

  List<Recipe> findRecipesBeforeUseBy();

  List<Recipe> findRecipesBetweenBestBeforeAndUseBy();
}
