package com.example.m53example4;


import javafx.animation.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

//Examples of different Transition types - see video as some parts may need commented out

public class Main4 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Circle circle = new Circle(200, 200, 50);
        Circle circle1 = new Circle(400, 400, 50);
        Circle circle2 = new Circle(400, 200, 50);
        Rectangle square = new Rectangle(100, 100, Color.LIGHTSKYBLUE);

        FadeTransition fadeCircle = new FadeTransition(Duration.millis(3000), circle);
        fadeCircle.setFromValue(1.0);
        fadeCircle.setToValue(0.1);
        fadeCircle.setCycleCount(FadeTransition.INDEFINITE);    //change this to 2 when trying out SequentialTransition
        fadeCircle.setAutoReverse(true);
        fadeCircle.play();  //comment this line out when trying out SequentialTransition below


        FillTransition changeFill = new FillTransition(Duration.seconds(5), circle1);
        changeFill.setFromValue(Color.RED);
        changeFill.setToValue(Color.GREENYELLOW);
        changeFill.setCycleCount(FillTransition.INDEFINITE);    //change this to 2 when trying out SequentialTransition
        changeFill.setAutoReverse(true);
        changeFill.play();    //comment this line out when trying out SequentialTransition below

        square.setX(250);
        square.setY(250);
        RotateTransition spin = new RotateTransition(Duration.millis(2000), square);
        spin.setFromAngle(0);
        spin.setToAngle(360);
        spin.setCycleCount(RotateTransition.INDEFINITE);  //change this to 2 when trying out SequentialTransition
        spin.setAutoReverse(true);
        spin.play();          //comment this line out when trying out SequentialTransition below

        circle2.setFill(Color.DARKVIOLET);
        ScaleTransition size = new ScaleTransition(Duration.seconds(4), circle2);
        size.setFromX(1.0);
        size.setToX(0.2);
        size.setFromY(1.0);
        size.setToY(0.2);
        size.setCycleCount(ScaleTransition.INDEFINITE); //change this to 2 when trying out SequentialTransition
        size.setAutoReverse(true);
        size.play();          //comment this line out when trying out SequentialTransition below

        /*SequentialTransition sequence = new SequentialTransition();
        sequence.getChildren().addAll(fadeCircle, changeFill, spin, size);
        sequence.setCycleCount(SequentialTransition.INDEFINITE);
        sequence.play();*/

        /*ParallelTransition sameTime = new ParallelTransition();
        sameTime.getChildren().addAll(fadeCircle, changeFill, spin, size);
        sameTime.setCycleCount(ParallelTransition.INDEFINITE);
        sameTime.play();*/

        Pane root = new Pane(circle, circle1, square, circle2);

        Scene scene = new Scene(root, 600, 600);
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(scene);
        primaryStage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }
}
