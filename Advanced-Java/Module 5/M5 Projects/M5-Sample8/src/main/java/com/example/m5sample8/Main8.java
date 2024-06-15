package com.example.m5sample8;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class Main8 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        //Create Button, Labels, and TextFields
        RadioButton redChoice = new RadioButton("Red");
        RadioButton blueChoice = new RadioButton("Blue");
        RadioButton yellowChoice = new RadioButton("Yellow");
        RadioButton greenChoice = new RadioButton("Green");
        Button submitButton = new Button("Submit");
        Label feedbackLabel = new Label("");
        Label titleLabel = new Label("Choose a color");
        Label fortuneLabel = new Label("Your Fortune");


        redChoice.setFont(Font.font("Verdana", 28));
        redChoice.setTextFill(Color.RED);
        blueChoice.setFont(Font.font("Verdana", 28));
        blueChoice.setTextFill(Color.BLUE);
        yellowChoice.setFont(Font.font("Verdana", 28));
        yellowChoice.setTextFill(Color.DARKGOLDENROD);
        greenChoice.setFont(Font.font("Verdana", 28));
        greenChoice.setTextFill(Color.GREEN);
        submitButton.setFont(Font.font("Verdana", 28));
        feedbackLabel.setFont(Font.font("Verdana", 28));
        titleLabel.setFont(Font.font("Verdana", 40));
        fortuneLabel.setFont(Font.font("Verdana", 40));

        //Provides logical grouping so that Java knows only one can be selected at a time
        ToggleGroup colors = new ToggleGroup();
        redChoice.setToggleGroup(colors);
        blueChoice.setToggleGroup(colors);
        yellowChoice.setToggleGroup(colors);
        greenChoice.setToggleGroup(colors);

        HBox radios = new HBox(redChoice, blueChoice, yellowChoice, greenChoice);
        radios.setSpacing(20);

        VBox root = new VBox(titleLabel, radios, submitButton, fortuneLabel, feedbackLabel);

        //Create layout and style
        root.setSpacing(20);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.CENTER);

        //ActionEvent EventHandler that checks to see which radio button is selected.
        EventHandler<ActionEvent> showFortune = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String response;
                if(redChoice.isSelected()){
                    response = "You are a very nice pizza.";
                    feedbackLabel.setTextFill(Color.RED);
                } else if(blueChoice.isSelected()){
                    response = "Your shoes will always be helpful.";
                    feedbackLabel.setTextFill(Color.BLUE);
                } else if(yellowChoice.isSelected()){
                    response = "You are better than mediocre trees.";
                    feedbackLabel.setTextFill(Color.DARKGOLDENROD);
                } else {
                    response = "Your face is on your head quite nicely.";
                    feedbackLabel.setTextFill(Color.GREEN);
                }
                feedbackLabel.setText(response);
            }
        };
        submitButton.setOnAction(showFortune);

        Scene scene = new Scene(root);
        primaryStage.setTitle("Fortune");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
