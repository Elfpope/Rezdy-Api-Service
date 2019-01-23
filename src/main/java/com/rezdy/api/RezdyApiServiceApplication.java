package com.rezdy.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rezdy.api.model.Ingredient;
import com.rezdy.api.model.Recipe;

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
    SpringApplication.run(RezdyApiServiceApplication.class, args);
  }

  /**
   * Load ingredient data from file "ingredients.json"
   * 
   * @return a list of {@link Ingredient} loaded from file "ingredients.json"
   */
  @Bean(name = "ingredientsFromJson")
  public List<Ingredient> getIngredientsFromJson() {
    Map<String, List<Ingredient>> allIngredients = new HashMap<>();
    ObjectMapper mapper = new ObjectMapper();
    try {
      allIngredients = mapper.readValue(ingredientsFileSource.getInputStream(),
          new TypeReference<Map<String, List<Ingredient>>>() {});
    } catch (IOException exception) {
      LOG.error("Encountered an error when loading ingredients.json");
      exception.printStackTrace();
    }

    LOG.debug("all ingredients: " + allIngredients.toString());

    return allIngredients.getOrDefault("ingredients", new ArrayList<>());
  }

  /**
   * Load recipe data from file "recipes.json"
   * 
   * @return a list of {@link Recipe} loaded from file "recipes.json"
   */
  @Bean(name = "recipesFromJson")
  public List<Recipe> getRecipesFromJson() {
    Map<String, List<Recipe>> allRecipes = new HashMap<>();
    ObjectMapper mapper = new ObjectMapper();
    try {
      allRecipes = mapper.readValue(recipesFileSource.getInputStream(),
          new TypeReference<Map<String, List<Recipe>>>() {});
    } catch (IOException exception) {
      LOG.error("Encountered an error when loading recipes.json");
      exception.printStackTrace();
    }

    LOG.debug("all recipes: " + allRecipes.toString());

    return allRecipes.getOrDefault("recipes", new ArrayList<>());
  }

}

