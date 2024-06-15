package com.example.m52example2;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.util.Random;

//Demonstrating handlers/filters and event capturing/bubbling

public class Main2 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Button topButton = new Button("Top");
        Button middleButton = new Button("Middle");
        Button bottomButton = new Button("Bottom");
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

        EventHandler<MouseEvent> colorChange = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Random ran = new Random();
                Object temp = mouseEvent.getSource();
                if (temp instanceof Button) {
                    Button tempButton = (Button) temp;
                    tempButton.setBackground(new Background(new BackgroundFill(Color.rgb(ran.nextInt(256), ran.nextInt(256), ran.nextInt(256)), CornerRadii.EMPTY, Insets.EMPTY)));
                } else if (temp instanceof HBox) {
                    HBox tempHbox = (HBox) temp;
                    tempHbox.setBackground(new Background(new BackgroundFill(Color.rgb(ran.nextInt(256), ran.nextInt(256), ran.nextInt(256)), CornerRadii.EMPTY, Insets.EMPTY)));
                }
                //mouseEvent.consume();
            }
        };

        bottomButton.setOnMouseClicked(colorChange);
        topButton.setOnMouseClicked(colorChange);
        middleButton.setOnMouseClicked(colorChange);

        //With event handlers set to the HBoxes, they will not process
        //the colorChange event if a Button is selected. Event handlers
        //get processed as the event is travelling back up to the stage.
        //Button nodes consume events, so the HBoxes never get the
        //opportunity to process the event.
        /*top.setOnMouseClicked(colorChange);
        middle.setOnMouseClicked(colorChange);
        bottom.setOnMouseClicked(colorChange);*/

        //Add the event handling as a filter will allow the HBoxes
        //to process the event BEFORE it gets consumed by the Button.
        top.addEventFilter(MouseEvent.MOUSE_CLICKED, colorChange);
        middle.addEventFilter(MouseEvent.MOUSE_CLICKED, colorChange);
        bottom.addEventFilter(MouseEvent.MOUSE_CLICKED, colorChange);

        Scene scene = new Scene(root, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Adding Event Filter");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

