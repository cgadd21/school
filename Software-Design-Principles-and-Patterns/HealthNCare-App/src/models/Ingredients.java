package models;

public class Ingredients {
  public BasicFood food;
  public double quantity;

  public Ingredients() {
  }

  public Ingredients(BasicFood food, double quantity) {
    this.food = food;
    this.quantity = quantity;
  }

  public BasicFood getFood() {
    return food;
  }

  public void setFood(BasicFood food) {
    this.food = food;
  }

  public double getQuantity() {
    return quantity;
  }

  public void setquantity(double quantity) {
    this.quantity = quantity;
  }
}
