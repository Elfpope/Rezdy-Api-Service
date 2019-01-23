package com.rezdy.api.repository.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import com.rezdy.api.model.Recipe;
import com.rezdy.api.repository.RecipeRepository;

/**
 * It is a implementation of {@link RecipeRepository}.
 * 
 * @author junfeng
 *
 */
@Repository
public class RecipeRepositoryImpl implements RecipeRepository {

  @Autowired
  @Qualifier("recipesFromJson")
  private List<Recipe> recipes;

  /**
   * {@inheritDoc}
   */
  @Override
  public List<Recipe> findAll() {
    return recipes;
  }
}
