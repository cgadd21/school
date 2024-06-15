package services;

import java.util.List;

import models.Exercise;

public class ExerciseService {
  ExerciseServiceInterface exerciseService = new ExerciseServiceImpl();

  public List<Exercise> getExercises() {
    return exerciseService.getExercises();
  }

  public Exercise getExercise(String exerciseName) {
    return exerciseService.getExercise(exerciseName);
  }

  public void createExercise(Exercise newExercise) {
    exerciseService.createExercise(newExercise);
  }
}
