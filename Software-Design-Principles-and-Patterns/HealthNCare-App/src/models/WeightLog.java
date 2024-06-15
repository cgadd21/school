package models;

import java.time.LocalDate;

public class WeightLog {
  private double weight;
  private LocalDate date;

  public WeightLog() {
  }

  public WeightLog(double weight, LocalDate date) {
    this.weight = weight;
    this.date = date;
  }

  public double getWeight() {
    return weight;
  }

  public void setWeight(double weight) {
    this.weight = weight;
  }

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }
}
