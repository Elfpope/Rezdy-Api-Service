package com.rezdy.api;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import com.rezdy.api.model.Ingredient;
import com.rezdy.api.model.Recipe;
import com.rezdy.api.repository.IngredientRepository;
import com.rezdy.api.repository.impl.IngredientRepositoryImpl;
import com.rezdy.api.repository.impl.RecipeRepositoryImpl;
import com.rezdy.api.util.Constants;
import com.rezdy.api.util.JsonUtils;

/**
 * It is responsible for starting up the application and data initialization.
 * 
 * @author junfeng
 *
 */
@SpringBootApplication
public class RezdyApiServiceApplication {
  private static Logger LOG = LoggerFactory.getLogger(RezdyApiServiceApplication.class);

  @Value("classpath:${ingredients.file.source}")
  private Resource ingredientsFileSource;

  @Value("classpath:${recipes.file.source}")
  private Resource recipesFileSource;

  /**
   * Spring boot application entry point
   * 
   * @param args passed in via CLI
   */
  public static void main(String[] args) {
    ApplicationContext context = SpringApplication.run(RezdyApiServiceApplication.class, args);

    IngredientRepository ingredientRepo = context.getBean(IngredientRepositoryImpl.class);
    LOG.debug("ingredients from REPO: " + ingredientRepo.findAll().toString());

    RecipeRepositoryImpl recipeRepo = context.getBean(RecipeRepositoryImpl.class);
    LOG.debug("recipes from REPO: " + recipeRepo.findAll().toString());
  }

  /**
   * Load ingredient data from file "ingredients.json"
   * 
   * @return a list of {@link Ingredient} loaded from file "ingredients.json"
   */
  @Bean(name = "ingredientsFromJson")
  public List<Ingredient> getIngredientsFromJson() {
    return JsonUtils.getDataFromJson(ingredientsFileSource, Constants.INGREDIENTS_KEY,
        Ingredient.class);
  }

  /**
   * Load recipe data from file "recipes.json"
   * 
   * @return a list of {@link Recipe} loaded from file "recipes.json"
   */
  @Bean(name = "recipesFromJson")
  public List<Recipe> getRecipesFromJson() {
    return JsonUtils.getDataFromJson(recipesFileSource, Constants.RECIPES_KEY, Recipe.class);
  }

}

