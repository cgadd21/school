package services;

import java.util.List;

import models.BasicFood;
import models.Recipe;

public interface FoodServiceInterface {
  List<BasicFood> getBasicFoods();

  BasicFood getBasicFood(String foodName);

  void createBasicFood(BasicFood newFood);

  List<Recipe> getRecipes();

  Recipe getRecipe(String recipeName);

  void createRecipe(Recipe newRecipe);
}
