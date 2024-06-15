package models;

public class Recipe {
  private String name;
  private Ingredients[] ingredients;

  public Recipe() {

  }

  public Recipe(String name, Ingredients[] ingredients) {
    this.name = name;
    this.ingredients = ingredients;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Ingredients[] getIngredients() {
    return ingredients;
  }

  public void setIngredients(Ingredients[] ingredients) {
    this.ingredients = ingredients;
  }
}