//Cooper Gadd
//Project 2

package com.example.project2gadd;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

public class HelloApplication extends Application {

    //Variables

    String roundsInput;
    int rounds;
    String name;
    int wins=0;
    int losses=0;
    int ties=0;
    int roundsPlayed=0;
    Random random = new Random();
    @Override
    public void start(Stage stage) throws IOException {

        //Scenes

        //Scene 1

        HBox topPane1 = new HBox();
        HBox bottomPane1 = new HBox();
        VBox leftPane1 = new VBox();
        VBox rightPane1 = new VBox();
        VBox centerPane1 = new VBox();
        BorderPane scene1Root = new BorderPane(centerPane1, topPane1, rightPane1, bottomPane1, leftPane1);

        Label titleLabel = createTitle("Rock, Paper, Scissors");
        TextField nameTextField = createTextField("Enter your name.");
        TextField roundsTextField = createTextField("How many rounds?");
        Button beginButton = createButton("Click to Begin");
        Label invalidName = createOutput("");
        Label invalidRound = createOutput("");

        topPane1.setPadding(new Insets(30));
        topPane1.setSpacing(30);
        topPane1.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, new CornerRadii(5),new Insets(5))));
        topPane1.getChildren().add(titleLabel);
        topPane1.setAlignment(Pos.CENTER);

        centerPane1.setPadding(new Insets(30));
        centerPane1.setSpacing(30);
        centerPane1.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, new CornerRadii(5),new Insets(5))));
        centerPane1.getChildren().addAll(nameTextField, roundsTextField, invalidName, invalidRound);
        centerPane1.setAlignment(Pos.CENTER);

        bottomPane1.setPadding(new Insets(30));
        bottomPane1.setSpacing(30);
        bottomPane1.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, new CornerRadii(5),new Insets(5))));
        bottomPane1.getChildren().add(beginButton);
        bottomPane1.setAlignment(Pos.CENTER);

        //Scene 2

        HBox topPane2 = new HBox();
        HBox bottomPane2 = new HBox();
        VBox leftPane2 = new VBox();
        VBox rightPane2 = new VBox();
        VBox centerPane2 = new VBox();
        BorderPane scene2Root = new BorderPane(centerPane2, topPane2, rightPane2, bottomPane2, leftPane2);

        Label labelInform = createOutput("");
        Label labelRound = createOutput("Round: " + roundsPlayed);
        Label labelWins = createOutput("Wins: " + wins);
        Label labelLosses = createOutput("Losses: " + losses);
        Label labelTies = createOutput("Ties: " + ties);

        Button buttonReset = createButton("Reset Game");
        Button buttonMenu = createButton("Main Menu");
        Button buttonChart = createButton("See Chart");

        Image rockImage = new Image("file:src/main/resources/Project 2 Images/Rock.jpg", 125, 0, true, true);
        ImageView viewRock = new ImageView(rockImage);
        Image paperImage = new Image("file:src/main/resources/Project 2 Images/Paper.jpg", 125, 0, true, true);
        ImageView viewPaper = new ImageView(paperImage);
        Image scissorsImage = new Image("file:src/main/resources/Project 2 Images/Scissors.jpg",  125, 0, true, true);
        ImageView viewScissors = new ImageView(scissorsImage);

        topPane2.setPadding(new Insets(30));
        topPane2.setSpacing(30);
        topPane2.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, new CornerRadii(5),new Insets(5))));
        topPane2.getChildren().addAll(viewRock,viewPaper,viewScissors);
        topPane2.setAlignment(Pos.CENTER);

        centerPane2.setPadding(new Insets(10));
        centerPane2.setSpacing(15);
        centerPane2.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, new CornerRadii(5),new Insets(5))));
        centerPane2.getChildren().addAll(labelInform,labelRound,labelWins,labelLosses,labelTies);
        centerPane2.setAlignment(Pos.CENTER);

        bottomPane2.setPadding(new Insets(30));
        bottomPane2.setSpacing(30);
        bottomPane2.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, new CornerRadii(5),new Insets(5))));
        bottomPane2.getChildren().addAll(buttonReset,buttonMenu,buttonChart);
        bottomPane2.setAlignment(Pos.CENTER);

        Scene scene1 = new Scene(scene1Root, 650, 650);
        Scene scene2 = new Scene(scene2Root,650,650);

        //Event Handlers

        //Scene 1 Change Button

        beginButton.setOnAction(e->{
            boolean validNumber = false;
            boolean validRound = false;
            try {
                invalidName.setText("");
                invalidRound.setText("");
                name = nameTextField.getText();
                roundsInput = roundsTextField.getText();
                if (nameTextField.getText().equals("Enter your name.")) {
                    invalidName.setText("Enter your name first!");
                } else if (nameTextField.getText().length() == 0) {
                    invalidName.setText("Name cannot be blank.");
                } else {
                    invalidName.setText("");
                    validNumber=true;
                }
                if (roundsTextField.getText().length() == 0) {
                    invalidRound.setText("Enter the number of rounds first!");
                } else if (roundsTextField.getText().equals("How many rounds?")) {
                    invalidRound.setText("Enter the number of rounds first!");
                } else {
                    rounds = Integer.parseInt(roundsInput);
                    if (rounds < 0.1) {
                        invalidRound.setText("Number of rounds must be a positive integer.");
                    } else {
                        invalidRound.setText("");
                        validRound=true;
                    }
                }
            } catch (NumberFormatException ex){
                invalidName.setText("Please enter a valid name.");
                invalidRound.setText("Please enter a valid round number.");
            }
            if(validNumber && validRound) {
                stage.setScene(scene2);
                labelInform.setText(name + ", welcome to the game.\n" + "You've selected " + rounds + " rounds.");
            }

        });

        //Scene 2 Change Button

        buttonMenu.setOnAction(e->{
            stage.setScene(scene1);
        });

        //Scene 2 Reset Button

        buttonReset.setOnAction(e->{
            roundsInput = roundsTextField.getText();
            rounds = Integer.parseInt(roundsInput);
            roundsPlayed=0;
            wins=0;
            ties=0;
            losses=0;
            labelInform.setText(name + ", welcome to the game.\n" + "You've selected " + rounds + " rounds.");
            labelRound.setText("Round: " + roundsPlayed);
            labelWins.setText("Wins: " + wins);
            labelTies.setText("Ties: " + ties);
            labelLosses.setText("Losses: " + losses);
        });

        //Scene 3 Change Button

        //Scene 3

        buttonChart.setOnAction(e->{
            if(roundsPlayed==0){
                labelInform.setText("Play a round to access the chart.");
            } else {
                PieChart results = new PieChart();
                PieChart.Data slice1 = new PieChart.Data("Wins", wins);
                PieChart.Data slice2 = new PieChart.Data("Losses", losses);
                PieChart.Data slice3 = new PieChart.Data("Ties", ties);
                results.getData().addAll(slice1, slice2, slice3);
                StackPane pane = new StackPane(results);
                results.setStyle("-fx-font-size:20");
                Scene scene3 = new Scene(pane, 650, 650);

                Stage stageChart = new Stage();
                stageChart.setScene(scene3);
                stageChart.setTitle("Rock, Paper, Scissors");
                stageChart.show();
            }
        });

        //Rock Button

        viewRock.setOnMouseClicked(e->{
            int computerChoice = random.nextInt(3)+1;
            rounds--;
            if(rounds<0){
                labelInform.setText("Game Over!");
            } else {
                roundsPlayed++;
                labelRound.setText("Round: " + roundsPlayed);
                if(computerChoice==1){
                    labelInform.setText("You chose Rock. Computer chose Rock.\nTie!");
                    ties++;
                    labelTies.setText("Ties: " + ties);
                } else if (computerChoice==2) {
                    labelInform.setText("You chose Rock. Computer chose Paper.\nYou lose!");
                    losses++;
                    labelLosses.setText("Losses: " + losses);
                } else {
                    labelInform.setText("You chose Rock. Computer chose Scissors.\nYou Win!");
                    wins++;
                    labelWins.setText("Wins: " + wins);
                }
            }
        });

        //Paper Button

        viewPaper.setOnMouseClicked(e->{
            int computerChoice = random.nextInt(3)+1;
            rounds--;
            if(rounds<0){
                labelInform.setText("Game Over!");
            } else {
                roundsPlayed++;
                labelRound.setText("Round: " + roundsPlayed);
                if(computerChoice==1){
                    labelInform.setText("You chose Paper. Computer chose Rock.\nYou Win!");
                    wins++;
                    labelWins.setText("Wins: " + wins);
                } else if (computerChoice==2) {
                    labelInform.setText("You chose Paper. Computer chose Paper.\nTie!");
                    ties++;
                    labelTies.setText("Ties: " + ties);
                } else {
                    labelInform.setText("You chose Paper. Computer chose Scissors.\nYou Lose!");
                    losses++;
                    labelLosses.setText("Losses: " + losses);
                }
            }
        });

        //Scissor Button

        viewScissors.setOnMouseClicked(e->{
            int computerChoice = random.nextInt(3)+1;
            rounds--;
            if(rounds<0){
                labelInform.setText("Game Over!");
            } else {
                roundsPlayed++;
                labelRound.setText("Round: " + roundsPlayed);
                if(computerChoice==1){
                    labelInform.setText("You chose Scissors. Computer chose Rock.\nYou Lose!");
                    losses++;
                    labelLosses.setText("Losses: " + losses);
                } else if (computerChoice==2) {
                    labelInform.setText("You chose Scissors. Computer chose Paper.\nYou Win!");
                    wins++;
                    labelWins.setText("Wins: " + wins);
                } else {
                    labelInform.setText("You chose Scissors. Computer chose Scissors.\nTie!");
                    ties++;
                    labelTies.setText("Ties: " + ties);
                }
            }
        });

        //Stage

        stage.setScene(scene1);
        stage.setTitle("Rock, Paper, Scissors");
        stage.show();
    }

    //Methods

    public static Label createTitle(String text){
        Label label = new Label(text);
        label.setPrefWidth(600);
        label.setFont(Font.font("Times New Roman", FontWeight.BOLD, 30));
        label.setTextFill(Color.CORAL);
        label.setWrapText(true);
        label.setAlignment(Pos.TOP_CENTER);
        return label;
    }

    public static TextField createTextField(String text){
        TextField textField = new TextField(text);
        textField.setPromptText(text);
        textField.setPrefWidth(150);
        textField.setFont(Font.font("Times New Roman",24));
        textField.setAlignment(Pos.CENTER);
        return textField;
    }

    public static Label createOutput(String text){
        Label output = new Label(text);
        output.setPadding(new Insets(50));
        output.setPrefWidth(300);
        output.setPrefHeight(50);
        output.setTextFill(Color.CORAL);
        output.setBorder(new Border(new BorderStroke(Color.CORAL, BorderStrokeStyle.SOLID, CornerRadii.EMPTY,  new BorderWidths(3))));
        output.setPadding(new Insets(5));
        output.setAlignment(Pos.CENTER);
        return output;
    }

    public static Button createButton(String text){
        Button button = new Button(text);
        button.setPrefWidth(500);
        button.setPrefHeight(50);
        button.setPadding(new Insets(22));
        button.setFont(Font.font("Times New Roman", FontWeight.BOLD, 18));
        button.setTextFill(Color.CORAL);
        button.setBackground(new Background(new BackgroundFill(Color.MINTCREAM, new CornerRadii(10), new Insets(10))));
        button.setBorder(new Border(new BorderStroke(Color.MINTCREAM, BorderStrokeStyle.DASHED, new CornerRadii(5), new BorderWidths(3), new Insets(5))));
        button.setAlignment(Pos.CENTER);
        return button;
    }

    public static void main(String[] args) {
        launch();
    }
}