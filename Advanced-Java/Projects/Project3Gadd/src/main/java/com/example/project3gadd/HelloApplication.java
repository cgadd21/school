package com.example.project3gadd;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class HelloApplication extends Application {

    HashMap<String, String> triviaMap = new HashMap<>();
    List<String> list;
    int index=0;
    int wins=0;
    int total=0;

    @Override
    public void init() throws Exception {
        File text = new File("src/main/resources/com/example/project3gadd/trivia.txt");
        System.out.println("File Found.");
        Scanner read = new Scanner(text);

        for(int i = 0; i < 15; i++){
            String question = read.nextLine();
            String answer = read.nextLine();
            triviaMap.put(question, answer);
        }
        list = new ArrayList<>(triviaMap.keySet());
        Collections.shuffle(list);
    }

    @Override
    public void start(Stage stage) throws IOException {

        Label questionLabel = new Label("Click Next To Get Started!");
        questionLabel.setWrapText(true);
        questionLabel.setFont(new Font("Verdana", 18));
        Label answerLabel = new Label();
        answerLabel.setWrapText(true);
        answerLabel.setFont(new Font("Verdana", 18));
        Label feedbackLabel = new Label();
        feedbackLabel.setFont(new Font("Verdana", 16));
        TextField userText = new TextField();
        userText.setFont(new Font("Verdana", 16));
        Button checkButton = new Button("Check");
        checkButton.setFont(new Font("Verdana", 14));
        checkButton.setPrefWidth(Double.MAX_VALUE);
        Button nextButton = new Button("Next");
        nextButton.setFont(new Font("Verdana", 14));
        nextButton.setPrefWidth(Double.MAX_VALUE);
        Label correctLabel = new Label("Correct: 0");
        correctLabel.setFont(new Font("Verdana", 14));
        Label totalLabel = new Label("Total: 0");
        totalLabel.setFont(new Font("Verdana", 14));

        HBox count = new HBox(correctLabel,totalLabel);
        count.setSpacing(20);
        VBox root = new VBox(questionLabel,answerLabel,feedbackLabel,userText,checkButton,nextButton,count);
        root.setPadding(new Insets(20));
        root.setSpacing(20);

        Scene scene = new Scene(root, 800, 400);
        stage.setTitle("Trivia Night!");
        stage.setScene(scene);
        stage.show();

        nextButton.setOnAction(e->{
            feedbackLabel.setText("");
            answerLabel.setText("");
            userText.setText("");
            if (index < 15){
                String listKey = list.get(index);
                questionLabel.setText(listKey);
                index++;
            } else {
                questionLabel.setText("");
                answerLabel.setText("");
                double score = (double) wins/total*100;
                feedbackLabel.setText("Game Over! Score: " + String.format("%,.2f",score) + "%");
            }
            if(total<15) {
                total++;
                totalLabel.setText("Total: " + total);
            } else {
                totalLabel.setText("Total: " + total);
            }

        });

        checkButton.setOnAction(e->{
            String userAnswer = userText.getText();
            if (userAnswer.equals("")){
                feedbackLabel.setText("Enter your answer!");
            }
            else if (userAnswer.equalsIgnoreCase(triviaMap.get(questionLabel.getText()))) {
                answerLabel.setText(triviaMap.get(questionLabel.getText()));
                feedbackLabel.setText("Correct!");
                wins++;
                correctLabel.setText("Correct: " + wins);
            } else {
                answerLabel.setText(triviaMap.get(questionLabel.getText()));
                feedbackLabel.setText("Incorrect!");
                    }
        });

        }

    public static void main(String[] args) {
        launch();
    }
}