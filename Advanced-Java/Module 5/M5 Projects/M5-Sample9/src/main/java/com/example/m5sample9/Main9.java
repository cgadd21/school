package com.example.m5sample9;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class Main9 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        //Create Button, Labels, and TextFields
        CheckBox lettuceChoice = new CheckBox("Lettuce");
        CheckBox tomatoChoice = new CheckBox("Tomatoes");
        CheckBox pickleChoice = new CheckBox("Pickles");
        CheckBox peppersChoice = new CheckBox("Peppers");
        CheckBox onionsChoice = new CheckBox("Onions");
        Button submitButton = new Button("Submit");
        Label feedbackLabel = new Label("");
        Label titleLabel = new Label("Choose Toppings");
        Label orderLabel = new Label("Your Order");


        lettuceChoice.setFont(Font.font("Verdana", 28));
        tomatoChoice.setFont(Font.font("Verdana", 28));
        pickleChoice.setFont(Font.font("Verdana", 28));
        peppersChoice.setFont(Font.font("Verdana", 28));
        onionsChoice.setFont(Font.font("Verdana", 28));
        submitButton.setFont(Font.font("Verdana", 28));
        feedbackLabel.setFont(Font.font("Verdana", 28));
        titleLabel.setFont(Font.font("Verdana", 40));
        orderLabel.setFont(Font.font("Verdana", 40));

        HBox toppings = new HBox(lettuceChoice, tomatoChoice, pickleChoice, peppersChoice, onionsChoice);
        toppings.setSpacing(20);

        VBox root = new VBox(titleLabel, toppings, submitButton, orderLabel, feedbackLabel);

        //Create layout and style
        root.setSpacing(20);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.CENTER);

        //ActionEvent EventHandler that checks each check box to see if the user
        //wants that topic.  Each check box should be checked since multiple can be selected.
        EventHandler<ActionEvent> showToppings = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String response = "Your toppings:\n";
                if(lettuceChoice.isSelected()){
                    response = response + "Lettuce\n";
                }
                if(tomatoChoice.isSelected()){
                    response = response + "Tomatoes\n";
                }
                if(pickleChoice.isSelected()){
                    response = response + "Pickles\n";
                }
                if(peppersChoice.isSelected()){
                    response = response + "Peppers\n";
                }
                if(onionsChoice.isSelected()){
                    response = response + "Onions";
                }
                feedbackLabel.setText(response);
            }
        };
        submitButton.setOnAction(showToppings);

        Scene scene = new Scene(root, 1000, 500);
        primaryStage.setTitle("Toppings");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
