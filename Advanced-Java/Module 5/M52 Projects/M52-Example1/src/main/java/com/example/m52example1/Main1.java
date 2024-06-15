package com.example.m52example1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.Random;

public class Main1 extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        Button topButton = new Button("Top");
        Button middleButton = new Button("Middle");
        Button bottomButton = new Button ("Bottom");
        topButton.setFont(new Font("Arial", 30));
        middleButton.setFont(new Font("Arial", 30));
        bottomButton.setFont(new Font("Arial", 30));
        HBox top = new HBox(topButton);
        HBox middle = new HBox(middleButton);
        HBox bottom = new HBox(bottomButton);
        top.setPrefSize(500, 150);
        middle.setPrefSize(500, 150);
        bottom.setPrefSize(500, 150);
        top.setAlignment(Pos.CENTER);
        middle.setAlignment(Pos.CENTER);
        bottom.setAlignment(Pos.CENTER);
        VBox root = new VBox(top, middle, bottom);

        //Set for three different buttons - Can handle any single button
        //without affecting the other two. The getSource method will return
        //the Object that was interacted with that triggered the event handler.
        EventHandler<ActionEvent> colorChange = new EventHandler<>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Object temp = actionEvent.getSource();
                Button tempButton = (Button) temp;
                Random ran = new Random();
                tempButton.setBackground(new Background(new BackgroundFill(Color.rgb(ran.nextInt(256), ran.nextInt(256), ran.nextInt(256)), CornerRadii.EMPTY, Insets.EMPTY)));
            }
        };

        bottomButton.setOnAction(colorChange);
        topButton.setOnAction(colorChange);
        middleButton.setOnAction(colorChange);

        Scene scene = new Scene(root, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Using getSource()");
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }

}