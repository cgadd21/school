package models;

public class BasicFood {
  private String name;
  private NutritionFacts nutritionFacts;

  public BasicFood() {

  }

  public BasicFood(String name, NutritionFacts nutritionFacts) {
    this.name = name;
    this.nutritionFacts = nutritionFacts;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public NutritionFacts getNutritionFacts() {
    return nutritionFacts;
  }

  public void setNutritionFacts(NutritionFacts nutritionFacts) {
    this.nutritionFacts = nutritionFacts;
  }
}
