package services;

import java.time.LocalDate;
import java.util.List;

import models.CalorieLimitLog;
import models.ExerciseLog;
import models.FoodLog;
import models.WeightLog;

public interface DailyLogServiceInterface {
  WeightLog getWeightLog();

  void createWeightLog(WeightLog newWeightLog);

  void updateWeightLog(WeightLog deletedWeightLog, WeightLog updatedWeightLog);

  void deleteWeightLog(WeightLog deletedWeightLog);

  CalorieLimitLog getCalorieLimitLog();

  void createCalorieLimitLog(CalorieLimitLog newCalorieLimitLog);

  void updateCalorieLimitLog(CalorieLimitLog deletedCalorieLimitLog, CalorieLimitLog updatedCalorieLimitLog);

  void deleteCalorieLimitLog(CalorieLimitLog deletedCalorieLimitLog);

  List<FoodLog> getFoodLogs(LocalDate inputDate);

  void createFoodLog(FoodLog newFoodLog);

  void updateFoodLog(FoodLog deletedFoodLog, FoodLog updateFoodLog);

  void deleteFoodLog(FoodLog deletedFoodLog);

  List<ExerciseLog> getExerciseLogs(LocalDate inputDate);

  void createExerciseLog(ExerciseLog newExerciseLog);

  void updateExerciseLog(ExerciseLog deletedExerciseLog, ExerciseLog updatedExerciseLog);

  void deleteExerciseLog(ExerciseLog deletedExerciseLog);
}
