package services;

import java.util.List;

import models.Exercise;

public interface ExerciseServiceInterface {
  List<Exercise> getExercises();

  Exercise getExercise(String exerciseName);

  void createExercise(Exercise newExercise);
}
