package com.example.m52example11;

import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main11 extends Application {

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

        //Listeners can also be created directly within the addListener() method
        //even though this isn't great since we're repeating the same code
        root.widthProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                //finds the smaller of the 2 - width or height of pane
                double length = Math.min(root.getWidth(), root.getHeight());
                circle.setRadius(length/2 - 15);
                rectangle.setWidth(length - 30);
                rectangle.setHeight(length - 30);

            }
        });
        root.heightProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                //finds the smaller of the 2 - width or height of pane
                double length = Math.min(root.getWidth(), root.getHeight());
                circle.setRadius(length/2 - 15);
                rectangle.setWidth(length - 30);
                rectangle.setHeight(length - 30);

            }
        });

        Scene scene = new Scene(root, 140, 140);
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
