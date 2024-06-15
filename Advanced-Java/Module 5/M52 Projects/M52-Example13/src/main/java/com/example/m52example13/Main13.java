package com.example.m52example13;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

//Listener example using lambda and static method

public class Main13 extends Application {
    Circle circle = new Circle(60);
    Rectangle rectangle = new Rectangle(120, 120);
    StackPane root = new StackPane();

    @Override
    public void start(Stage primaryStage) throws Exception{
        circle.setFill(Color.GRAY);
        rectangle.setFill(Color.WHITE);
        rectangle.setStroke(Color.BLACK);
        root.getChildren().addAll(rectangle, circle);

        //Why not create a method outside the start method
        //that will contain the body of the code and then the lambda
        //can just be one line per property
        root.widthProperty().addListener(ov -> resize());
        root.heightProperty().addListener(ov -> resize());

        Scene scene = new Scene(root, 140, 140);
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void resize(){
        double length = Math.min(root.getWidth(), root.getHeight());
        circle.setRadius(length/2 - 15);
        rectangle.setWidth(length - 30);
        rectangle.setHeight(length - 30);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
