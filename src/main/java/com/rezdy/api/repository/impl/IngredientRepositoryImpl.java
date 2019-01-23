package com.rezdy.api.repository.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import com.rezdy.api.model.Ingredient;
import com.rezdy.api.repository.IngredientRepository;
import com.rezdy.api.util.DateUtils;

/**
 * It is a implementation of {@link IngredientRepository}.
 * 
 * @author junfeng
 *
 */
@Repository
public class IngredientRepositoryImpl implements IngredientRepository {

  @Autowired
  @Qualifier("ingredientsFromJson")
  private List<Ingredient> ingredients;

  /**
   * {@inheritDoc}
   */
  @Override
  public List<Ingredient> findAll() {
    return ingredients;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Ingredient findByTitle(String title) {
    return ingredients.stream().filter(ingredient -> ingredient.getTitle().equals(title))
        .findFirst().orElse(null);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public List<Ingredient> findIngredientsBeforeUseBy() {
    LocalDate today = LocalDate.now();
    return ingredients.stream()
        .filter(ingredient -> today.isBefore(DateUtils.toDate(ingredient.getUseBy())))
        .collect(Collectors.toList());
  }

}
