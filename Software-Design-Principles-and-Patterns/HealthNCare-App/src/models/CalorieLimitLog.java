package models;

import java.time.LocalDate;

public class CalorieLimitLog {
  private double calorieLimit;
  private LocalDate date;

  public CalorieLimitLog() {
  }

  public CalorieLimitLog(double calorieLimit, LocalDate date) {
    this.calorieLimit = calorieLimit;
    this.date = date;
  }

  public double getCalorieLimit() {
    return calorieLimit;
  }

  public void setCalorieLimit(double calorieLimit) {
    this.calorieLimit = calorieLimit;
  }

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }
}
