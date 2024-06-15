package com.example.m51sample6;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
//KeyEvent Example

public class Main6 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        Label label = new Label("");
        HBox root = new HBox(label);
        label.setFont(new Font("Verdana", 40));
        EventHandler<KeyEvent> seeSetText = new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                String currentText = label.getText();
                label.setText(currentText + keyEvent.getText());
            }
        };
        label.setOnKeyPressed(seeSetText);

        Scene scene = new Scene(root, 600, 600);
        primaryStage.setTitle("Greeting");
        primaryStage.setScene(scene);
        primaryStage.show();
        label.requestFocus();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
