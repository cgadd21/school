package models;

import java.time.LocalDate;

public class ExerciseLog {
  private String name;
  private double minutes;
  private LocalDate date;

  public ExerciseLog() {
  }

  public ExerciseLog(String name, double minutes, LocalDate date) {
    this.name = name;
    this.minutes = minutes;
    this.date = date;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getMinutes() {
    return minutes;
  }

  public void setMinutes(double minutes) {
    this.minutes = minutes;
  }

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }
}
