package com.example.m51sample4;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.util.Random;

//MouseEvent Example
public class Main4 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        Pane pane = new Pane();

        EventHandler<MouseEvent> drawCircles = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                int size = 300;
                for(int i = 0; i < 30; i++){
                    Circle circle1 = new Circle(300, 300, size);
                    Random ran = new Random();
                    int red = ran.nextInt(256);
                    int green = ran.nextInt(256);
                    int blue = ran.nextInt(256);
                    circle1.setFill(Color.rgb(red, green, blue));
                    circle1.setStroke(Color.BLACK);
                    size -= 10;
                    pane.getChildren().add(circle1);
                }
            }
        };
        pane.setOnMouseClicked(drawCircles);

        Scene scene = new Scene(pane, 600, 600);
        primaryStage.setTitle("Greeting");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
