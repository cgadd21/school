package com.example.m53example2;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

//Timeline animation - bouncing ball

public class Main2 extends Application {
    double changeX  = 1;
    double changeY = 1;
    double centerX = 200;
    double centerY = 300;

    @Override
    public void start(Stage primaryStage) throws Exception{

        Circle circle = new Circle(centerX, centerY, 30, Color.RED);
        Pane root = new Pane(circle);


        //EventHandler for the animation
        EventHandler<ActionEvent> bounce = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(circle.getCenterX() > 600 || circle.getCenterX() < 0){
                    changeX = changeX * -1;
                }
                if (circle.getCenterY() > 600 || circle.getCenterY() < 0){
                    changeY = changeY * -1;
                }
                centerX += changeX;
                centerY += changeY;
                circle.setCenterX(centerX);
                circle.setCenterY(centerY);
            }
        };

        //An event handler that "deletes" the circle from the screen
        circle.setOnMouseClicked(e-> circle.setVisible(false));
        //once it's invisible, it can no longer receive mouse events or keyboard focus

        KeyFrame frame = new KeyFrame(Duration.millis(50), bounce);
        Timeline animation = new Timeline(frame);
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();

        Scene scene = new Scene(root, 600, 600);
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
