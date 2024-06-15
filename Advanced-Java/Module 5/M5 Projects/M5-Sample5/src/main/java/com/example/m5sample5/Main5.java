package com.example.m5sample5;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class Main5 extends Application {

    String[] array = {"Hi", "Dog", "Cat", "Bye", "Pie", "Shoe"};

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Create Buttons and Labels and style
        Button greetingButton = new Button("Press for a greeting");
        Label greetingLabel = new Label("Enter Name");
        TextField nameField = new TextField("Enter Name");
        greetingButton.setFont(Font.font("Verdana", 28));
        greetingLabel.setFont(Font.font("Verdana", 28));
        nameField.setFont(Font.font("Verdana", 28));

        Button showButton = new Button("Generate List");
        Label listLabel = new Label("Words in List 1:");
        showButton.setFont(Font.font("Verdana", 28));
        listLabel.setFont(Font.font("Verdana", 28));

        //Create layout and style
        VBox root = new VBox(greetingLabel, nameField, greetingButton, showButton, listLabel);
        root.setPadding(new Insets(20));
        root.setSpacing(20);

        //event handler for greeting - gets text and display message
        EventHandler<ActionEvent> showPersonalizedGreeting = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(nameField.getText().equals("Enter Name")){
                    greetingLabel.setText("Enter your name first!");
                } else if (nameField.getText().length() == 0){
                    greetingLabel.setText("Can't be blank.");
                }
                else {
                    String name = nameField.getText();
                    greetingLabel.setText("Hello, " + name + "!");
                }
            }
        };

        greetingButton.setOnAction(showPersonalizedGreeting);

        //.setText() will overwrite anything in the node
        //concatenating new text to the getText() will preserve current text
        EventHandler<ActionEvent> showList = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                for(int i = 0; i < array.length; i++){
                    listLabel.setText(listLabel.getText() + "\n" + array[i]);
                }
            }
        };

        showButton.setOnAction(showList);

        Scene scene = new Scene(root, 600, 600);
        primaryStage.setTitle("Greeting");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
