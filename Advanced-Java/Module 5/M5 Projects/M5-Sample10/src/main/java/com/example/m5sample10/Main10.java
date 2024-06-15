package com.example.m5sample10;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.time.LocalDate;


public class Main10 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        DatePicker date = new DatePicker();
        Label echo = new Label();
        ColorPicker color = new ColorPicker();
        Label echo2 = new Label();
        Label echo3 = new Label();

        VBox root = new VBox(date, echo, color, echo2, echo3);
        root.setSpacing(20);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.CENTER);

        //ActionEvent EventHandler that uses the DatePicker's getValue() to get
        //a LocalDate object which stores the user's selection.
        EventHandler<ActionEvent> echoDate = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                LocalDate selectedDate = date.getValue();
                echo.setText(String.valueOf(selectedDate));
            }
        };
        date.setOnAction(echoDate);
        //ActionEvent that uses the ColorPicker's getValue() to get
        //a Color object.  By default the value is a hex value.
        //Additional Color class methods can be used to pull out RGB (and other things)
        EventHandler<ActionEvent> echoColor = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Color selection = color.getValue();
                echo2.setText(String.valueOf(selection));

                double red = selection.getRed() * 255;
                double green = selection.getGreen() * 255;
                double blue = selection.getBlue() * 255;
                echo3.setText("R: " + (int)red + " G: " + (int)green + " B: " + (int)blue);
            }
        };

        color.setOnAction(echoColor);

        Scene scene = new Scene(root, 1000, 500);
        primaryStage.setTitle("Pickers");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
