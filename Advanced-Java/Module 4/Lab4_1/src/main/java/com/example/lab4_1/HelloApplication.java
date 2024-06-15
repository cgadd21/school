package com.example.lab4_1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        //Task 1

        Label formLabel = new Label("Form");
        Label nameLabel = new Label("First and Last Name");
        Label numberLabel = new Label("Phone Number");
        Label positionLabel = new Label("Position");
        Label daysLabel = new Label("Days Available");
        Label dateLabel = new Label("Start Date");

        TextField nameTextField = new TextField("");
        TextField numberTextField = new TextField("");

        RadioButton butcherPositionButton = new RadioButton("Butcher");
        RadioButton bakerPositionButton = new RadioButton("Baker");
        RadioButton cashierPositionButton = new RadioButton("Cashier");

        CheckBox mondayCheck = new CheckBox("M");
        CheckBox tuesdayCheck = new CheckBox("T");
        CheckBox wednesdayCheck = new CheckBox("W");
        CheckBox thursdayCheck = new CheckBox("Th");
        CheckBox fridayCheck = new CheckBox("F");
        CheckBox saturdayCheck = new CheckBox("S");
        CheckBox sundayCheck = new CheckBox("Su");

        DatePicker startDate = new DatePicker();

        Button submitButton = new Button("Submit");

        //Task 2

        HBox positionRadio = new HBox(butcherPositionButton,bakerPositionButton,cashierPositionButton);

        HBox daysCheck = new HBox(mondayCheck,tuesdayCheck,wednesdayCheck,thursdayCheck,fridayCheck,saturdayCheck,sundayCheck);

        VBox root = new VBox(formLabel,nameLabel,nameTextField,numberLabel,numberTextField,positionLabel,positionRadio,daysLabel,daysCheck,dateLabel,startDate,submitButton);

        //Task 3

        Scene scene = new Scene(root, 600, 600);
        stage.setScene(scene);
        stage.setTitle("Job Information");
        stage.show();

        //Task 4

        nameTextField.setFont(new Font("Times New Roman",14));
        nameTextField.setFont(new Font("Times New Roman",14));
        butcherPositionButton.setFont(new Font("Times New Roman",14));
        bakerPositionButton.setFont(new Font("Times New Roman",14));
        cashierPositionButton.setFont(new Font("Times New Roman",14));
        mondayCheck.setFont(new Font("Times New Roman",14));
        tuesdayCheck.setFont(new Font("Times New Roman",14));
        wednesdayCheck.setFont(new Font("Times New Roman",14));
        thursdayCheck.setFont(new Font("Times New Roman",14));
        fridayCheck.setFont(new Font("Times New Roman",14));
        saturdayCheck.setFont(new Font("Times New Roman",14));
        sundayCheck.setFont(new Font("Times New Roman",14));
        submitButton.setFont(new Font("Times New Roman",14));

        formLabel.setTextFill(Color.RED);
        nameLabel.setTextFill(Color.RED);
        numberLabel.setTextFill(Color.RED);
        positionLabel.setTextFill(Color.RED);
        daysLabel.setTextFill(Color.RED);
        dateLabel.setTextFill(Color.RED);

        //Task 5

        root.setPadding(new Insets(20));

        root.setSpacing(9);

        positionRadio.setSpacing(4);
        daysCheck.setSpacing(4);

        //Task 6

        formLabel.setPrefWidth(Double.MAX_VALUE);
        formLabel.setAlignment(Pos.CENTER);

        ToggleGroup radioButtons = new ToggleGroup();
        butcherPositionButton.setToggleGroup(radioButtons);
        bakerPositionButton.setToggleGroup(radioButtons);
        cashierPositionButton.setToggleGroup(radioButtons);

    }

    public static void main(String[] args) {
        launch();
    }
}