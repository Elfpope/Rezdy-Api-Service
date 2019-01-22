package com.rezdy.api.repository;

import java.util.List;
import com.rezdy.api.model.Recipe;


public interface RecipeRepository {
  List<Recipe> findAll();
}
