package com.example.lab6;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.io.File;
import java.util.*;

public class HelloApplication extends Application {
    //HashMap to store states/capitals as keys/values
    HashMap<String, String> statesMap = new HashMap<>();

    //init() method uses Scanner to read from txt file and fills
    //hashmap with state/capital pairs at program start-up
    //txt file is located in resources - statecapitals.txt
    @Override
    public void init() throws Exception {
        File text = new File("src/main/resources/statecapitals.txt");
        System.out.println("File Found.");
        Scanner read = new Scanner(text);
        for(int i = 0; i < 50; i++){
            String state = read.nextLine();     //reads in state from lines 1, 3, 5, etc.
            String capital = read.nextLine();   //reads in capitals from lines 2, 4, 6, etc.
            statesMap.put(state, capital);      //puts key/value pairs in hashmap
        }
        System.out.println(statesMap);          //double-checks contents by printing to console
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Visual Components
        Label letterLabel = new Label("Enter letter");
        letterLabel.setFont(new Font("Verdana", 18));
        //letterLabel.setPrefWidth(150);
        TextField letterField = new TextField();
        letterField.setFont(new Font("Verdana", 18));
        letterField.setPrefWidth(100);
        Button stateButton = new Button("Get pairs");
        stateButton.setFont(new Font("Verdana", 18));
        //stateButton.setPrefWidth(Double.MAX_VALUE);
        Button alphaByStateButton = new Button("Show All States A-Z");
        alphaByStateButton.setFont(new Font("Verdana", 18));
        alphaByStateButton.setPrefWidth(Double.MAX_VALUE);
        Button alphaByCapitalButton = new Button("Show All Capitals A-Z");
        alphaByCapitalButton.setFont(new Font("Verdana", 18));
        alphaByCapitalButton.setPrefWidth(Double.MAX_VALUE);
        TextArea resultsArea = new TextArea();
        resultsArea.setFont(new Font("Verdana", 18));
        ScrollPane scroll = new ScrollPane(resultsArea);
        scroll.setPrefWidth(Double.MAX_VALUE);

        //Layouts
        HBox topRow = new HBox(letterLabel, letterField, stateButton);
        topRow.setPrefWidth(Double.MAX_VALUE);
        VBox root = new VBox(topRow, scroll, alphaByStateButton, alphaByCapitalButton);
        topRow.setSpacing(20);
        root.setPadding(new Insets(20));
        root.setSpacing(20);

        //TODO - Lab Task - Add code in three EventHandlers below as requested in lab document
        stateButton.setOnAction(e->{
            resultsArea.setText("");
            boolean charInState = false;
            String stateLetter=letterField.getText().toUpperCase();
            for(Map.Entry<String, String> pairs : statesMap.entrySet()){
                String key = pairs.getKey();
                String value = pairs.getValue();
                if(key.charAt(0)==stateLetter.charAt(0)) {
                    //System.out.println(key + " -> " + value);
                    resultsArea.appendText(key + " -> " + value + "\n");
                    charInState=true;
                }
            }
            if(!charInState){
                //System.out.println("No states start with that letter.");
                resultsArea.setText("No states start with that letter.");
            }
        });

        alphaByStateButton.setOnAction(e->{
            resultsArea.setText("");
            TreeMap<String, String> statesOrganization = new TreeMap<>(statesMap);
            for(Map.Entry<String, String> pairs : statesOrganization.entrySet()) {
                String key = pairs.getKey();
                String value = pairs.getValue();
                resultsArea.appendText(key + " -> " + value + "\n");
            }
        });
        alphaByCapitalButton.setOnAction(e->{
            resultsArea.setText("");
            Collection<String> capitalOrganization = statesMap.values();
            ArrayList<String> capitalList = new ArrayList<>(capitalOrganization);
            Collections.sort(capitalList);
            for (String s : capitalList) {
                for (Map.Entry<String, String> pairs : statesMap.entrySet()) {
                    String key = pairs.getKey();
                    String value = pairs.getValue();
                    if (s.equals(value)) {
                        resultsArea.appendText(value + " -> " + key + "\n");
                    }
                }
            }
        });



        //Scene/stage
        Scene scene = new Scene(root, 400, 400);
        primaryStage.setTitle("States and Capitals");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}