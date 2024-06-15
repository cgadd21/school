package com.example.m5sample6;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main6 extends Application {

    @Override
    public void start(Stage primaryStage) {
        //Create Button and Label and style button and label
        Button button = new Button("See secret message.");

        Label line1 = new Label("");
        Label line2 = new Label("");
        Label line3 = new Label("");
        Label line4 = new Label("");
        button.setFont(Font.font("Verdana", 28));
        line1.setFont(Font.font("Verdana", 28));
        line2.setFont(Font.font("Verdana", 28));
        line3.setFont(Font.font("Verdana", 28));
        line4.setFont(Font.font("Verdana", 28));
        line1.setPrefWidth(400);
        line2.setPrefWidth(400);
        line3.setPrefWidth(400);
        line4.setPrefWidth(400);
        line1.setAlignment(Pos.CENTER);
        line2.setAlignment(Pos.CENTER);
        line3.setAlignment(Pos.CENTER);
        line4.setAlignment(Pos.CENTER);

        //Create Button and Label and style
        Button biggerButton = new Button("Bigger");
        Button smallerButton = new Button("Smaller");
        Label sampleLabel = new Label("How now brown cow.");

        biggerButton.setFont(Font.font("Verdana", 28));
        smallerButton.setFont(Font.font("Verdana", 28));
        sampleLabel.setFont(Font.font("Verdana", 28));


        //Create layout and style
        VBox root = new VBox(button, line1, line2, line3, line4, sampleLabel, biggerButton, smallerButton);
        root.setSpacing(10);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.CENTER);

        //ActionEvent EventHandler that will set text and styling
        EventHandler<ActionEvent> myEvent = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                line1.setText("You");
                line2.setText("deserve");
                line3.setText("some");
                line4.setText("cake.");
                root.setBackground(new Background(new BackgroundFill(Color.AZURE, CornerRadii.EMPTY, Insets.EMPTY)));
                button.setFont(new Font("Comic Sans MS", 24));
                button.setTextFill(Color.DARKMAGENTA);
                line1.setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(3))));
                line2.setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(3))));
                line3.setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(3))));
                line4.setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(3))));

            }
        };

        //ActionEvent EventHandler that will increase size of font
        EventHandler<ActionEvent> biggerText = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Font currentFont = sampleLabel.getFont();   //get the current Font object and store in variable
                double currentFontSize = currentFont.getSize();  //Use getSize() method to extract the font size from the Font object
                currentFontSize++;                              //increase the value by 1
                sampleLabel.setFont(new Font("Verdana", currentFontSize));   //set font using original font and new small font size
            }
        };

        //ActionEvent EventHandler that will decrease size of font
        EventHandler<ActionEvent> smallerText = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Font currentFont = sampleLabel.getFont();  //get the current Font object and store in variable
                double currentFontSize = currentFont.getSize();    //Use getSize() method to extract the font size from the Font object
                //example of how to prevent font from getting too small
                if(currentFontSize > 6) {
                    currentFontSize--;                                  //decrease the value by 1
                    sampleLabel.setFont(new Font("Verdana", currentFontSize));      //set font using original font and new small font size
                }
            }
        };

        biggerButton.setOnAction(biggerText);
        smallerButton.setOnAction(smallerText);

        //Applying the EventHandler to the button
        button.setOnAction(myEvent);

        Scene scene = new Scene(root, 600, 600);

        primaryStage.setTitle("Greeting");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
