package models;

public class Exercise {
  private String name;
  private double calories;

  public Exercise() {
  }

  public Exercise(String name, double calories) {
    this.name = name;
    this.calories = calories;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getCalories() {
    return calories;
  }

  public void setCalories(double calories) {
    this.calories = calories;
  }
}
