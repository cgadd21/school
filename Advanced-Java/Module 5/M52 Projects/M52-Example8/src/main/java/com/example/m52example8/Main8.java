package com.example.m52example8;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
//Changing the scene on the stage using an event handler

public class Main8 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        /*Nodes, Layout, and Scene for Opening Window*/
        Label titleLabel = createLabel("Account Program", 24, Color.BLACK);
        titleLabel.setMaxWidth(Double.MAX_VALUE);
        titleLabel.setAlignment(Pos.CENTER);

        Button mainAddButton = createButton("Add Account");
        Button mainViewButton = createButton("View Account");
        Button mainDeleteButton = createButton("Delete Account");
        Button mainUpdateButton = createButton("Update Account");

        HBox hBox = new HBox(mainAddButton, mainViewButton, mainDeleteButton, mainUpdateButton);
        hBox.setSpacing(15);
        VBox mainRoot = new VBox(titleLabel, hBox);
        mainRoot.setPadding(new Insets(15));
        mainRoot.setSpacing(25);

        Scene mainScene = new Scene(mainRoot, 875, 170);
        stage.setScene(mainScene);
        stage.setTitle("Account Program");

        /*Nodes, Layout, and Scene for Add Account Scene*/
        Label newLabel = createLabel("New Account", 18, Color.NAVY);
        newLabel.setPrefWidth(Double.MAX_VALUE);
        newLabel.setAlignment(Pos.CENTER);
        Label nameLabel = createLabel("Name", 18, Color.NAVY);
        Label ageLabel = createLabel("Age", 18, Color.NAVY);
        Label cityLabel = createLabel("City", 18, Color.NAVY);
        Label stateLabel = createLabel("State", 18, Color.NAVY);
        TextField nameField = createTextField();
        TextField ageField = createTextField();
        TextField cityField = createTextField();
        TextField stateField = createTextField();
        Button submitButton = createButton("Submit");
        Button fromAddToMainButton = createButton("Back to Main");
        HBox addHBox = new HBox(submitButton, fromAddToMainButton);
        addHBox.setSpacing(30);
        VBox createRoot = new VBox(newLabel, nameLabel, nameField, ageLabel, ageField, cityLabel, cityField, stateLabel, stateField, addHBox);
        createRoot.setPadding(new Insets(20));
        createRoot.setSpacing(10);
        //New scene but not a new stage. I want this window to replace the contents in the current stage.
        Scene createScene = new Scene(createRoot, 900, 600);
        //Do not set this scene to the stage here. Set it in the event handler.

        /*Event Handlers for Main Scene*/
        //Using lambda to set a new scene when the button is pressed
        mainAddButton.setOnAction(e->{
            stage.setScene(createScene);
        });

        mainViewButton.setOnAction(e->{
            //change the scene to the view scene
        });

        mainDeleteButton.setOnAction(e->{
            //change the scene to the delete scene
        });

        mainUpdateButton.setOnAction(e->{
            //change the scene to the update scene
        });

        /*Event Handlers for Add Account scene*/
        submitButton.setOnAction(e->{
            //Add code here that gets all inputs
            //from the form and adds them to a file/database
            //or prints, etc.
        });

        fromAddToMainButton.setOnAction(e->{
            stage.setScene(mainScene);
        });

        /*Event Handlers for Remove Account scene*/

        /*Event Handlers for View Account scene*/

        /*Event Handlers for Update Account scene*/

        stage.show();
    }

    public static Button createButton(String text){
        Button button = new Button(text);
        button.setFont(new Font("Arial", 18));
        button.setPadding(new Insets(20));
        button.setPrefWidth(200);
        return button;
    }

    public static Label createLabel(String text, double fontSize, Color color){
        Label label = new Label(text);
        label.setFont(new Font("Arial", fontSize));
        label.setTextFill(color);
        //label.setPadding(new Insets(insets));
        return label;
    }

    public static TextField createTextField(){
        TextField textField = new TextField();
        textField.setFont(new Font("Arial", 28));
        return textField;
    }

}
