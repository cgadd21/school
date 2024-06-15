package com.example.m53example6;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;
//A program demonstrating the use of Alerts
public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Label nameLabel = new Label("Enter name:");
        nameLabel.setFont(new Font(19));
        TextField nameTextField = new TextField();
        nameTextField.setFont(new Font(19));
        Button submitButton = new Button("Submit");
        submitButton.setFont(new Font(19));
        Label greetingLabel = new Label(" ");
        greetingLabel.setFont(new Font(25));
        HBox firstRow = new HBox(nameLabel, nameTextField, submitButton);
        firstRow.setSpacing(20);
        firstRow.setPadding(new Insets(20));
        VBox root = new VBox(firstRow, greetingLabel);
        root.setSpacing(20);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.CENTER);

        submitButton.setOnAction(e->{
            greetingLabel.setText("");                                      //reset this to blank
            if(nameTextField.getText().isEmpty()){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Alert!");
                alert.setHeaderText("This is an alert.");
                alert.setContentText("Name field cannot be blank!");
                alert.show();
            } else if (nameTextField.getText().length() == 1) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Hey!");
                alert.setHeaderText(null);  //this will remove the header text portion
                alert.setContentText("Names cannot be a single character!");
                alert.show();
            } else if(nameTextField.getText().equals("Bobo")) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Set Bobo?");
                alert.setHeaderText("Are you sure your name is Bobo?");
                alert.setContentText("Are you really sure?");

                Optional<ButtonType> option = alert.showAndWait(); //necessary for confirmation types
                if (option.get()==ButtonType.OK) {                  //sets action to each of the buttons
                    greetingLabel.setText("Hello, Bobo");
                } else {
                    greetingLabel.setText("");
                }
            } else {
                greetingLabel.setText("Hello, " + nameTextField.getText());
            }
        });

        Scene scene = new Scene(root);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}