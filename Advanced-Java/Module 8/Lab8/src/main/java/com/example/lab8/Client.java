package com.example.lab8;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client extends Application {

    DataOutputStream toServer = null;
    DataInputStream fromServer = null;

    @Override
    public void start(Stage primaryStage) throws Exception{

        BorderPane pane = new BorderPane();
        pane.setPadding(new Insets(5));
        pane.setStyle("-fx-border-color: green");
        Label instructions = new Label("Enter 1-10 for fortune.");
        instructions.setFont(Font.font("Arial", 30));
        pane.setLeft(instructions);

        TextField tf = new TextField();
        tf.setAlignment(Pos.BOTTOM_RIGHT);
        tf.setFont(Font.font("Arial", 30));
        pane.setCenter(tf);

        BorderPane mainPane = new BorderPane();
        TextArea ta = new TextArea();
        ta.setFont(Font.font("Arial", 30));
        mainPane.setCenter(ta);
        mainPane.setTop(pane);

        Scene scene = new Scene(mainPane, 450, 200);
        primaryStage.setTitle("Client");
        primaryStage.setScene(scene);
        primaryStage.show();


        try{
            Socket socket = new Socket("localhost", 5000);
            fromServer = new DataInputStream(socket.getInputStream());
            toServer = new DataOutputStream(socket.getOutputStream());
        } catch (IOException ex){
            ta.appendText(ex.toString() + '\n');
        }

        tf.setOnAction(e-> {
            try {
                int user = Integer.parseInt(tf.getText().trim());
                if (user > 10 || user < 1) {
                    ta.appendText("Please enter a valid number.\n");
                } else {
                    toServer.writeInt(user);
                    toServer.flush();
                    String fortune = fromServer.readUTF();
                    ta.appendText("Your choice is: " + user + ".\n");
                    ta.appendText("Fortune received from the server: " + fortune + '\n');
                }
            } catch (IOException ex) {
        }
        });

    }

    public static void main(String[] args) {
        launch(args);
    }
}
