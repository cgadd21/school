package com.example.m53example1;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

//Timeline Animation - blinking text

public class Main1 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Text text = new Text("FUN!");

        text.setFill(Color.RED);
        text.setFont(Font.font("Arial", 50));
        Pane root = new Pane(text);
        text.xProperty().bind(root.widthProperty().divide(3));
        text.yProperty().bind(root.heightProperty().divide(3));

        //EventHandler for the animation
        EventHandler<ActionEvent> blinky = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(text.getText().length() != 0){
                    text.setText("");
                } else {
                    text.setText("FUN!");
                }
            }
        };

        //Using event handler in KeyFrame and Timeline to animate it
        KeyFrame frame = new KeyFrame(Duration.millis(500), blinky);
        Timeline animation = new Timeline(frame);
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();

        //Mouse event to pause and play the animation with mouse click
        text.setOnMouseClicked(e -> {
            if(animation.getStatus() == Animation.Status.PAUSED){
                animation.play();
            } else {
                animation.pause();
            }
        });

        //Listener to change the font size if the window gets bigger and smaller
        root.widthProperty().addListener(observable -> {
            double screenWidth = root.getWidth();
            double fontSize = screenWidth/5;
            text.setFont(Font.font("Arial", fontSize));

        });

        Scene scene = new Scene(root, 400, 400);
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
