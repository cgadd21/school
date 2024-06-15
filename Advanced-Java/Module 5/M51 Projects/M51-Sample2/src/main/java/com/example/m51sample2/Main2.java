package com.example.m51sample2;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

//MouseEvent Example
public class Main2 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        Pane pane = new Pane(new Text(200, 200, "Hello"));

        //Create 2 named Background objects to be used in event handler
        Background whitePane = new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY));
        Background redPane = new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY));
        pane.setBackground(whitePane); //set initially to white

        EventHandler<MouseEvent> background = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if(pane.getBackground() == whitePane){
                    pane.setBackground(redPane);
                } else {
                    pane.setBackground(whitePane);
                }
            }
        };
        pane.setOnMouseExited(background);

        Scene scene = new Scene(pane, 600, 600);
        primaryStage.setTitle("Greeting");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
