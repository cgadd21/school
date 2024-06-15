package com.example.m52example9;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.stage.Stage;
//Displaying a second stage with an event handler

public class Main9 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        //Controls for main menu
        Button button = new Button("Click Me");
        modifyButton(button);

        Scene mainScene = new Scene(button, 300, 200);
        stage.setScene(mainScene);
        stage.setTitle("Surprise Message");
        stage.show();

        ///Controls for new scene and stage
        Label messageLabel = new Label("Life's a box of chocolates.");
        messageLabel.setFont(new Font("Arial", 40));
        Scene messageScene = new Scene(messageLabel, 500, 100);
        Stage messageStage = new Stage();  //stage is created but not shown
        messageStage.setScene(messageScene);

        //Using lambda to show a new stage
        button.setOnAction(e->{
            messageStage.show();
        });


    }

    public static void modifyButton(Button node){
        node.setFont(new Font("Arial", 18));
        node.setPadding(new Insets(20));
        node.setPrefWidth(200);

    }
}
