package com.example.m5sample7;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class Main7 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        //Create Button, Labels, and TextFields
        Button button = new Button("Add");
        TextField firstField = new TextField();
        TextField secondField = new TextField();
        Label plusLabel = new Label(" + ");
        Label answerLabel = new Label("");

        //Style controls
        answerLabel.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY,  new BorderWidths(3))));
        answerLabel.setPadding(new Insets(5));

        button.setFont(Font.font("Verdana", 28));
        firstField.setFont(Font.font("Verdana", 28));
        secondField.setFont(Font.font("Verdana", 28));
        plusLabel.setFont(Font.font("Verdana", 28));
        answerLabel.setFont(Font.font("Verdana", 28));

        button.setPrefWidth(400);
        firstField.setPrefWidth(100);
        secondField.setPrefWidth(100);
        answerLabel.setPrefWidth(250);

        //Create layout and style
        HBox root = new HBox(firstField, plusLabel, secondField, button, answerLabel);
        root.setSpacing(25);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.CENTER);

        //ActionEvent EventHandler that get text from textfields,
        //convert it to doubles, and display the answer
        //The setText method requires a String so using String.valueOf is
        //helpful for converting a non-string to a String.
        EventHandler<ActionEvent> myEvent = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String firstNumber = firstField.getText();
                String secondNumber = secondField.getText();
                double num1 = Double.parseDouble(firstNumber);
                double num2 = Double.parseDouble(secondNumber);
                double answer = num1 + num2;
                answerLabel.setText(String.valueOf(answer));
            }
        };
        button.setOnAction(myEvent);

        Scene scene = new Scene(root);
        primaryStage.setTitle("Adder");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
