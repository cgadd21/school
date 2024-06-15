package views;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import controllers.HealthNCareController;
import models.BasicFood;
import models.ExerciseLog;
import models.FoodLog;
import models.Ingredients;
import models.NutritionFacts;
import models.Recipe;

public class ConsoleView {
  HealthNCareController healthNCareController = new HealthNCareController();

  public ConsoleView() {
    try (Scanner input = new Scanner(System.in)) {
      while (true) {
        System.out.println(
            "Available commands: 1 - view log, 2 - view recipe, 3 - add food, 4 - add recipe, 5 - remove food item, 6 - exit");
        int choice = input.nextInt();

        switch (choice) {
          case 1:
            System.out.println("Which log would you like to view ? (1 - Weight, 2 - Calorie, 3 - Food, 4 - Excercise)");
            int logChoice = input.nextInt();
            String date;
            switch (logChoice) {
              case 1:
                System.out.println(healthNCareController.getWeightLog().getDate() + ": "
                    + healthNCareController.getWeightLog().getWeight());
                break;
              case 2:
                System.out.println(healthNCareController.getCalorieLimitLog().getDate() + ": "
                    + healthNCareController.getCalorieLimitLog().getCalorieLimit());
                break;
              case 3:
                System.out.println("Please enter the date you would like to view (m/d/yyyy):");
                date = input.next();
                List<FoodLog> foodLogs = healthNCareController.getFoodLogs(LocalDate.parse(date, DateTimeFormatter.ofPattern("M/d/yyyy")));
                for (FoodLog log : foodLogs) {
                  System.out.println(log.getFood());
                }
                break;
              case 4:
                System.out.println("Please enter the date you would like to view (m/d/yyyy):");
                date = input.next();
                List<ExerciseLog> exerLog = healthNCareController.getExerciseLogs(LocalDate.parse(date, DateTimeFormatter.ofPattern("M/d/yyyy")));
                for (ExerciseLog log : exerLog) {
                  System.out.println(log.getName() + " for " + log.getMinutes() + " Minutes");
                }
                break;
            }
            break;

          case 2:
            System.out.println("Recipes: ");
            List<Recipe> recipe = healthNCareController.getRecipes();
            for (Recipe log : recipe) {
              System.out.println(log.getName());
            }
            
            System.out.println("Which Recipe would you like to view?");
            input.nextLine();
            String selection = input.nextLine().trim();
            Recipe recipeIngredients = healthNCareController.getRecipe(selection);
            for (Ingredients ingredient : recipeIngredients.getIngredients()) {
              System.out.println(ingredient.getFood().getName());
              System.out.println(ingredient.getQuantity());
              System.out.println(ingredient.getFood().getNutritionFacts().getCalories());
            }
            break;

          case 3:
            System.out.println("Name: ");
            String name = input.next();
            System.out.println("Calories: ");
            double calories = input.nextDouble();
            System.out.println("Fat: ");
            double fat = input.nextDouble();
            System.out.println("Carbs: ");
            double carbs = input.nextDouble();
            System.out.println("Protein: ");
            double protein = input.nextDouble();
            System.out.println("Sodium: ");
            double sodium = input.nextDouble();
            BasicFood newFood = new BasicFood(name, new NutritionFacts(calories, fat, carbs, protein, sodium));
            healthNCareController.createBasicFood(newFood);
            break;

          case 4:
            System.out.println("Recipe Name: ");
            String nameRecipe = input.next();
            String inpt = " ";
            int ingredientnum = 1;
            List<Ingredients> ingredients = new ArrayList<>();

            System.out.println("Enter ingredients, type 'done' when you are finished");
            while (!inpt.equals("done")) {
              System.out.println("Ingredient " + ingredientnum + ": ");
              inpt = input.next();
              if (inpt.equals("done"))
                break;
              System.out.println("Quantity: ");
              int quan1 = input.nextInt();
              BasicFood ingredient = healthNCareController.getBasicFood(inpt);
              ingredients.add(new Ingredients(ingredient, quan1));
              ingredientnum++;
            }
            Recipe newRecipe = new Recipe(nameRecipe, ingredients.toArray(new Ingredients[0]));
            healthNCareController.createRecipe(newRecipe);
            break;

          case 5:
            int count = 1;
            int selectionDel = 1;
            System.out.println("Which Food Would you like to delete? If none type 0");
            List<FoodLog> foodLogs = healthNCareController.getFoodLogs(LocalDate.now());
            for (FoodLog log : foodLogs) {
              System.out.println(count + ": " + log.getFood());
              count++;
            }
            System.out.println("Selection: ");
            selectionDel = input.nextInt();

            List<FoodLog> foodLogSelection = healthNCareController.getFoodLogs(LocalDate.now());
            count = 1;
            for (FoodLog log : foodLogSelection) {
              if (selectionDel == count) {
                healthNCareController.deleteFoodLog(log);
              }
              count++;
            }
            break;

          case 6:
            System.out.println("Exiting...");
            return;
          default:
            System.out.println("Invalid choice");
            break;
        }
      }
    }
  }
}
