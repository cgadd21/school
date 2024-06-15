package services;

import java.time.LocalDate;
import java.util.List;

import models.CalorieLimitLog;
import models.ExerciseLog;
import models.FoodLog;
import models.WeightLog;

public class DailyLogService {
  DailyLogServiceInterface dailyLogService = new DailyLogServiceImpl();

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
}
