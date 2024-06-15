package com.example.m52example12;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

//Listener example using lambda

public class Main12 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Circle circle = new Circle(60);
        Rectangle rectangle = new Rectangle(120, 120);
        //StackPane allows you to stack nodes on top of each other
        //with default positioning in the center of the window
        StackPane root = new StackPane();

        circle.setFill(Color.GRAY);
        rectangle.setFill(Color.WHITE);
        rectangle.setStroke(Color.BLACK);
        root.getChildren().addAll(rectangle, circle);

        //Lambda can be used within the addListener method
        //The object is typically called ov instead of e
        root.widthProperty().addListener(ov -> {
                    double length = Math.min(root.getWidth(), root.getHeight());
                    circle.setRadius(length/2 - 15);
                    rectangle.setWidth(length - 30);
                    rectangle.setHeight(length - 30);
                }
        );
        root.heightProperty().addListener(ov -> {
                    double length = Math.min(root.getWidth(), root.getHeight());
                    circle.setRadius(length/2 - 15);
                    rectangle.setWidth(length - 30);
                    rectangle.setHeight(length - 30);
                }
        );

        Scene scene = new Scene(root, 140, 140);
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
