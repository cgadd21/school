package controllers;

import java.time.LocalDate;
import java.util.List;

import models.BasicFood;
import models.CalorieLimitLog;
import models.Exercise;
import models.ExerciseLog;
import models.FoodLog;
import models.Recipe;
import models.WeightLog;
import services.DailyLogService;
import services.ExerciseService;
import services.FoodService;

public class HealthNCareController {
  DailyLogService dailyLogService = new DailyLogService();
  ExerciseService exerciseService = new ExerciseService();
  FoodService foodService = new FoodService();

  public WeightLog getWeightLog() {
    return dailyLogService.getWeightLog();
  }

  public void createWeightLog(WeightLog newWeightLog) {
    dailyLogService.createWeightLog(newWeightLog);
  }

  public void updateWeightLog(WeightLog deletedWeightLog, WeightLog updatedWeightLog) {
    dailyLogService.updateWeightLog(deletedWeightLog, updatedWeightLog);
  }

  public void deleteWeightLog(WeightLog deletedWeightLog) {
    dailyLogService.deleteWeightLog(deletedWeightLog);
  }

  public CalorieLimitLog getCalorieLimitLog() {
    return dailyLogService.getCalorieLimitLog();
  }

  public void createCalorieLimitLog(CalorieLimitLog newCalorieLimitLog) {
    dailyLogService.createCalorieLimitLog(newCalorieLimitLog);
  }

  public void updateCalorieLimitLog(CalorieLimitLog deletedCalorieLimitLog, CalorieLimitLog updatedCalorieLimitLog) {
    dailyLogService.updateCalorieLimitLog(deletedCalorieLimitLog, updatedCalorieLimitLog);
  }

  public void deleteCalorieLimitLog(CalorieLimitLog deletedCalorieLimitLog) {
    dailyLogService.deleteCalorieLimitLog(deletedCalorieLimitLog);
  }

  public List<FoodLog> getFoodLogs(LocalDate inputDate) {
    return dailyLogService.getFoodLogs(inputDate);
  }

  public void createFoodLog(FoodLog newFoodLog) {
    dailyLogService.createFoodLog(newFoodLog);
  }

  public void updateFoodLog(FoodLog deletedFoodLog, FoodLog updateFoodLog) {
    dailyLogService.updateFoodLog(deletedFoodLog, updateFoodLog);
  }

  public void deleteFoodLog(FoodLog deletedFoodLog) {
    dailyLogService.deleteFoodLog(deletedFoodLog);
  }

  public List<ExerciseLog> getExerciseLogs(LocalDate inputDate) {
    return dailyLogService.getExerciseLogs(inputDate);
  }

  public void createExerciseLog(ExerciseLog newExerciseLog) {
    dailyLogService.createExerciseLog(newExerciseLog);
  }

  public void updateExerciseLog(ExerciseLog deletedExerciseLog, ExerciseLog updatedExerciseLog) {
    dailyLogService.updateExerciseLog(deletedExerciseLog, updatedExerciseLog);
  }

  public void deleteExerciseLog(ExerciseLog deletedExerciseLog) {
    dailyLogService.deleteExerciseLog(deletedExerciseLog);
  }

  public List<Exercise> getExercises() {
    return exerciseService.getExercises();
  }

  public Exercise getExercise(String exerciseName) {
    return exerciseService.getExercise(exerciseName);
  }

  public void createExercise(Exercise newExercise) {
    exerciseService.createExercise(newExercise);
  }

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
