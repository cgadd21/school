package models;

public class NutritionFacts {
  private double calories;
  private double fat;
  private double carbohydrates;
  private double protein;
  private double sodium;

  public NutritionFacts() {

  }

  public NutritionFacts(double calories, double fat, double carbohydrates, double protein, double sodium) {
    this.calories = calories;
    this.fat = fat;
    this.carbohydrates = carbohydrates;
    this.protein = protein;
    this.sodium = sodium;
  }

  public double getCalories() {
    return calories;
  }

  public void setCalories(double calories) {
    this.calories = calories;
  }

  public double getFat() {
    return fat;
  }

  public void setFat(double fat) {
    this.fat = fat;
  }

  public double getCarbohydrates() {
    return carbohydrates;
  }

  public void setCarbohydrates(double carbohydrates) {
    this.carbohydrates = carbohydrates;
  }

  public double getProtein() {
    return protein;
  }

  public void setProtein(double protein) {
    this.protein = protein;
  }

  public double getSodium() {
    return sodium;
  }

  public void setSodium(double sodium) {
    this.sodium = sodium;
  }
}
