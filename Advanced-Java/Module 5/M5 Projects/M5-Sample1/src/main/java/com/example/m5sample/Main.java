package com.example.m5sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
//This project intentionally does not work correctly. It demonstrates the use
//of a separate class for defining an event handler but the controls within
//do not correspond to the controls in Main. Each project example will get us
//closer and closer to a working, concise example.

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        //Create Button and Label and style button and label
        Button greetingButton = new Button("Press for a greeting");
        Label greetingLabel = new Label("Nothing to see here...");
        greetingButton.setFont(Font.font("Verdana", 28));
        greetingLabel.setFont(Font.font("Verdana", 28));

        //Create layout and style
        BorderPane root = new BorderPane();
        root.setTop(greetingButton);
        root.setCenter(greetingLabel);
        BorderPane.setAlignment(greetingButton, Pos.CENTER);
        root.setPadding(new Insets(20));

        //I can create a new object from my class that implements
        //EventHandler and then set that object to execute
        //when greetingButton is acted upon, however, nothing
        //is connecting my Label in Main to my Label in ShowGreeting.
        //So this doesn't work.
        ShowGreeting myEvent = new ShowGreeting();
        greetingButton.setOnAction(myEvent);

        //The code below utilizes the commented out class in ShowGreeting
        //It allows the label to be passed in so that it gets updated.
        //To see how this works, comment out the two lines above and then
        //uncomment the two lines below.  In ShowGreeting, comment out the
        //class that is shown and uncomment the class at the bottom.

    /*ShowGreeting myEvent = new ShowGreeting(greetingLabel);
    greetingButton.setOnAction(myEvent);*/

        Scene scene = new Scene(root, 600, 600);
        stage.setTitle("Greeting");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}