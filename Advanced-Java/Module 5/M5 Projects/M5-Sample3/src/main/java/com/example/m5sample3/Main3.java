package com.example.m5sample3;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class Main3 extends Application {

    Label greetingLabel = new Label("Nothing to see here...");

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Create and style Button, Label and BorderPane
        Button greetingButton = new Button("Press for a greeting");
        greetingButton.setFont(Font.font("Verdana", 28));
        greetingLabel.setFont(Font.font("Verdana", 28));
        BorderPane root = new BorderPane();
        root.setTop(greetingButton);
        root.setCenter(greetingLabel);
        BorderPane.setAlignment(greetingButton, Pos.CENTER);
        root.setPadding(new Insets(20));

        ShowGreeting myEvent = new ShowGreeting();
        greetingButton.setOnAction(myEvent);

        Scene scene = new Scene(root, 600, 600);
        primaryStage.setTitle("Greeting");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    //inner class - it can now access anything declared within Main3
    class ShowGreeting implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            greetingLabel.setText("Hello World");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}


