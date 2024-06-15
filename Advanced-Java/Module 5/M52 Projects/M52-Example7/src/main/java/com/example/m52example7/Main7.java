package com.example.m52example7;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.util.Random;

//Lambda Expression Example

public class Main7 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        Pane pane = new Pane();

        //Using lambda expression with multiple lines of code
        pane.setOnMouseClicked(e->{
            int radius = 300;
            Random ran = new Random();
            for(int i = 0; i < 30; i++){
                Circle circle1 = new Circle(300, 300, radius);
                circle1.setFill(Color.rgb(ran.nextInt(256), ran.nextInt(256), ran.nextInt(256)));
                circle1.setStroke(Color.BLACK);
                radius -= 10;
                pane.getChildren().add(circle1);
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