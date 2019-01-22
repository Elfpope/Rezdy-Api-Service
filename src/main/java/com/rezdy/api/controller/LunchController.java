package com.rezdy.api.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.rezdy.api.model.Recipe;
import com.rezdy.api.repository.LunchRepository;

@RestController
public class LunchController {

  @Autowired
  private LunchRepository lunchRepo;

  @GetMapping(value = "/lunch")
  public List<Recipe> getAvailableRecipes(
      @RequestParam(value = "use-by", required = false) boolean useBy,
      @RequestParam(value = "best-before", required = false) boolean bestBefore) {

    List<Recipe> result = new ArrayList<>();
    if (!useBy && !bestBefore) {
      result = lunchRepo.findRecipesIfIngredientsAvailable();
    } else if (useBy && !bestBefore) {
      result = lunchRepo.findRecipesBeforeUseBy();
    } else if (bestBefore) {
      result = lunchRepo.findRecipesBetweenBestBeforeAndUseBy();
    }
    return result;
  }

}
