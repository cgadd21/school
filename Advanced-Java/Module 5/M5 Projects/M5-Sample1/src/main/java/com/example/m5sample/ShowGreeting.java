package com.example.m5sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;

//This example doesn't end up working because this greetingLabel
//isn't the same label as the one in Main.  There is no connection.
//Setting the class up so that it has a constructor to allow the Label
//to be passed in is commented out below. The commented out portion works.
public class ShowGreeting implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent actionEvent) {
        Label greetingLabel = new Label();
        greetingLabel.setText("Hello World");
    }
}

/*public class ShowGreeting implements EventHandler<ActionEvent> {
    private Label greet;

    public ShowGreeting(Label greet) {
        this.greet = greet;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        greet.setText("Hello World");
    }
}*/
