package views;

import javax.swing.*;

import controllers.HealthNCareController;
import models.BasicFood;
import models.CalorieLimitLog;
import models.Exercise;
import models.ExerciseLog;
import models.FoodLog;
import models.Ingredients;
import models.WeightLog;
import models.NutritionFacts;
import models.Recipe;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

public class GraphicalView extends JFrame {
  HealthNCareController healthNCareController = new HealthNCareController();

  // panels
  private JPanel mainPanel;
  private JPanel datePanel;
  private JPanel editDatePanel;
  private JPanel calorieLimitPanel;
  private JPanel editCalorieLimitPanel;
  private JPanel weightLogPanel;
  private JPanel editWeightLogPanel;
  private JPanel basicFoodPanel;
  private JPanel readBasicFoodPanel;
  private JPanel createBasicFoodPanel;
  private JPanel searchBasicFoodPanel;
  private JPanel recipesPanel;
  private JPanel lookRecipePanel;
  private JPanel searchRecipePanel;
  private JPanel createRecipePanel;
  private JPanel exercisePanel;
  private JPanel findExercisePanel;
  private JPanel displayExercisePanel;
  private JPanel newExercisePanel;
  private JPanel foodLogPanel;
  private JPanel editFoodLogPanel;
  private JPanel exerciseLogPanel;
  private JPanel editExerciseLogPanel;

  // labels
  private JLabel dateLabel;
  private JLabel editDateLabel;
  private JLabel calorieLimitLabel;
  private JLabel editCalorieLimitLabel;
  private JLabel deleteCalorieLimitLabel;
  private JLabel weightLogLabel;
  private JLabel editWeightLogLabel;
  private JLabel deleteWeightLogLabel;
  private JLabel basicFoodLabel;
  private JLabel readBasicFoodLabel;
  private JLabel createBasicFoodLabel;
  private JLabel searchBasicFoodLabel;
  private JLabel createBasicFoodNameLabel;
  private JLabel createBasicFoodCaloriesLabel;
  private JLabel createBasicFoodFatLabel;
  private JLabel createBasicFoodCarbsLabel;
  private JLabel createBasicFoodProteinLabel;
  private JLabel createBasicFoodSodiumLabel;
  private JLabel recipesLabel;
  private JLabel lookRecipeLabel;
  private JLabel searchRecipeLabel;
  private JLabel createRecipeLabel;
  private JLabel createRecipeNameLabel;
  private JLabel addIngredientsLabel;
  private JLabel addIngredientCountLabel;
  private JLabel exerciseLabel;
  private JLabel editExerciseLabel;
  private JLabel findExerciseLabel;
  private JLabel displayExerciseLabel;
  private JLabel newExerciseLabel;
  private JLabel foodLogLabel;
  private JLabel editFoodLogLabel;
  private JLabel deleteFoodLogLabel;
  private JLabel editCountLabel;
  private JLabel exerciseLogLabel;
  private JLabel editExerciseLogLabel;
  private JLabel editExerciseDurationLabel;
  private JLabel deleteExerciseLogLabel;

  private JLabel editExerciseCaloriesLabel;
  // text fields
  private JTextField editDateTextField;
  private JTextField editCalorieLimitTextField;
  private JTextField editWeightLogTextField;
  private JTextField readBasicFoodTextField;
  private JTextField createBasicFoodNameTextField;
  private JTextField createBasicFoodCaloriesTextField;
  private JTextField createBasicFoodFatTextField;
  private JTextField createBasicFoodCarbsTextField;
  private JTextField createBasicFoodProteinTextField;
  private JTextField createBasicFoodSodiumTextField;
  private JTextField searchRecipeTextField;
  private JTextField createRecipeNameTextField;
  private JTextField addIngredientsTextField;
  private JTextField addIngredientCountTextField;

  private JTextField editExerciseTextField;
  private JTextField findExerciseTextField;
  private JTextField editFoodLogTextField;
  private JTextField editCountTextField;
  private JTextField editExerciseLogTextField;
  private JTextField editExerciseDurationTextField;

  private JTextField editExerciseCaloriesTextField;
  // buttons
  private JButton dateButton;
  private JButton calorieLimitButton;
  private JButton weightLogButton;
  private JButton basicFoodButton;
  private JButton createBasicFoodButton;
  private JButton recipesButton;
  private JButton createRecipeButton;
  private JButton exerciseButton;
  private JButton newExerciseButton;
  private JButton foodLogButton;
  private JButton exerciseLogButton;

  // check boxes
  private JCheckBox deleteCalorieLimitCheckBox;
  private JCheckBox deleteWeightLogCheckBox;
  private JCheckBox deleteFoodLogCheckBox;
  private JCheckBox deleteExerciseLogCheckBox;

  // other
  private LocalDate inputDate;
  private CalorieLimitLog calorieLimitLog;
  private WeightLog weightLog;
  private Exercise exercise;

  private FoodLog foodLog;
  private ExerciseLog exerciseLog;

  private JTextArea dailyLogArea;

  private static JFXPanel fxPanel;
  private static double fat = 0;
  private static double carbs = 0;
  private static double protein = 0;
  private String exerciseName = "";
  private double exerciseCalories = 0;

