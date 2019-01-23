package com.rezdy.api.model.comparator;

import static org.hamcrest.CoreMatchers.is;
import java.util.Arrays;
import java.util.Comparator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import com.rezdy.api.model.Ingredient;
import com.rezdy.api.model.Recipe;

/**
 * Test {@link RecipeComparatorByIngredientBestBefore}
 * 
 * @author junfeng
 *
 */
public class TestRecipeComparatorByIngredientBestBefore {

  private Ingredient superFreshIngredient;
  private Ingredient freshIngredient;
  private Ingredient lessFreshIngredient;
  private Ingredient smellingIngredient;

  private Recipe recipe1;
  private Recipe recipe2;

  private Comparator<Recipe> comparator = new RecipeComparatorByIngredientBestBefore();

  @Before
  public void setup() {
    superFreshIngredient = new Ingredient();
    superFreshIngredient.setBestBefore("2019-03-30");

    freshIngredient = new Ingredient();
    freshIngredient.setBestBefore("2019-02-28");

    lessFreshIngredient = new Ingredient();
    lessFreshIngredient.setBestBefore("2019-01-20");

    smellingIngredient = new Ingredient();
    smellingIngredient.setBestBefore("2018-12-10");

    recipe1 = new Recipe();
    recipe1.setTitle("xyz");

    recipe2 = new Recipe();
    recipe2.setTitle("abc");
  }

  /**
   * Test {@link RecipeComparatorByIngredientBestBefore#compare(Recipe, Recipe)}
   * 
   * Cover scenario: if ingredients of the recipe are fresher than ingredients of the other one,
   * then fresher recipe comes first
   */
  @Test
  public void testCompare_whenRecipeHasIngredientPastBestBefore() {
    recipe1.setIngredients(Arrays.asList(superFreshIngredient, lessFreshIngredient));
    recipe2.setIngredients(Arrays.asList(freshIngredient, smellingIngredient));
    Assert.assertThat(comparator.compare(recipe1, recipe2) < 0, is(true));

    recipe1.setIngredients(Arrays.asList(superFreshIngredient, smellingIngredient));
    recipe2.setIngredients(Arrays.asList(freshIngredient, lessFreshIngredient));
    Assert.assertThat(comparator.compare(recipe1, recipe2) > 0, is(true));
  }

  /**
   * Test {@link RecipeComparatorByIngredientBestBefore#compare(Recipe, Recipe)}
   * 
   * Cover scenario: if ingredients of the both recipes are at the same level of freshness then
   * compare their titles
   */
  @Test
  public void testCompare_whenSameFreshness() {
    recipe1.setIngredients(Arrays.asList(superFreshIngredient, lessFreshIngredient));
    recipe2.setIngredients(Arrays.asList(superFreshIngredient, lessFreshIngredient));
    Assert.assertThat(comparator.compare(recipe1, recipe2) > 0, is(true));
  }

}
