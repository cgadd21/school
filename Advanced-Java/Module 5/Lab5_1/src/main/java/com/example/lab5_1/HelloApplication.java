package com.example.lab5_1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        HBox topPane = new HBox();
        HBox bottomPane = new HBox();
        VBox leftPane = new VBox();
        VBox rightPane = new VBox();
        VBox centerPane = new VBox();
        BorderPane root = new BorderPane(centerPane, topPane, rightPane, bottomPane, leftPane);

        Label titleLabel = createTitle("Conversion Calculator");

        Label labelLeft = createLabel("From:");
        Label labelRight = createLabel("To:");

        Label labelOutput = createOutput("");

        TextField textField = createTextField("");

        RadioButton radioButtonMetersLeft = createRadioButtonLeft("Meters");
        RadioButton radioButtonKilometersLeft = createRadioButtonLeft("Kilometers");
        RadioButton radioButtonYardsLeft = createRadioButtonLeft("Yards");
        RadioButton radioButtonMilesLeft = createRadioButtonLeft("Miles");

        ToggleGroup radioButtonsLeft = new ToggleGroup();
        radioButtonMetersLeft.setToggleGroup(radioButtonsLeft);
        radioButtonKilometersLeft.setToggleGroup(radioButtonsLeft);
        radioButtonYardsLeft.setToggleGroup(radioButtonsLeft);
        radioButtonMilesLeft.setToggleGroup(radioButtonsLeft);

        RadioButton radioButtonMetersRight = createRadioButtonRight("Meters");
        RadioButton radioButtonKilometersRight = createRadioButtonRight("Kilometers");
        RadioButton radioButtonYardsRight = createRadioButtonRight("Yards");
        RadioButton radioButtonMilesRight = createRadioButtonRight("Miles");

        ToggleGroup radioButtonsRight = new ToggleGroup();
        radioButtonMetersRight.setToggleGroup(radioButtonsRight);
        radioButtonKilometersRight.setToggleGroup(radioButtonsRight);
        radioButtonYardsRight.setToggleGroup(radioButtonsRight);
        radioButtonMilesRight.setToggleGroup(radioButtonsRight);

        Button buttonConvert = createButton("Convert");

        topPane.setPadding(new Insets(30));
        topPane.setSpacing(30);
        topPane.setAlignment(Pos.CENTER);
        topPane.getChildren().add(titleLabel);

        leftPane.setPadding(new Insets(10));
        leftPane.setSpacing(10);
        leftPane.setAlignment(Pos.CENTER);
        leftPane.getChildren().addAll(labelLeft, textField, radioButtonMetersLeft, radioButtonKilometersLeft, radioButtonYardsLeft, radioButtonMilesLeft);

        rightPane.setPadding(new Insets(10));
        rightPane.setSpacing(10);
        rightPane.setAlignment(Pos.CENTER);
        rightPane.getChildren().addAll(labelRight, labelOutput, radioButtonMetersRight, radioButtonKilometersRight, radioButtonYardsRight, radioButtonMilesRight);

        bottomPane.setPadding(new Insets(10));
        bottomPane.setSpacing(10);
        bottomPane.setAlignment(Pos.CENTER);
        bottomPane.getChildren().add(buttonConvert);

        EventHandler<ActionEvent> myEvent = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String firstNumber = textField.getText();
                double input = Double.parseDouble(firstNumber);
                double answer;
                if(radioButtonMetersLeft.isSelected() && radioButtonMetersRight.isSelected()){
                    answer = input * 1;
                    String formAnswer = String.format("%,5f", answer);
                    labelOutput.setText(String.valueOf(formAnswer));
                } else if (radioButtonMetersLeft.isSelected() && radioButtonKilometersRight.isSelected()) {
                    answer = input / 1000;
                    String formAnswer = String.format("%,5f", answer);
                    labelOutput.setText(String.valueOf(formAnswer));
                } else if (radioButtonMetersLeft.isSelected() && radioButtonYardsRight.isSelected()) {
                    answer = input * 1.09361;
                    String formAnswer = String.format("%,5f", answer);
                    labelOutput.setText(String.valueOf(formAnswer));
                } else if (radioButtonMetersLeft.isSelected() && radioButtonMilesRight.isSelected()) {
                    answer = input * 0.000621371;
                    String formAnswer = String.format("%,5f", answer);
                    labelOutput.setText(String.valueOf(formAnswer));
                } else if (radioButtonKilometersLeft.isSelected() && radioButtonKilometersRight.isSelected()) {
                    answer = input * 1;
                    String formAnswer = String.format("%,5f", answer);
                    labelOutput.setText(String.valueOf(formAnswer));
                } else if (radioButtonKilometersLeft.isSelected() && radioButtonMetersRight.isSelected()) {
                    answer = input * 1000;
                    String formAnswer = String.format("%,5f", answer);
                    labelOutput.setText(String.valueOf(formAnswer));
                } else if (radioButtonKilometersLeft.isSelected() && radioButtonYardsRight.isSelected()) {
                    answer = input * 1093.61;
                    String formAnswer = String.format("%,5f", answer);
                    labelOutput.setText(String.valueOf(formAnswer));
                } else if (radioButtonKilometersLeft.isSelected() && radioButtonMilesRight.isSelected()) {
                    answer = input * 0.621371;
                    String formAnswer = String.format("%,5f", answer);
                    labelOutput.setText(String.valueOf(formAnswer));
                } else if (radioButtonYardsLeft.isSelected() && radioButtonYardsRight.isSelected()) {
                    answer = input * 1;
                    String formAnswer = String.format("%,5f", answer);
                    labelOutput.setText(String.valueOf(formAnswer));
                } else if (radioButtonYardsLeft.isSelected() && radioButtonMetersRight.isSelected()) {
                    answer = input * 0.9144;
                    String formAnswer = String.format("%,5f", answer);
                    labelOutput.setText(String.valueOf(formAnswer));
                } else if (radioButtonYardsLeft.isSelected() && radioButtonKilometersRight.isSelected()) {
                    answer = input * 0.0009144;
                    String formAnswer = String.format("%,5f", answer);
                    labelOutput.setText(String.valueOf(formAnswer));
                } else if (radioButtonYardsLeft.isSelected() && radioButtonMilesRight.isSelected()) {
                    answer = input * 0.000568582;
                    String formAnswer = String.format("%,5f", answer);
                    labelOutput.setText(String.valueOf(formAnswer));
                } else if (radioButtonMilesLeft.isSelected() && radioButtonMilesRight.isSelected()) {
                    answer = input * 1;
                    String formAnswer = String.format("%,5f", answer);
                    labelOutput.setText(String.valueOf(formAnswer));
                } else if (radioButtonMilesLeft.isSelected() && radioButtonMetersRight.isSelected()) {
                    answer = input * 1609.34;
                    String formAnswer = String.format("%,5f", answer);
                    labelOutput.setText(String.valueOf(formAnswer));
                } else if (radioButtonMilesLeft.isSelected() && radioButtonKilometersRight.isSelected()) {
                    answer = input * 1.60934;
                    String formAnswer = String.format("%,5f", answer);
                    labelOutput.setText(String.valueOf(formAnswer));
                } else if (radioButtonMilesLeft.isSelected() && radioButtonYardsRight.isSelected()) {
                    answer = input * 1760;
                    String formAnswer = String.format("%,5f", answer);
                    labelOutput.setText(String.valueOf(formAnswer));
                }
            }
        };
        buttonConvert.setOnAction(myEvent);
        Scene scene = new Scene(root, 800, 500);
        stage.setScene(scene);
        stage.setTitle("Conversion Calculator");
        stage.show();
    }

    public static Label createTitle(String text){
        Label label = new Label(text);
        label.setPrefWidth(600);
        label.setFont(Font.font("Times New Roman", FontWeight.BOLD, 30));
        label.setWrapText(true);
        label.setAlignment(Pos.CENTER);
        return label;
    }

    public static Label createLabel(String text){
        Label label = new Label(text);
        label.setPrefWidth(150);
        label.setFont(Font.font("Times New Roman",28));
        label.setWrapText(true);
        label.setAlignment(Pos.CENTER);
        return label;
    }
    public static Label createOutput(String text){
        Label output = new Label(text);
        output.setPadding(new Insets(50));
        output.setPrefWidth(300);
        output.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY,  new BorderWidths(3))));
        output.setPadding(new Insets(5));
        output.setAlignment(Pos.CENTER);
        return output;
    }

    public static TextField createTextField(String text){
        TextField textField = new TextField(text);
        textField.setPromptText(text);
        textField.setPadding(new Insets(5));
        textField.setPrefWidth(300);
        textField.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY,  new BorderWidths(3))));
        textField.setAlignment(Pos.CENTER);
        return textField;
    }

    public static RadioButton createRadioButtonLeft(String text){
        RadioButton radioButton = new RadioButton(text);
        radioButton.setPrefWidth(300);
        radioButton.setPrefHeight(50);
        radioButton.setPadding(new Insets(5));
        radioButton.setFont(Font.font("Times New Roman",18));
        radioButton.setTextFill(Color.BLUE);
        radioButton.setAlignment(Pos.CENTER);
        return radioButton;
    }

    public static RadioButton createRadioButtonRight(String text){
        RadioButton radioButton = new RadioButton(text);
        radioButton.setPrefWidth(300);
        radioButton.setPrefHeight(50);
        radioButton.setPadding(new Insets(5));
        radioButton.setFont(Font.font("Times New Roman",18));
        radioButton.setTextFill(Color.RED);
        radioButton.setAlignment(Pos.CENTER);
        return radioButton;
    }

    public static Button createButton(String text){
        Button button = new Button(text);
        button.setPrefWidth(800);
        button.setPrefHeight(50);
        button.setPadding(new Insets(22));
        button.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20));
        button.setAlignment(Pos.CENTER);
        return button;
    }

    public static void main(String[] args) {
        launch();
    }
}