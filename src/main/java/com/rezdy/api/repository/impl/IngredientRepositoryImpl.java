package com.rezdy.api.repository.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import com.rezdy.api.model.Ingredient;
import com.rezdy.api.repository.IngredientRepository;

@Repository
public class IngredientRepositoryImpl implements IngredientRepository {

  @Autowired
  @Qualifier("ingredientsFromJson")
  private List<Ingredient> ingredients;

  @Override
  public List<Ingredient> findAll() {
    return ingredients;
  }

}
