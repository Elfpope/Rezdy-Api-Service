package com.rezdy.api.repository;

import java.util.List;
import com.rezdy.api.model.Ingredient;


public interface IngredientRepository {
  List<Ingredient> findAll();

  Ingredient findByTitle(String title);

  List<Ingredient> findIngredientsBeforeUseBy();

}
