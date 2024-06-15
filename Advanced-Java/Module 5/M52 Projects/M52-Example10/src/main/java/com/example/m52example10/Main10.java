package com.example.m52example10;

import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

//Listener Example

public class Main10 extends Application {

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

        //Listener to shape sizes if the window gets bigger and smaller
        //We could also use property binding to do this but the listener
        //gives us more freedom to customize
        InvalidationListener changeSize = new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                //finds the smaller of the 2 - width or height of pane
                double length = Math.min(root.getWidth(), root.getHeight());
                circle.setRadius(length/2 - 15);
                rectangle.setWidth(length - 30);
                rectangle.setHeight(length - 30);

            }
        };
        //instead of using .bind(), use addListener() and pass in the Listener object
        //we're adding a listener that will listen if the width of the root changes
        //and the same listener that will listen if the height of the root changes
        root.widthProperty().addListener(changeSize);
        root.heightProperty().addListener(changeSize);

        Scene scene = new Scene(root, 140, 140);
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
