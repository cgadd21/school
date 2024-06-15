package services;

import java.util.ArrayList;
import java.util.List;

import models.Exercise;
import utils.DataUtil;

public class ExerciseServiceImpl implements ExerciseServiceInterface {
  private static final String EXERCISE_CSV = "data/exercise.csv";
  DataUtil dataUtil = new DataUtil();

  @Override
  public List<Exercise> getExercises() {
    List<Exercise> exercises = new ArrayList<>();
    for (String line : dataUtil.getLines(EXERCISE_CSV)) {
      if (line.startsWith("e")) {
        String[] parts = line.split(",");
        String name = parts[1];
        double calories = Double.parseDouble(parts[2]);
        Exercise exercise = new Exercise(name, calories);
        exercises.add(exercise);
      }
    }
    return exercises;
  }

  @Override
  public Exercise getExercise(String exerciseName) {
    Exercise exercise = new Exercise();
    for (String line : dataUtil.getLines(EXERCISE_CSV)) {
      if (line.startsWith("e," + exerciseName + ",")) {
        String[] parts = line.split(",");
        String name = parts[1];
        double calories = Double.parseDouble(parts[2]);
        exercise = new Exercise(name, calories);
      }
    }
    return exercise;
  }

  @Override
  public void createExercise(Exercise newExercise) {
    String line = String.format("e,%s,%.1f",
        newExercise.getName(), newExercise.getCalories());
    dataUtil.createLine(EXERCISE_CSV, line);
  }

}
