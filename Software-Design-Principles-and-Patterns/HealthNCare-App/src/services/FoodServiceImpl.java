package services;

import java.util.ArrayList;
import java.util.List;

import models.BasicFood;
import models.Ingredients;
import models.NutritionFacts;
import models.Recipe;
import utils.DataUtil;

public class FoodServiceImpl implements FoodServiceInterface {
  private static final String FOODS_CSV = "data/foods.csv";
  DataUtil dataUtil = new DataUtil();

  @Override
  public List<BasicFood> getBasicFoods() {
    List<BasicFood> basicFoods = new ArrayList<>();
    for (String line : dataUtil.getLines(FOODS_CSV)) {
      if (line.startsWith("b")) {
        String[] parts = line.split(",");
        String name = parts[1];
        double calories = Double.parseDouble(parts[2]);
        double fat = Double.parseDouble(parts[3]);
        double carbohydrates = Double.parseDouble(parts[4]);
        double protein = Double.parseDouble(parts[5]);
        double sodium = Double.parseDouble(parts[6]);
        BasicFood basicFood = new BasicFood(name, new NutritionFacts(calories, fat, carbohydrates, protein, sodium));
        basicFoods.add(basicFood);
      }
    }
    return basicFoods;
  }

  @Override
  public BasicFood getBasicFood(String foodName) {
    BasicFood basicFood = new BasicFood();
    for (String line : dataUtil.getLines(FOODS_CSV)) {
      if (line.startsWith("b," + foodName + ",")) {
        String[] parts = line.split(",");
        String name = parts[1];
        double calories = Double.parseDouble(parts[2]);
        double fat = Double.parseDouble(parts[3]);
        double carbohydrates = Double.parseDouble(parts[4]);
        double protein = Double.parseDouble(parts[5]);
        double sodium = Double.parseDouble(parts[6]);
        basicFood = new BasicFood(name, new NutritionFacts(calories, fat, carbohydrates, protein, sodium));
      }
    }
    return basicFood;
  }

  @Override
  public void createBasicFood(BasicFood newFood) {
    String line = String.format("b,%s,%.1f,%.1f,%.1f,%.1f,%.1f",
        newFood.getName(),
        newFood.getNutritionFacts().getCalories(),
        newFood.getNutritionFacts().getFat(),
        newFood.getNutritionFacts().getCarbohydrates(),
        newFood.getNutritionFacts().getProtein(),
        newFood.getNutritionFacts().getSodium());
    dataUtil.createLine(FOODS_CSV, line);
  }

  @Override
  public List<Recipe> getRecipes() {
    List<Recipe> recipes = new ArrayList<>();
    for (String line : dataUtil.getLines(FOODS_CSV)) {
      if (line.startsWith("r")) {
        String[] parts = line.split(",");
        String name = parts[1];
        List<Ingredients> ingredients = new ArrayList<>();
        for (int i = 2; i < parts.length; i += 2) {
          String ingredientName = parts[i];
          double ingredientQuantity = Double.parseDouble(parts[i + 1]);
          BasicFood food = getBasicFood(ingredientName);
          Ingredients ingredient = new Ingredients(food, ingredientQuantity);
          ingredients.add(ingredient);
        }
        Recipe recipe = new Recipe(name, ingredients.toArray(new Ingredients[0]));
        recipes.add(recipe);
      }
    }
    return recipes;
  }

  @Override
  public Recipe getRecipe(String recipeName) {
    Recipe recipe = new Recipe();
    for (String line : dataUtil.getLines(FOODS_CSV)) {
      if (line.startsWith("r")) {
        if (line.startsWith("r," + recipeName + ",")) {
          String[] parts = line.split(",");
          String name = parts[1];
          List<Ingredients> ingredients = new ArrayList<>();
          for (int i = 2; i < parts.length; i += 2) {
            String ingredientName = parts[i];
            double ingredientQuantity = Double.parseDouble(parts[i + 1]);
            BasicFood food = getBasicFood(ingredientName);
            Ingredients ingredient = new Ingredients(food, ingredientQuantity);
            ingredients.add(ingredient);
          }
          recipe = new Recipe(name, ingredients.toArray(new Ingredients[0]));
        }
      }
    }
    return recipe;
  }

  @Override
  public void createRecipe(Recipe newRecipe) {
    StringBuilder line = new StringBuilder("r," + newRecipe.getName() + ",");
    for (Ingredients ingredient : newRecipe.getIngredients()) {
      line.append(ingredient.getFood().getName()).append(",").append(ingredient.getQuantity()).append(",");
    }
    dataUtil.createLine(FOODS_CSV, line.toString());
  }

}