package services;

import java.util.List;

import models.BasicFood;
import models.Recipe;

public class FoodService {
  FoodServiceInterface foodService = new FoodServiceImpl();

  public List<BasicFood> getBasicFoods() {
    return foodService.getBasicFoods();
  }

  public BasicFood getBasicFood(String foodName) {
    return foodService.getBasicFood(foodName);
  }

  public void createBasicFood(BasicFood newFood) {
    foodService.createBasicFood(newFood);
  }

  public List<Recipe> getRecipes() {
    return foodService.getRecipes();
  }

  public Recipe getRecipe(String recipeName) {
    return foodService.getRecipe(recipeName);
  }

  public void createRecipe(Recipe newRecipe) {
    foodService.createRecipe(newRecipe);
  }

}
