package models;

import java.time.LocalDate;

public class FoodLog {
  private String food;
  private double count;
  private LocalDate date;

  public FoodLog() {
  }

  public FoodLog(String food, double count, LocalDate date) {
    this.food = food;
    this.count = count;
    this.date = date;
  }

  public String getFood() {
    return food;
  }

  public void setFood(String food) {
    this.food = food;
  }

  public double getCount() {
    return count;
  }

  public void setCount(double count) {
    this.count = count;
  }

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }
}
