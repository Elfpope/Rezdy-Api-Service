package com.rezdy.api.model;

import java.util.List;

public class Recipe {
  private String title;
  private List<Ingredient> ingredients;

  /**
   * @return the title
   */
  public String getTitle() {
    return title;
  }

  /**
   * @param title the title to set
   */
  public void setTitle(String title) {
    this.title = title;
  }

  /**
   * @return the ingredients
   */
  public List<Ingredient> getIngredients() {
    return ingredients;
  }

  /**
   * @param ingredients the ingredients to set
   */
  public void setIngredients(List<Ingredient> ingredients) {
    this.ingredients = ingredients;
  }

  @Override
  public String toString() {
    return String.format("[tilte: %s, ingredients: %s]", title, ingredients.toString());
  }
}
