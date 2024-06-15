package com.example.m51sample5;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
//KeyEvent Example

public class Main5 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        Circle circle = new Circle(300,300,30);
        Pane pane = new Pane(circle);
        circle.setFill(Color.RED);
        EventHandler<KeyEvent> controlCircle = new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if(keyEvent.getCode()== KeyCode.UP){
                    circle.setCenterY(circle.getCenterY()-10);
                } else if(keyEvent.getCode()==KeyCode.DOWN){
                    circle.setCenterY(circle.getCenterY()+10);
                } else if(keyEvent.getCode()==KeyCode.RIGHT){
                    circle.setCenterX(circle.getCenterX()+10);
                } else if(keyEvent.getCode()==KeyCode.LEFT){
                    circle.setCenterX(circle.getCenterX()-10);
                }
            }
        };
        circle.setOnKeyPressed(controlCircle);

        Scene scene = new Scene(pane, 600, 600);
        primaryStage.setTitle("Greeting");
        primaryStage.setScene(scene);
        primaryStage.show();
        circle.requestFocus();//must include this line of code for key events!
    }

    public static void main(String[] args) {
        launch(args);
    }
}
