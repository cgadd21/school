package com.example.m5sample4;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

//This example uses an anonymous inner class to define the event handler.

public class Main4 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Create Button and Label and style button and label
        Button greetingButton = new Button("Press for a greeting");
        Label greetingLabel = new Label("Nothing to see here...");
        greetingButton.setFont(Font.font("Verdana", 28));
        greetingLabel.setFont(Font.font("Verdana", 28));

        //Create layout and style
        BorderPane root = new BorderPane();
        root.setTop(greetingButton);
        root.setCenter(greetingLabel);
        BorderPane.setAlignment(greetingButton, Pos.CENTER);
        root.setPadding(new Insets(20));

        //Anonymous inner class to define handle() method - named class not necessary
        EventHandler<ActionEvent> myEvent = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                greetingLabel.setText("Hello World Action Event");
            }
        };

        greetingButton.setOnAction(myEvent);

        Scene scene = new Scene(root, 600, 600);
        primaryStage.setTitle("Greeting");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}


