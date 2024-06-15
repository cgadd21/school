package com.example.m52example14;

import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

//Another listener example

public class Main14 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Text text = new Text("FUN!");
        text.setFill(Color.RED);
        text.setFont(Font.font("Arial", 50));
        Pane root = new Pane(text);
        text.xProperty().bind(root.widthProperty().divide(3));
        text.yProperty().bind(root.heightProperty().divide(3));

        //Listener to change the font size if the window gets bigger and smaller
        InvalidationListener changeFont = new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                double screenWidth = root.getWidth();
                double fontSize = screenWidth/5;
                text.setFont(Font.font("Arial", fontSize));
            }
        };

        //instead of using .bind(), use addListener() and pass in the Listener object
        root.widthProperty().addListener(changeFont);

        Scene scene = new Scene(root, 400, 400);
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