  public GraphicalView() {
    super("HealthNCare");
    setSize(1000, 800);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    mainPanel = new JPanel(new GridLayout(0,2));
    date();
    calorieLimit();
    weightLog();
    basicFood();
    recipes();
    exercise();
    foodLog();
    exerciseLog();
    add(mainPanel);
    populateGraph();
    fxPanel = new JFXPanel();
    mainPanel.add(fxPanel);
    updateBarGraph();
    setVisible(true);

    dailyLogArea = new JTextArea(10, 20); // Adjust size as needed
    dailyLogArea.setEditable(false); // Make it read-only
    dailyLogArea.setText("Select a date to view logs.");
    JScrollPane scrollPane = new JScrollPane(dailyLogArea);
    mainPanel.add(scrollPane, BorderLayout.WEST);
  }

  private void date() {
    inputDate = LocalDate.now();
    datePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    dateLabel = new JLabel("Date: " + inputDate);
    dateButton = new JButton("✎");
    dateButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        editDatePanel = new JPanel(new GridLayout(2, 2));
        editDateLabel = new JLabel("Enter a date (YYYY-MM-DD):");
        editDateTextField = new JTextField(inputDate.toString());

        editDatePanel.add(editDateLabel);
        editDatePanel.add(editDateTextField);

        JOptionPane.showMessageDialog(null, editDatePanel, "Date", JOptionPane.QUESTION_MESSAGE);

        if (editDateTextField.getText() != null && !editDateTextField.getText().isEmpty()) {
          try {
            inputDate = LocalDate.parse(editDateTextField.getText(), DateTimeFormatter.ISO_LOCAL_DATE);
            dateLabel.setText("Date: " + inputDate);
            populateGraph();
            updateBarGraph();

            // Added code below to update labels of foodLog and exerciseLog to most recent
            // log of each
            // depending on the day chosen, if there is no log, N/A will be displayed
            List<FoodLog> foodLogs = healthNCareController.getFoodLogs(inputDate);
            if (!foodLogs.isEmpty()) {
              FoodLog latestFoodLog = foodLogs.get(foodLogs.size() - 1);
              foodLogLabel.setText("Food Log: " + latestFoodLog.getFood() + " (" + latestFoodLog.getCount() + ")");
            } else {
              foodLogLabel.setText("Food Log: N/A");
            }

            List<ExerciseLog> exerciseLogs = healthNCareController.getExerciseLogs(inputDate);
            if (!exerciseLogs.isEmpty()) {
              ExerciseLog latestExerciseLog = exerciseLogs.get(exerciseLogs.size() - 1);
              exerciseLogLabel.setText(
                  "Exercise Log: " + latestExerciseLog.getName() + " (" + latestExerciseLog.getMinutes() + ")");
            } else {
              exerciseLogLabel.setText("Exercise Log: N/A");
            }

          } catch (Exception e) {
            JOptionPane.showMessageDialog(GraphicalView.this, "Error: " + e.toString(), "Error",
                JOptionPane.ERROR_MESSAGE);
          }
          dailyLogs(inputDate);
        }
      }
    });
    datePanel.add(dateLabel);
    datePanel.add(dateButton);
    mainPanel.add(datePanel, BorderLayout.CENTER);
  }

  public void populateGraph() {
    fat = 0;
    carbs = 0;
    protein = 0;
    List<FoodLog> foodLogs = healthNCareController.getFoodLogs(inputDate);
    for (FoodLog log : foodLogs) {
      if (healthNCareController.getRecipe(log.getFood()) != null) {
        Recipe recipe = healthNCareController.getRecipe(log.getFood());
        for (Ingredients ingredients : recipe.getIngredients()) {
          carbs += ingredients.getFood().getNutritionFacts().getCarbohydrates();
          fat += ingredients.getFood().getNutritionFacts().getFat();
          protein += ingredients.getFood().getNutritionFacts().getProtein();
        }
      } else {
        BasicFood food = healthNCareController.getBasicFood(log.getFood());
        carbs += food.getNutritionFacts().getCarbohydrates();
        fat += food.getNutritionFacts().getFat();
        protein += food.getNutritionFacts().getProtein();
      }
      // System.out.println(carbs);
      // System.out.println(fat);
      // System.out.println(protein);
    }
  }

  public static void updateBarGraph() {

    Platform.runLater(() -> {
      final CategoryAxis xAxis = new CategoryAxis();
      final NumberAxis yAxis = new NumberAxis();
      final BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);
      barChart.setTitle("Daily Nutrition");

      XYChart.Series<String, Number> series = new XYChart.Series<>();
      series.getData().add(new XYChart.Data<>("fats", fat));
      series.getData().add(new XYChart.Data<>("carbs", carbs));
      series.getData().add(new XYChart.Data<>("protein", protein));

      barChart.getData().add(series);

      Scene scene = new Scene(barChart, 800, 600);
      fxPanel.setScene(scene);
    });
  }

  private void calorieLimit() {
    calorieLimitLog = healthNCareController.getCalorieLimitLog();
    calorieLimitPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    calorieLimitLabel = new JLabel("Calorie Limit: " + calorieLimitLog.getCalorieLimit());
    calorieLimitButton = new JButton("✎");
    calorieLimitButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        editCalorieLimitPanel = new JPanel(new GridLayout(3, 2));
        editCalorieLimitLabel = new JLabel("Enter a calorie limit:");
        editCalorieLimitTextField = new JTextField(
            Double.toString(healthNCareController.getCalorieLimitLog().getCalorieLimit()));
        deleteCalorieLimitLabel = new JLabel("Delete?");
        deleteCalorieLimitCheckBox = new JCheckBox();

        editCalorieLimitPanel.add(editCalorieLimitLabel);
        editCalorieLimitPanel.add(editCalorieLimitTextField);
        editCalorieLimitPanel.add(deleteCalorieLimitLabel);
        editCalorieLimitPanel.add(deleteCalorieLimitCheckBox);

        JOptionPane.showMessageDialog(null, editCalorieLimitPanel, "Calorie Limit", JOptionPane.QUESTION_MESSAGE);

        if (editCalorieLimitTextField.getText() != null && !editCalorieLimitTextField.getText().isEmpty()) {
          try {
            if (inputDate.isBefore(calorieLimitLog.getDate())) {
              JOptionPane.showMessageDialog(GraphicalView.this, "You can't change the past", "Regret?",
                  JOptionPane.ERROR_MESSAGE);
            } else if (deleteCalorieLimitCheckBox.isSelected()) {
              healthNCareController.deleteCalorieLimitLog(
                  new CalorieLimitLog(Double.parseDouble(editCalorieLimitTextField.getText()), inputDate));
            } else if (inputDate.isEqual(calorieLimitLog.getDate())) {
              healthNCareController.updateCalorieLimitLog(calorieLimitLog,
                  new CalorieLimitLog(Double.parseDouble(editCalorieLimitTextField.getText()), inputDate));
            } else {
              healthNCareController.createCalorieLimitLog(
                  new CalorieLimitLog(Double.parseDouble(editCalorieLimitTextField.getText()), inputDate));
            }
            calorieLimitLabel.setText("Calorie Limit:" + healthNCareController.getCalorieLimitLog().getCalorieLimit());
          } catch (Exception e) {
            JOptionPane.showMessageDialog(GraphicalView.this, "Error: " + e.toString(), "Error",
                JOptionPane.ERROR_MESSAGE);
          }
        }
      }
    });
    calorieLimitPanel.add(calorieLimitLabel);
    calorieLimitPanel.add(calorieLimitButton);
    mainPanel.add(calorieLimitPanel, BorderLayout.CENTER);
  }

  private void weightLog() {
    weightLog = healthNCareController.getWeightLog();
    weightLogPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    weightLogLabel = new JLabel("Weight: " + weightLog.getWeight());
    weightLogButton = new JButton("✎");
    weightLogButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        editWeightLogPanel = new JPanel(new GridLayout(3, 2));
        editWeightLogLabel = new JLabel("Enter your weight:");
        editWeightLogTextField = new JTextField(
            Double.toString(healthNCareController.getWeightLog().getWeight()));
        deleteWeightLogLabel = new JLabel("Delete?");
        deleteWeightLogCheckBox = new JCheckBox();

        editWeightLogPanel.add(editWeightLogLabel);
        editWeightLogPanel.add(editWeightLogTextField);
        editWeightLogPanel.add(deleteWeightLogLabel);
        editWeightLogPanel.add(deleteWeightLogCheckBox);

        JOptionPane.showMessageDialog(null, editWeightLogPanel, "Weight", JOptionPane.QUESTION_MESSAGE);

        if (editWeightLogTextField.getText() != null && !editWeightLogTextField.getText().isEmpty()) {
          try {
            if (inputDate.isBefore(weightLog.getDate())) {
              JOptionPane.showMessageDialog(GraphicalView.this, "You can't change the past", "Regret?",
                  JOptionPane.ERROR_MESSAGE);
            } else if (deleteWeightLogCheckBox.isSelected()) {
              healthNCareController.deleteWeightLog(
                  new WeightLog(Double.parseDouble(editWeightLogTextField.getText()), inputDate));
            } else if (inputDate.isEqual(weightLog.getDate())) {
              healthNCareController.updateWeightLog(weightLog,
                  new WeightLog(Double.parseDouble(editWeightLogTextField.getText()), inputDate));
            } else {
              healthNCareController.createWeightLog(
                  new WeightLog(Double.parseDouble(editWeightLogTextField.getText()), inputDate));
            }
            weightLogLabel.setText("Weight:" + healthNCareController.getWeightLog().getWeight());
          } catch (Exception e) {
            JOptionPane.showMessageDialog(GraphicalView.this, "Error: " + e.toString(), "Error",
                JOptionPane.ERROR_MESSAGE);
          }
        }
      }
    });
    weightLogPanel.add(weightLogLabel);
    weightLogPanel.add(weightLogButton);
    mainPanel.add(weightLogPanel, BorderLayout.CENTER);
  }

  // displays all logs for specific day chosen
  private void dailyLogs(LocalDate selectedDate) {
    // Clear the existing content of the text area
    dailyLogArea.setText("");

    // Get food logs for the selected date
    List<FoodLog> foodLogs = healthNCareController.getFoodLogs(selectedDate);
    if (!foodLogs.isEmpty()) {
      dailyLogArea.append("Food Logs:\n");
      for (FoodLog foodLog : foodLogs) {
        dailyLogArea.append("- " + foodLog.getFood() + " (" + foodLog.getCount() + ")\n");
      }
    } else {
      dailyLogArea.append("Food Logs: N/A\n");
    }

    // Add a separator between food logs and exercise logs
    dailyLogArea.append("\n");

    // Get exercise logs for the selected date
    List<ExerciseLog> exerciseLogs = healthNCareController.getExerciseLogs(selectedDate);
    if (!exerciseLogs.isEmpty()) {
      dailyLogArea.append("Exercise Logs:\n");
      for (ExerciseLog exerciseLog : exerciseLogs) {
        dailyLogArea.append("- " + exerciseLog.getName() + " (" + exerciseLog.getMinutes() + " minutes)\n");
      }
    } else {
      dailyLogArea.append("Exercise Logs: N/A\n");
    }
  }

  // TODO: food log
  private void foodLog() {
    List<FoodLog> foodLogs = healthNCareController.getFoodLogs(inputDate);
    if (!foodLogs.isEmpty()) {
      // Assuming we want to display the first food log in the list
      foodLog = foodLogs.get(foodLogs.size() - 1);
    } else {
      // If there are no food logs for the selected date, create a new one with
      // default values
      foodLog = new FoodLog("", 1.0, inputDate);
    }

    foodLogPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    foodLogLabel = new JLabel("Food Log: " + foodLog.getFood() + " (" + foodLog.getCount() + ")");
    foodLogButton = new JButton("✎");
    foodLogButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        editFoodLogPanel = new JPanel(new GridLayout(3, 2));
        editFoodLogLabel = new JLabel("Enter your food:");
        editFoodLogTextField = new JTextField(foodLog.getFood());

        editCountLabel = new JLabel("Enter the amount:");
        editCountTextField = new JTextField(Double.toString(foodLog.getCount()));

        deleteFoodLogLabel = new JLabel("Delete?");
        deleteFoodLogCheckBox = new JCheckBox();

        editFoodLogPanel.add(editFoodLogLabel);
        editFoodLogPanel.add(editFoodLogTextField);
        editFoodLogPanel.add(editCountLabel);
        editFoodLogPanel.add(editCountTextField);
        editFoodLogPanel.add(deleteFoodLogLabel);
        editFoodLogPanel.add(deleteFoodLogCheckBox);

        JOptionPane.showMessageDialog(null, editFoodLogPanel, "Food Log", JOptionPane.QUESTION_MESSAGE);

        if (!editFoodLogTextField.getText().isEmpty() && !editCountTextField.getText().isEmpty()) {
          try {
            String editedFood = editFoodLogTextField.getText();
            double editedCount = Double.parseDouble(editCountTextField.getText());
            if (editedCount < 0) {
              JOptionPane.showMessageDialog(GraphicalView.this, "Count cannot be negative", "Error",
                  JOptionPane.ERROR_MESSAGE);
              return;
            }

            // Check if the logged food exists in the list of available foods
            boolean foodExists = false;
            List<BasicFood> basicFoods = healthNCareController.getBasicFoods();
            List<Recipe> recipes = healthNCareController.getRecipes();
            for (BasicFood basicFood : basicFoods) {
              if (basicFood.getName().equals(editedFood)) {
                foodExists = true;
                break;
              }
            }
            for (Recipe recipe : recipes) {
              if (recipe.getName().equals(editedFood)) {
                foodExists = true;
                break;
              }
            }

            if (!foodExists) {
              JOptionPane.showMessageDialog(GraphicalView.this, "Food does not exist. Please add it first.", "Error",
                  JOptionPane.ERROR_MESSAGE);
              return; // Stop the log if the food does not exist
            }

            if (inputDate.isBefore(foodLog.getDate())) {
              JOptionPane.showMessageDialog(GraphicalView.this, "You can't change the past", "Regret?",
                  JOptionPane.ERROR_MESSAGE);
            } else {
              if (deleteFoodLogCheckBox.isSelected()) {
                healthNCareController.deleteFoodLog(foodLog);
                foodLogLabel.setText("Food Log:");
              } else {
                FoodLog updatedFoodLog = new FoodLog(editedFood, editedCount, inputDate);
                healthNCareController.createFoodLog(updatedFoodLog);
                foodLogLabel.setText("Food Log: " + updatedFoodLog.getFood() + " (" + updatedFoodLog.getCount() + ")");
                // Update foodLog to the newly created food log
                foodLog = updatedFoodLog;
              }
            }
          } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(GraphicalView.this, "Please enter a valid amount", "Error",
                JOptionPane.ERROR_MESSAGE);
          } catch (Exception e) {
            JOptionPane.showMessageDialog(GraphicalView.this, "Error: " + e.toString(), "Error",
                JOptionPane.ERROR_MESSAGE);
          }
        }
      }
    });
    foodLogPanel.add(foodLogLabel);
    foodLogPanel.add(foodLogButton);
    mainPanel.add(foodLogPanel, BorderLayout.CENTER);
  }

  // TODO: exercise log
  private void exerciseLog() {
    List<ExerciseLog> exerciseLogs = healthNCareController.getExerciseLogs(inputDate);
    if (!exerciseLogs.isEmpty()) {
      // Assuming we want to display the first food log in the list
      exerciseLog = exerciseLogs.get(exerciseLogs.size() - 1);
    } else {
      // If there are no food logs for the selected date, create a new one with
      // default values
      exerciseLog = new ExerciseLog("", 15.0, inputDate);
    }

    exerciseLogPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    exerciseLogLabel = new JLabel("Exercise Log: " + exerciseLog.getName() + " (" + exerciseLog.getMinutes() + ")");
    exerciseLogButton = new JButton("✎");
    exerciseLogButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        // Get the most recent exercise log

        editExerciseLogPanel = new JPanel(new GridLayout(4, 2));
        editExerciseLogLabel = new JLabel("Enter the exercise:");
        editExerciseLogTextField = new JTextField(exerciseLog.getName());

        editExerciseDurationLabel = new JLabel("Enter the duration (minutes):");
        editExerciseDurationTextField = new JTextField(Double.toString(exerciseLog.getMinutes()));

        deleteExerciseLogLabel = new JLabel("Delete?");
        deleteExerciseLogCheckBox = new JCheckBox();

        editExerciseLogPanel.add(editExerciseLogLabel);
        editExerciseLogPanel.add(editExerciseLogTextField);
        editExerciseLogPanel.add(editExerciseDurationLabel);
        editExerciseLogPanel.add(editExerciseDurationTextField);
        editExerciseLogPanel.add(deleteExerciseLogLabel);
        editExerciseLogPanel.add(deleteExerciseLogCheckBox);

        JOptionPane.showMessageDialog(null, editExerciseLogPanel, "Exercise Log", JOptionPane.QUESTION_MESSAGE);

        if (!editExerciseLogTextField.getText().isEmpty() && !editExerciseDurationTextField.getText().isEmpty()) {
          try {
            String exerciseName = editExerciseLogTextField.getText();
            double exerciseMinutes = Double.parseDouble(editExerciseDurationTextField.getText());
            if (exerciseMinutes < 0) {
              JOptionPane.showMessageDialog(GraphicalView.this, "Duration cannot be negative", "Error",
                  JOptionPane.ERROR_MESSAGE);
              return;
            }
            // Check if the exercise exists in the list of available exercises
            boolean exerciseExists = false;
            List<Exercise> exercises = healthNCareController.getExercises();
            for (Exercise exercise : exercises) {
              if (exercise.getName().equals(exerciseName)) {
                exerciseExists = true;
                break;
              }
            }

            if (!exerciseExists) {
              JOptionPane.showMessageDialog(GraphicalView.this, "Exercise does not exist. Please add it first.",
                  "Error", JOptionPane.ERROR_MESSAGE);
              return; // Stop the log if the exercise does not exist
            }

            if (inputDate.isBefore(exerciseLog.getDate())) {
              JOptionPane.showMessageDialog(GraphicalView.this, "You can't change the past", "Regret?",
                  JOptionPane.ERROR_MESSAGE);
            } else {
              if (deleteExerciseLogCheckBox.isSelected()) {
                healthNCareController.deleteExerciseLog(exerciseLog);
                exerciseLogLabel.setText("Exercise Log:");
              } else {
                ExerciseLog updatedExerLog = new ExerciseLog(exerciseName, exerciseMinutes, inputDate);
                healthNCareController.createExerciseLog(updatedExerLog);
                exerciseLogLabel
                    .setText("Exercise Log: " + updatedExerLog.getName() + " (" + updatedExerLog.getMinutes() + ")");
                exerciseLog = updatedExerLog;
              }
            }
          } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(GraphicalView.this, "Please enter a valid duration", "Error",
                JOptionPane.ERROR_MESSAGE);
          } catch (Exception e) {
            JOptionPane.showMessageDialog(GraphicalView.this, "Error: " + e.toString(), "Error",
                JOptionPane.ERROR_MESSAGE);
          }
        }
      }
    });
    exerciseLogPanel.add(exerciseLogLabel);
    exerciseLogPanel.add(exerciseLogButton);
    mainPanel.add(exerciseLogPanel, BorderLayout.CENTER);
  }

  // TODO: exercise  // TODO: exercise
  private void exercise() {
    exerciseCalories = 0;
    exercise = healthNCareController.getExercise(exerciseName);
    List<Exercise> currentExercises = healthNCareController.getExercises();
    
    exercisePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    exerciseLabel = new JLabel("Exercise");
    exerciseButton = new JButton("✎");
    exerciseButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        findExercisePanel = new JPanel(new GridLayout(4, 2));

        findExerciseLabel = new JLabel("Search for exercise here:");
        findExerciseTextField = new JTextField();

        newExerciseLabel = new JLabel("Add a new exercise");

        findExercisePanel.add(findExerciseLabel);
        findExercisePanel.add(findExerciseTextField);
        findExercisePanel.add(newExerciseLabel);
        findExercisePanel.add(newExerciseButton);

        exercise.setName(exerciseName);
        exercise.setCalories(exerciseCalories);

        JOptionPane.showMessageDialog(null, findExercisePanel, "Add Exercise", JOptionPane.QUESTION_MESSAGE);
        if (findExerciseTextField.getText() != null && !findExerciseTextField.getText().isEmpty()) {

          if (findExerciseTextField.getText() != null && !findExerciseTextField.getText().isEmpty()) {
            try {
              String searchedExerciseText = findExerciseTextField.getText();

              for (Exercise inputExercise : currentExercises) {
                if (inputExercise.getName() == searchedExerciseText) {

                  Exercise searchedExercise = healthNCareController.getExercise(searchedExerciseText);

                  String inputExerciseCalories = Double.toString(searchedExercise.getCalories());

                  displayExercisePanel = new JPanel(new GridLayout(4,2));
                  displayExerciseLabel = new JLabel("Name: " + searchedExercise.getName() + "Calories: " + inputExerciseCalories);
                  displayExercisePanel.add(displayExerciseLabel);
                  break;
                } 
                else {
                  JOptionPane.showMessageDialog(GraphicalView.this, "Exercise does not exist.", "Error",
                      JOptionPane.ERROR_MESSAGE);
                  return;
                }
              }
              
            } catch (Exception e) {
              JOptionPane.showMessageDialog(GraphicalView.this, "Error: " + e.toString(), "Error",
                  JOptionPane.ERROR_MESSAGE);
            }
          }
        }
      }
    });
    newExerciseButton = new JButton("✎");
    newExerciseButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        newExercisePanel = new JPanel(new GridLayout(4, 2));

        newExerciseLabel = new JLabel("Add a new exercise");

        editExerciseLabel = new JLabel("New Exercise Name:");
        editExerciseTextField = new JTextField();

        editExerciseCaloriesLabel = new JLabel("Calories");
        editExerciseCaloriesTextField = new JTextField(Double.toString(exerciseCalories));

        newExercisePanel.add(editExerciseLabel);
        newExercisePanel.add(editExerciseTextField);
        newExercisePanel.add(editExerciseCaloriesLabel);
        newExercisePanel.add(editExerciseCaloriesTextField);

        exercise.setName(exerciseName);
        exercise.setCalories(exerciseCalories);

        JOptionPane.showMessageDialog(null, newExercisePanel, "Add Exercise", JOptionPane.QUESTION_MESSAGE);
        if (editExerciseTextField.getText() != null && !editExerciseTextField.getText().isEmpty()) {

          if (editExerciseTextField.getText() != null && !editExerciseTextField.getText().isEmpty()) {
            try {
              String newExercise = editExerciseTextField.getText();
              double newExerciseCalories = Double.parseDouble(editExerciseCaloriesTextField.getText());

              if (newExerciseCalories < 0){
                JOptionPane.showMessageDialog(GraphicalView.this, "Calories can't be negative.", "Error",
                  JOptionPane.ERROR_MESSAGE);
                return;
              }
              else {
                healthNCareController.createExercise(new Exercise(newExercise, newExerciseCalories));
              }
            } catch (Exception e) {
              JOptionPane.showMessageDialog(GraphicalView.this, "Error: " + e.toString(), "Error",
                  JOptionPane.ERROR_MESSAGE);
            }
          }
        }
      }
    });
    
    exercisePanel.add(exerciseLabel);
    exercisePanel.add(exerciseButton);
    mainPanel.add(exercisePanel, BorderLayout.CENTER);
  }
  // TODO: foods
  private void basicFood() {
    basicFoodPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    basicFoodLabel = new JLabel("Basic Foods:");
    basicFoodButton = new JButton("✎");
    basicFoodButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        readBasicFoodPanel = new JPanel(new GridLayout(3, 2));
        readBasicFoodLabel = new JLabel("Enter a basic food: ");
        readBasicFoodTextField = new JTextField();
        createBasicFoodLabel = new JLabel("Create food? ");

        readBasicFoodPanel.add(readBasicFoodLabel);
        readBasicFoodPanel.add(readBasicFoodTextField);
        readBasicFoodPanel.add(createBasicFoodLabel);
        readBasicFoodPanel.add(createBasicFoodButton);

        JOptionPane.showMessageDialog(null, readBasicFoodPanel, "Search or Create Food", JOptionPane.QUESTION_MESSAGE);

        if (readBasicFoodTextField.getText() != null && !readBasicFoodTextField.getText().isEmpty()) {
          if (readBasicFoodTextField.getText() != null && !readBasicFoodTextField.getText().isEmpty()) {
            try {
              String searchFood = readBasicFoodTextField.getText();
              boolean foodExists = false;
              List<BasicFood> basicFoods = healthNCareController.getBasicFoods();
              for (BasicFood basicFood : basicFoods) {
                if (basicFood.getName().equals(searchFood)) {
                  foodExists = true;
                  healthNCareController.getBasicFood(readBasicFoodTextField.getText());
                  BasicFood searchedFood = healthNCareController.getBasicFood(readBasicFoodTextField.getText());

                  searchBasicFoodLabel = new JLabel("Food Details: \nName: " + searchedFood.getName() + "\nCalories: "
                      + searchedFood.getNutritionFacts().getCalories() + "\nFat: "
                      + searchedFood.getNutritionFacts().getFat() + "\nCarbohydrates: "
                      + searchedFood.getNutritionFacts().getCarbohydrates() + "\nProtein: "
                      + searchedFood.getNutritionFacts().getProtein() + "\nSodium: "
                      + searchedFood.getNutritionFacts().getSodium());
                  searchBasicFoodPanel = new JPanel(new GridLayout(6, 2));
                  searchBasicFoodPanel.add(searchBasicFoodLabel);
                  JOptionPane.showMessageDialog(null, searchBasicFoodPanel, "Searched Food",
                      JOptionPane.QUESTION_MESSAGE);
                  break;
                }
              }

              if (!foodExists) {
                JOptionPane.showMessageDialog(GraphicalView.this, "Food does not exist. Please add it first.", "Error",
                    JOptionPane.ERROR_MESSAGE);
                return;
              }
            } catch (NumberFormatException e) {
              return;
            }
          }
        }
      }
    });

    createBasicFoodButton = new JButton("✎");

    createBasicFoodButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ab) {
        createBasicFoodPanel = new JPanel(new GridLayout(6, 2));
        createBasicFoodNameLabel = new JLabel("Name your food: ");
        createBasicFoodNameTextField = new JTextField();

        createBasicFoodCaloriesLabel = new JLabel("Record your ingredients: ");
        createBasicFoodCaloriesLabel = new JLabel("Calories: ");
        createBasicFoodCaloriesTextField = new JTextField(Double.toString(0.0));

        NutritionFacts nutrition = new NutritionFacts();

        createBasicFoodFatLabel = new JLabel("Record your ingredients: ");
        createBasicFoodFatLabel = new JLabel("Fat: ");
        createBasicFoodFatTextField = new JTextField(Double.toString(0.0));

        createBasicFoodCarbsLabel = new JLabel("Record your ingredients: ");
        createBasicFoodCarbsLabel = new JLabel("Carbohydrates: ");
        createBasicFoodCarbsTextField = new JTextField(Double.toString(0.0));

        createBasicFoodProteinLabel = new JLabel("Record your ingredients: ");
        createBasicFoodProteinLabel = new JLabel("Protein: ");
        createBasicFoodProteinTextField = new JTextField(Double.toString(0.0));

        createBasicFoodSodiumLabel = new JLabel("Record your ingredients: ");
        createBasicFoodSodiumLabel = new JLabel("Sodium: ");
        createBasicFoodSodiumTextField = new JTextField(Double.toString(0.0));
        createBasicFoodPanel.add(createBasicFoodNameLabel);
        createBasicFoodPanel.add(createBasicFoodNameTextField);
        createBasicFoodPanel.add(createBasicFoodCaloriesLabel);
        createBasicFoodPanel.add(createBasicFoodCaloriesTextField);
        createBasicFoodPanel.add(createBasicFoodFatLabel);
        createBasicFoodPanel.add(createBasicFoodFatTextField);
        createBasicFoodPanel.add(createBasicFoodCarbsLabel);
        createBasicFoodPanel.add(createBasicFoodCarbsTextField);
        createBasicFoodPanel.add(createBasicFoodProteinLabel);
        createBasicFoodPanel.add(createBasicFoodProteinTextField);
        createBasicFoodPanel.add(createBasicFoodSodiumLabel);
        createBasicFoodPanel.add(createBasicFoodSodiumTextField);
        JOptionPane.showMessageDialog(null, createBasicFoodPanel, "Create Food", JOptionPane.QUESTION_MESSAGE);
        readBasicFoodPanel.add(createBasicFoodButton);

        String foodName = createBasicFoodNameTextField.getText().toString();

        if (createBasicFoodCaloriesTextField.getText() != null
            && !createBasicFoodCaloriesTextField.getText().isEmpty()) {
          try {
            double calories = Double.parseDouble(createBasicFoodCaloriesTextField.getText());
            if (calories < 0) {
              JOptionPane.showMessageDialog(GraphicalView.this, "Calories must be greater than 0.", "Error",
                  JOptionPane.ERROR_MESSAGE);
              return;
            }
          } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(GraphicalView.this, "Invalid input for calories.", "Error",
                JOptionPane.ERROR_MESSAGE);
            return;
          }
        }

        if (createBasicFoodFatTextField.getText() != null && !createBasicFoodFatTextField.getText().isEmpty()) {
          try {
            double fat = Double.parseDouble(createBasicFoodFatTextField.getText());
            if (fat < 0) {
              JOptionPane.showMessageDialog(GraphicalView.this, "Fat must be greater than 0.", "Error",
                  JOptionPane.ERROR_MESSAGE);
              return;
            }
          } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(GraphicalView.this, "Invalid input for fat.", "Error",
                JOptionPane.ERROR_MESSAGE);
            return;
          }
        }

        if (createBasicFoodCarbsTextField.getText() != null && !createBasicFoodCarbsTextField.getText().isEmpty()) {
          try {
            double carbs = Double.parseDouble(createBasicFoodCarbsTextField.getText());
            if (carbs < 0) {
              JOptionPane.showMessageDialog(GraphicalView.this, "Carbohydrates must be greater than 0.", "Error",
                  JOptionPane.ERROR_MESSAGE);
              return;
            }
          } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(GraphicalView.this, "Invalid input for carbohydrates.", "Error",
                JOptionPane.ERROR_MESSAGE);
            return;
          }
        }

        if (createBasicFoodProteinTextField.getText() != null && !createBasicFoodProteinTextField.getText().isEmpty()) {
          try {
            double protein = Double.parseDouble(createBasicFoodProteinTextField.getText());
            if (protein < 0) {
              JOptionPane.showMessageDialog(GraphicalView.this, "Proteins must be greater than 0.", "Error",
                  JOptionPane.ERROR_MESSAGE);
              return;
            }
          } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(GraphicalView.this, "Invalid input for proteins.", "Error",
                JOptionPane.ERROR_MESSAGE);
            return;
          }
        }

        if (createBasicFoodSodiumTextField.getText() != null && !createBasicFoodSodiumTextField.getText().isEmpty()) {
          try {
            double sodium = Double.parseDouble(createBasicFoodSodiumTextField.getText());
            if (sodium < 0) {
              JOptionPane.showMessageDialog(GraphicalView.this, "Sodium must be greater than 0.", "Error",
                  JOptionPane.ERROR_MESSAGE);
              return;
            }
          } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(GraphicalView.this, "Invalid input for sodium.", "Error",
                JOptionPane.ERROR_MESSAGE);
            return;
          }
        }

        nutrition.setCalories(Double.parseDouble(createBasicFoodCaloriesTextField.getText()));
        nutrition.setFat(Double.parseDouble(createBasicFoodFatTextField.getText()));
        nutrition.setCarbohydrates(Double.parseDouble(createBasicFoodCaloriesTextField.getText()));
        nutrition.setProtein(Double.parseDouble(createBasicFoodCaloriesTextField.getText()));
        nutrition.setSodium(Double.parseDouble(createBasicFoodCaloriesTextField.getText()));

        BasicFood basicFood = new BasicFood(foodName, nutrition);

        healthNCareController.createBasicFood(basicFood);
      }
    });
    basicFoodPanel.add(basicFoodLabel);
    basicFoodPanel.add(basicFoodButton);
    mainPanel.add(basicFoodPanel, BorderLayout.CENTER);
  }

  private void recipes() {
    recipesPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    recipesLabel = new JLabel("Recipes:");
    recipesButton = new JButton("✎");
    recipesButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        lookRecipePanel = new JPanel(new GridLayout(3, 2));
        lookRecipeLabel = new JLabel("Look for a recipe: ");
        searchRecipeTextField = new JTextField();
        createRecipeLabel = new JLabel("Create recipe? ");

        lookRecipePanel.add(lookRecipeLabel);
        lookRecipePanel.add(searchRecipeTextField);
        lookRecipePanel.add(createRecipeLabel);
        lookRecipePanel.add(createRecipeButton);

        JOptionPane.showMessageDialog(null, lookRecipePanel, "Search or Create Recipes", JOptionPane.QUESTION_MESSAGE);

        if (searchRecipeTextField.getText() != null && !searchRecipeTextField.getText().isEmpty()) {
          if (searchRecipeTextField.getText() != null && !searchRecipeTextField.getText().isEmpty()) {
            try {
              String searchRecipe = searchRecipeTextField.getText();
              boolean recipeExists = false;
              List<Recipe> recipes = healthNCareController.getRecipes();
              for (Recipe recipe : recipes) {
                if (recipe.getName().equals(searchRecipe)) {
                  recipeExists = true;
                  healthNCareController.getRecipe(searchRecipeTextField.getText());
                  Recipe searchedRecipe = healthNCareController.getRecipe(searchRecipeTextField.getText());

                  StringBuilder ingredientNames = new StringBuilder();
                  for (Ingredients ingredient : searchedRecipe.getIngredients()) {
                    ingredientNames.append(ingredient.getFood().getName()).append(", ");
                  }

                  if (ingredientNames.length() > 0) {
                    ingredientNames.delete(ingredientNames.length() - 2, ingredientNames.length());
                  }

                  searchRecipePanel = new JPanel(new GridLayout(6, 2));
                  searchRecipeLabel = new JLabel(
                      "Recipe Details: " + searchedRecipe.getName() + "\nIngredients: " + ingredientNames.toString());
                  searchRecipeLabel = new JLabel("Recipe Details: " + searchedRecipe.getName() + "\nIngredients: "
                      + searchedRecipe.getIngredients().toString());
                  searchRecipePanel.add(searchRecipeLabel);
                  JOptionPane.showMessageDialog(null, searchRecipePanel, "Searched Recipe",
                      JOptionPane.QUESTION_MESSAGE);
                  JOptionPane.showMessageDialog(null, searchBasicFoodPanel, "Searched Food",
                      JOptionPane.QUESTION_MESSAGE);
                  break;
                }
              }
              if (!recipeExists) {
                JOptionPane.showMessageDialog(GraphicalView.this, "Recipe does not exist. Please add it first.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
                return;
              }
            } catch (NegativeArraySizeException e) {
              return;
            }
          }
        }
      }
    });

    createRecipeButton = new JButton("✎");

    createRecipeButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ab) {
        createRecipePanel = new JPanel(new GridLayout(4, 2));
        createRecipeNameLabel = new JLabel("Name your recipe: ");
        createRecipeNameTextField = new JTextField();

        addIngredientsLabel = new JLabel("Add ingredients (type 'done' when finished): ");
        addIngredientsTextField = new JTextField();

        addIngredientCountLabel = new JLabel("Amount of ingredient: ");
        addIngredientCountTextField = new JTextField(Double.toString(0.0));

        createRecipePanel.add(createRecipeNameLabel);
        createRecipePanel.add(createRecipeNameTextField);
        createRecipePanel.add(addIngredientsLabel);
        createRecipePanel.add(addIngredientsTextField);
        createRecipePanel.add(addIngredientCountLabel);
        createRecipePanel.add(addIngredientCountTextField);

        JOptionPane.showMessageDialog(null, createRecipePanel, "Create Recipe", JOptionPane.QUESTION_MESSAGE);

        String recipeName = createRecipeNameTextField.getText();
        String inpt = " ";
        int ingredientnum = 1;
        List<Ingredients> ingredients = new ArrayList<>();

        while (true) {
          addIngredientsLabel.setText("Ingredient " + ingredientnum + ": ");
          inpt = addIngredientsTextField.getText();
          if (inpt.equals("done")) {
            break;
          }

          double amount = Double.parseDouble(addIngredientCountTextField.getText());
          BasicFood ingredient = healthNCareController.getBasicFood(inpt);
          if (ingredient != null) {
            ingredients.add(new Ingredients(ingredient, amount));
          } else {
            JOptionPane.showMessageDialog(null, "Ingredient not found!", "Error", JOptionPane.ERROR_MESSAGE);
          }
          ingredientnum++;
          break;
        }
        Recipe createRecipe = new Recipe(recipeName, ingredients.toArray(new Ingredients[0]));

        healthNCareController.createRecipe(createRecipe);
      }
    });

    recipesPanel.add(recipesLabel);
    recipesPanel.add(recipesButton);
    mainPanel.add(recipesPanel, BorderLayout.CENTER);
  }
}
