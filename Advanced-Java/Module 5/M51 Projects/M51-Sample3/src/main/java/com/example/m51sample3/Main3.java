package com.example.m51sample3;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

//MouseEvent Example
public class Main3 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Text words = new Text(200, 200, "Words");
        words.setFont(new Font("Arial", 40));

        Pane pane = new Pane(words);
        //Using MouseEvent methods to get metadata about mouse event
        EventHandler<MouseEvent> showInfo = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                String buttonType = "Button: " + mouseEvent.getButton() + "\n";
                String xLocation = "X Location: " + mouseEvent.getX() + "\n";
                String yLocation = "Y Location: " + mouseEvent.getY() + "\n";
                String clicks = "# of clicks: " + mouseEvent.getClickCount();
                words.setText(buttonType + xLocation + yLocation + clicks);
            }
        };
        pane.setOnMouseClicked(showInfo);

        Scene scene = new Scene(pane, 600, 600);
        primaryStage.setTitle("Greeting");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
