package services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import models.CalorieLimitLog;
import models.ExerciseLog;
import models.FoodLog;
import models.WeightLog;
import utils.DataUtil;

public class DailyLogServiceImpl implements DailyLogServiceInterface {
  public static final String LOG_CSV = "data/log.csv";
  DataUtil dataUtil = new DataUtil();

  @Override
  public WeightLog getWeightLog() {
    WeightLog weightLog = new WeightLog(150.0, LocalDate.now());
    for (String line : dataUtil.getLines(LOG_CSV)) {
      String[] parts = line.split(",");
      if (parts[3].equals("w")) {
        LocalDate date = LocalDate.of(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]),
            Integer.parseInt(parts[2]));
        double weight = Double.parseDouble(parts[4]);
        weightLog = new WeightLog(weight, date);
      }
    }
    return weightLog;
  }

  @Override
  public void createWeightLog(WeightLog newWeightLog) {
    String line = String.format("%d,%d,%d,w,%.1f",
        newWeightLog.getDate().getYear(),
        newWeightLog.getDate().getMonthValue(),
        newWeightLog.getDate().getDayOfMonth(),
        newWeightLog.getWeight());
    dataUtil.createLine(LOG_CSV, line);
  }

  @Override
  public void updateWeightLog(WeightLog deletedWeightLog, WeightLog updatedWeightLog) {
    String deletedLine = String.format("%d,%d,%d,w,%.1f",
        deletedWeightLog.getDate().getYear(),
        deletedWeightLog.getDate().getMonthValue(),
        deletedWeightLog.getDate().getDayOfMonth(),
        deletedWeightLog.getWeight());
    String updatedLine = String.format("%d,%d,%d,w,%.1f",
        updatedWeightLog.getDate().getYear(),
        updatedWeightLog.getDate().getMonthValue(),
        updatedWeightLog.getDate().getDayOfMonth(),
        updatedWeightLog.getWeight());
    dataUtil.updateLine(LOG_CSV, deletedLine, updatedLine);
  }

  @Override
  public void deleteWeightLog(WeightLog deletedWeightLog) {
    String deletedLine = String.format("%d,%d,%d,w,%.1f",
        deletedWeightLog.getDate().getYear(),
        deletedWeightLog.getDate().getMonthValue(),
        deletedWeightLog.getDate().getDayOfMonth(),
        deletedWeightLog.getWeight());
    dataUtil.deleteLine(LOG_CSV, deletedLine);
  }

  @Override
  public CalorieLimitLog getCalorieLimitLog() {
    CalorieLimitLog calorieLimitLog = new CalorieLimitLog(2000.0, LocalDate.now());
    for (String line : dataUtil.getLines(LOG_CSV)) {
      String[] parts = line.split(",");
      if (parts[3].equals("c")) {
        LocalDate date = LocalDate.of(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]),
            Integer.parseInt(parts[2]));
        double calorieLimit = Double.parseDouble(parts[4]);
        calorieLimitLog = new CalorieLimitLog(calorieLimit, date);
      }
    }
    return calorieLimitLog;
  }

  @Override
  public void createCalorieLimitLog(CalorieLimitLog newCalorieLimitLog) {
    String line = String.format("%d,%d,%d,c,%.1f",
        newCalorieLimitLog.getDate().getYear(),
        newCalorieLimitLog.getDate().getMonthValue(),
        newCalorieLimitLog.getDate().getDayOfMonth(),
        newCalorieLimitLog.getCalorieLimit());
    dataUtil.createLine(LOG_CSV, line);
  }

  @Override
  public void updateCalorieLimitLog(CalorieLimitLog deletedCalorieLimitLog, CalorieLimitLog updatedCalorieLimitLog) {
    String deletedLine = String.format("%d,%d,%d,c,%.1f",
        deletedCalorieLimitLog.getDate().getYear(),
        deletedCalorieLimitLog.getDate().getMonthValue(),
        deletedCalorieLimitLog.getDate().getDayOfMonth(),
        deletedCalorieLimitLog.getCalorieLimit());
    String updatedLine = String.format("%d,%d,%d,c,%.1f",
        updatedCalorieLimitLog.getDate().getYear(),
        updatedCalorieLimitLog.getDate().getMonthValue(),
        updatedCalorieLimitLog.getDate().getDayOfMonth(),
        updatedCalorieLimitLog.getCalorieLimit());
    dataUtil.updateLine(LOG_CSV, deletedLine, updatedLine);
  }

  @Override
  public void deleteCalorieLimitLog(CalorieLimitLog deletedCalorieLimitLog) {
    String deletedLine = String.format("%d,%d,%d,c,%.1f",
        deletedCalorieLimitLog.getDate().getYear(),
        deletedCalorieLimitLog.getDate().getMonthValue(),
        deletedCalorieLimitLog.getDate().getDayOfMonth(),
        deletedCalorieLimitLog.getCalorieLimit());
    dataUtil.deleteLine(LOG_CSV, deletedLine);
  }

  @Override
  public List<FoodLog> getFoodLogs(LocalDate inputDate) {
    List<FoodLog> foodLogs = new ArrayList<>();
    for (String line : dataUtil.getLines(LOG_CSV)) {
      String[] parts = line.split(",");
      if (parts[3].equals("f")) {
        LocalDate date = LocalDate.of(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]),
            Integer.parseInt(parts[2]));
        if (date.equals(inputDate)) {
          String food = parts[4];
          double count = Double.parseDouble(parts[5]);
          FoodLog foodLog = new FoodLog(food, count, date);
          foodLogs.add(foodLog);
        }
      }
    }
    return foodLogs;
  }

  @Override
  public void createFoodLog(FoodLog newFoodLog) {
    String line = String.format("%d,%d,%d,f,%s,%.1f",
        newFoodLog.getDate().getYear(),
        newFoodLog.getDate().getMonthValue(),
        newFoodLog.getDate().getDayOfMonth(),
        newFoodLog.getFood(),
        newFoodLog.getCount());
    dataUtil.createLine(LOG_CSV, line);
  }

  @Override
  public void updateFoodLog(FoodLog deletedFoodLog, FoodLog updatedFoodLog) {
    String deletedLine = String.format("%d,%d,%d,f,%s,%.1f",
        deletedFoodLog.getDate().getYear(),
        deletedFoodLog.getDate().getMonthValue(),
        deletedFoodLog.getDate().getDayOfMonth(),
        deletedFoodLog.getFood(),
        deletedFoodLog.getCount());
    String updatedLine = String.format("%d,%d,%d,f,%s,%.1f",
        updatedFoodLog.getDate().getYear(),
        updatedFoodLog.getDate().getMonthValue(),
        updatedFoodLog.getDate().getDayOfMonth(),
        updatedFoodLog.getFood(),
        updatedFoodLog.getCount());
    dataUtil.updateLine(LOG_CSV, deletedLine, updatedLine);
  }

  @Override
  public void deleteFoodLog(FoodLog deletedFoodLog) {
    String deletedLine = String.format("%d,%d,%d,f,%s,%.1f",
        deletedFoodLog.getDate().getYear(),
        deletedFoodLog.getDate().getMonthValue(),
        deletedFoodLog.getDate().getDayOfMonth(),
        deletedFoodLog.getFood(),
        deletedFoodLog.getCount());
    dataUtil.deleteLine(LOG_CSV, deletedLine);
  }

  @Override
  public List<ExerciseLog> getExerciseLogs(LocalDate inputDate) {
    List<ExerciseLog> exerciseLogs = new ArrayList<>();
    for (String line : dataUtil.getLines(LOG_CSV)) {
      String[] parts = line.split(",");
      if (parts[3].equals("e")) {
        LocalDate date = LocalDate.of(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]),
            Integer.parseInt(parts[2]));
        if (date.equals(inputDate)) {
          String name = parts[4];
          double minutes = Double.parseDouble(parts[5]);
          ExerciseLog exerciseLog = new ExerciseLog(name, minutes, date);
          exerciseLogs.add(exerciseLog);
        }
      }
    }
    return exerciseLogs;
  }

  @Override
  public void createExerciseLog(ExerciseLog newExerciseLog) {
    String line = String.format("%d,%d,%d,e,%s,%.1f",
        newExerciseLog.getDate().getYear(),
        newExerciseLog.getDate().getMonthValue(),
        newExerciseLog.getDate().getDayOfMonth(),
        newExerciseLog.getName(),
        newExerciseLog.getMinutes());
    dataUtil.createLine(LOG_CSV, line);
  }

  @Override
  public void updateExerciseLog(ExerciseLog deletedExerciseLog, ExerciseLog updatedExerciseLog) {
    String updatedLine = String.format("%d,%d,%d,e,%s,%.1f",
        deletedExerciseLog.getDate().getYear(),
        deletedExerciseLog.getDate().getMonthValue(),
        deletedExerciseLog.getDate().getDayOfMonth(),
        deletedExerciseLog.getName(),
        deletedExerciseLog.getMinutes());
    String deletedLine = String.format("%d,%d,%d,e,%s,%.1f",
        deletedExerciseLog.getDate().getYear(),
        deletedExerciseLog.getDate().getMonthValue(),
        deletedExerciseLog.getDate().getDayOfMonth(),
        deletedExerciseLog.getName(),
        deletedExerciseLog.getMinutes());
    dataUtil.updateLine(LOG_CSV, deletedLine, updatedLine);
  }

  @Override
  public void deleteExerciseLog(ExerciseLog deletedExerciseLog) {
    String deletedLine = String.format("%d,%d,%d,e,%s,%.1f",
        deletedExerciseLog.getDate().getYear(),
        deletedExerciseLog.getDate().getMonthValue(),
        deletedExerciseLog.getDate().getDayOfMonth(),
        deletedExerciseLog.getName(),
        deletedExerciseLog.getMinutes());
    dataUtil.deleteLine(LOG_CSV, deletedLine);
  }
}
