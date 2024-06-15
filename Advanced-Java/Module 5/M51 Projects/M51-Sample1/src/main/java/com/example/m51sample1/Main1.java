package com.example.m51sample1;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.util.Random;

//MouseEvent example
public class Main1 extends Application {
    Random random = new Random();

    @Override
    public void start(Stage primaryStage) throws Exception{
        Circle circle = new Circle(200, 200, 100, Color.BLACK);

        Pane pane = new Pane(circle);

        EventHandler<MouseEvent> changeColor = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if(circle.getFill() == Color.BLACK){
                    int red = random.nextInt(256);
                    int green = random.nextInt(256);
                    int blue = random.nextInt(256);
                    circle.setFill(Color.rgb(red, green, blue));
                } else {
                    circle.setFill(Color.BLACK);
                }
            }
        };
        circle.setOnMouseClicked(changeColor);

        Scene scene = new Scene(pane, 600, 600);
        primaryStage.setTitle("Greeting");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
