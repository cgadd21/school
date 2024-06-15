package com.example.m41;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import java.io.IOException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Button button1 = new Button("#1");
        Button button2 = new Button("#2");
        Button button3 = new Button("#3");

        Label optionsLabel = new Label("Your Options:");
        Label resultsLabel = new Label("Your Results:");

        TextField nameTextField = new TextField("Your Name Here");

        button1.setPrefHeight(200);
        button1.setPrefWidth(200);
        button2.setPrefHeight(200);
        button2.setPrefWidth(200);
        button3.setPrefHeight(200);
        button3.setPrefWidth(200);

        button1.setFont(new Font("Comic Sans MS", 30));
        button2.setFont(new Font("Comic Sans MS", 30));
        button3.setFont(new Font("Comic Sans MS", 30));

        optionsLabel.setFont(new Font("Comic Sans MS", 30));
        resultsLabel.setFont(new Font("Comic Sans MS", 30));

        nameTextField.setFont(new Font("Calibri", 25));

        button1.setTextFill(Color.rgb(11, 200, 255));
        button2.setTextFill(Color.rgb(11, 200, 255));
        button3.setTextFill(Color.rgb(11, 200, 255));

        optionsLabel.setTextFill(Color.PURPLE);
        resultsLabel.setTextFill(Color.PURPLE);

        button1.setAlignment(Pos.BOTTOM_LEFT);
        button2.setAlignment(Pos.BOTTOM_LEFT);
        button3.setAlignment(Pos.BOTTOM_LEFT);

        //TextArea example - add this object to HBox to view
        TextArea essayTextArea = new TextArea("Paste essay here");
        essayTextArea.setFont(new Font("Verdana", 22));
        essayTextArea.setPrefRowCount(2);
        essayTextArea.setPrefColumnCount(20);
        essayTextArea.setWrapText(true);

        //CheckBox example - add these objects to HBox to view
        CheckBox pizzaCheck = new CheckBox("Pizza");
        CheckBox saladCheck = new CheckBox("Salad");
        CheckBox chickenCheck = new CheckBox("Chicken");
        CheckBox pastaCheck = new CheckBox("Pasta");
        CheckBox cakeCheck = new CheckBox("Cake");

        pizzaCheck.setFont(new Font("Arial Black", 18));
        saladCheck.setFont(new Font("Arial Black", 18));
        chickenCheck.setFont(new Font("Arial Black", 18));
        pastaCheck.setFont(new Font("Arial Black", 18));
        cakeCheck.setFont(new Font("Arial Black", 18));

        pizzaCheck.setPadding(new Insets(15));
        saladCheck.setPadding(new Insets(15));
        chickenCheck.setPadding(new Insets(15));
        pastaCheck.setPadding(new Insets(15));
        cakeCheck.setPadding(new Insets(15));

        pizzaCheck.setTextFill(Color.DARKGREEN);
        saladCheck.setTextFill(Color.DARKGREEN);
        chickenCheck.setTextFill(Color.DARKGREEN);
        pastaCheck.setTextFill(Color.DARKGREEN);
        cakeCheck.setTextFill(Color.DARKGREEN);

        //RadioButton example - add these objects to HBox to view
        RadioButton redButton = new RadioButton("Red");
        RadioButton blueButton = new RadioButton("Blue");
        RadioButton yellowButton = new RadioButton("Yellow");
        RadioButton greenButton = new RadioButton("Green");

        //ToggleGroup does NOT get added to HBox
        ToggleGroup colorButtons = new ToggleGroup();

        redButton.setToggleGroup(colorButtons);
        blueButton.setToggleGroup(colorButtons);
        yellowButton.setToggleGroup(colorButtons);
        greenButton.setToggleGroup(colorButtons);

        redButton.setFont(new Font("Trebuchet MS", 20));
        blueButton.setFont(new Font("Trebuchet MS", 20));
        yellowButton.setFont(new Font("Trebuchet MS", 20));
        greenButton.setFont(new Font("Trebuchet MS", 20));

        redButton.setPadding(new Insets(30));
        blueButton.setPadding(new Insets(30));
        yellowButton.setPadding(new Insets(30));
        greenButton.setPadding(new Insets(30));

        HBox root = new HBox(nameTextField, optionsLabel, button1, button2, button3, resultsLabel);

        Scene scene = new Scene(root);
        stage.setTitle("Push The Buttons");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}