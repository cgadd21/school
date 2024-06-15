package com.example.m52example4;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

//Creating new EventHandler directly in convenience method

public class Main4 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Text words = new Text(200, 200, "Words");
        words.setFont(new Font("Arial", 40));

        Pane pane = new Pane(words);

        pane.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                String buttonType = "Button: " + mouseEvent.getButton() + "\n";
                String xLocation = "X Location: " + mouseEvent.getX() + "\n";
                String yLocation = "Y Location: " + mouseEvent.getY() + "\n";
                String clicks = "# of clicks: " + mouseEvent.getClickCount();
                words.setText(buttonType + xLocation + yLocation + clicks);
            }
        });

        Scene scene = new Scene(pane, 600, 600);
        primaryStage.setTitle("Greeting");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
