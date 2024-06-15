package com.example.lab5_2;

import javafx.animation.*;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        Circle circle = new Circle(10,10,10);
        circle.setFill(Color.rgb(200,0,0));

        Label legend = new Label("""
                {---}-----Legend--------
                Up: Move Object Up
                Down: Move Object Down
                Left: Move Object Left
                Right: Move Object Right
                F: Fade
                1: Stop Fade
                C: Random Color
                2: Stop Random Color
                L: Light Show
                3: Stop Light Show
                S: Increase Size
                4: Decrease Size
                O: Opacity Increase
                5: Opacity Decrease
                P: Color Pattern
                R: Rotating Rectangle?""");
        legend.setFont(Font.font("Time New Roman",12));
        legend.setWrapText(true);

        Pane pane = new Pane(circle,legend);

        //Fade
        FadeTransition fadeCircle = new FadeTransition(Duration.millis(6000), circle);
        fadeCircle.setFromValue(1.0);
        fadeCircle.setToValue(0.1);
        fadeCircle.setCycleCount(FadeTransition.INDEFINITE); 
        fadeCircle.setAutoReverse(true);

        //Random Color
        FillTransition changeFillRandom = new FillTransition(Duration.seconds(5), circle);
        changeFillRandom.setFromValue(Color.rgb(200,0,0));
        Random random = new Random();
        int redValue = random.nextInt(256);
        int greenValue = random.nextInt(256);
        int blueValue = random.nextInt(256);
        changeFillRandom.setToValue(Color.rgb(redValue,greenValue,blueValue));
        changeFillRandom.setCycleCount(FillTransition.INDEFINITE);    //change this to 2 when trying out SequentialTransition
        changeFillRandom.setAutoReverse(true);

        //Light Show
        FillTransition changeFill1 = new FillTransition(Duration.seconds(5), circle);
        changeFill1.setFromValue(Color.rgb(200,0,0));
        changeFill1.setToValue(Color.BLUE);
        changeFill1.setCycleCount(2);
        changeFill1.setAutoReverse(true);
        FillTransition changeFill2 = new FillTransition(Duration.seconds(5), circle);
        changeFill2.setFromValue(Color.ORANGE);
        changeFill2.setToValue(Color.GREEN);
        changeFill2.setCycleCount(2);
        changeFill2.setAutoReverse(true);
        FillTransition changeFill3 = new FillTransition(Duration.seconds(5), circle);
        changeFill3.setFromValue(Color.PURPLE);
        changeFill3.setToValue(Color.YELLOW);
        changeFill3.setCycleCount(2);
        changeFill3.setAutoReverse(true);
        SequentialTransition sequence = new SequentialTransition();
        sequence.getChildren().addAll(changeFill1,changeFill2,changeFill3);
        sequence.setCycleCount(SequentialTransition.INDEFINITE);

        //Size Increase
        ScaleTransition sizeIncrease = new ScaleTransition(Duration.seconds(1), circle);
        sizeIncrease.setFromX(circle.getCenterX());
        sizeIncrease.setToX(circle.getCenterX()+1);;
        sizeIncrease.setFromY(circle.getCenterY());
        sizeIncrease.setToY(circle.getCenterY()+1);


        //Size Decrease
        ScaleTransition sizeDecrease = new ScaleTransition(Duration.seconds(1), circle);
        sizeDecrease.setFromX(circle.getCenterX());
        sizeDecrease.setToX(circle.getCenterX()-1);
        sizeDecrease.setFromY(circle.getCenterY());
        sizeDecrease.setToY(circle.getCenterY()-1);

        //Opacity Increase
        FadeTransition fadeCircleIncrease = new FadeTransition(Duration.millis(6000), circle);
        fadeCircleIncrease.setFromValue(circle.getOpacity());
        fadeCircleIncrease.setToValue(circle.getOpacity()+0.5);

        //Opacity Decrease
        FadeTransition fadeCircleDecrease = new FadeTransition(Duration.millis(6000), circle);
        fadeCircleDecrease.setFromValue(circle.getOpacity());
        fadeCircleDecrease.setToValue(circle.getOpacity()-0.5);

        //Color Pattern
        final boolean[] redCircle = {false};
        final boolean[] greenCircle = {false};
        final boolean[] blueCircle = {false};

        //Rotating Rectangle
        Rectangle square = new Rectangle(100, 100, Color.rgb(redValue,greenValue,blueValue));
        square.setX(250);
        square.setY(250);
        RotateTransition spin = new RotateTransition(Duration.millis(2000), square);
        spin.setFromAngle(0);
        spin.setToAngle(360);
        spin.setCycleCount(RotateTransition.INDEFINITE);
        spin.setAutoReverse(true);
        AtomicBoolean isIn = new AtomicBoolean(false);

        EventHandler<KeyEvent> controlCircle = keyEvent -> {
            if(keyEvent.getCode()== KeyCode.UP){
                circle.setCenterY(circle.getCenterY()-10);
            } else if(keyEvent.getCode()==KeyCode.DOWN){
                circle.setCenterY(circle.getCenterY()+10);
            } else if(keyEvent.getCode()==KeyCode.RIGHT){
                circle.setCenterX(circle.getCenterX()+10);
            } else if(keyEvent.getCode()==KeyCode.LEFT){
                circle.setCenterX(circle.getCenterX()-10);
            } else if (keyEvent.getCode()==KeyCode.getKeyCode("F")) {
                fadeCircle.play();
            } else if (keyEvent.getCode()==KeyCode.getKeyCode("1")) {
                fadeCircle.pause();
            } else if (keyEvent.getCode()==KeyCode.getKeyCode("C")) {
                changeFillRandom.play();
            } else if (keyEvent.getCode()==KeyCode.getKeyCode("2")) {
                changeFillRandom.pause();
            } else if (keyEvent.getCode()==KeyCode.getKeyCode("L")) {
                sequence.play();
            } else if (keyEvent.getCode()==KeyCode.getKeyCode("3")) {
                sequence.pause();
            } else if (keyEvent.getCode()==KeyCode.getKeyCode("S")) {
                sizeIncrease.play();
            } else if (keyEvent.getCode()==KeyCode.getKeyCode("4")) {
                sizeDecrease.play();
            } else if (keyEvent.getCode()==KeyCode.getKeyCode("O")) {
                fadeCircleIncrease.play();
            } else if (keyEvent.getCode()==KeyCode.getKeyCode("5")) {
                fadeCircleDecrease.play();
            } else if (keyEvent.getCode()==KeyCode.getKeyCode("P")) {
                if(redCircle[0]){
                    circle.setFill(Color.GREEN);
                    redCircle[0] =false;
                    greenCircle[0] =true;
                } else if (greenCircle[0]) {
                    circle.setFill(Color.BLUE);
                    greenCircle[0] =false;
                    blueCircle[0] =true;
                } else if (blueCircle[0]){
                    circle.setFill(Color.RED);
                    blueCircle[0] =false;
                    redCircle[0] =true;
                } else {
                    circle.setFill(Color.RED);
                    redCircle[0] =true;
                }
            } else if (keyEvent.getCode()==KeyCode.getKeyCode("R")) {
                if(!isIn.get()) {
                    pane.getChildren().add(square);
                    spin.play();
                    isIn.set(true);
                } else {
                    pane.getChildren().remove(square);
                    spin.pause();
                    isIn.set(false);
                }
            }
        };

        circle.setOnKeyPressed(controlCircle);

        pane.widthProperty().addListener(ov -> {
            int widthDiff = (int)pane.getWidth();
            if(widthDiff>255) {
                circle.setFill(Color.rgb(255, 0, 0));
            } else {
                circle.setFill(Color.rgb(widthDiff,0,0));
            }
                }
        );

        Scene scene = new Scene(pane, 600, 600);
        stage.setScene(scene);
        stage.setTitle("Lab 5.2");
        stage.show();
        circle.requestFocus();

    }

    public static void main(String[] args) {
        launch();
    }
}