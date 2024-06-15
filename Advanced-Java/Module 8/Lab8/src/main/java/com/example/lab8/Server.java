package com.example.lab8;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;

public class Server extends Application {

    DataInputStream fromClient = null;
    DataOutputStream toClient = null;
    ArrayList<String> response = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) throws IOException {
        TextArea ta = new TextArea();
        ta.setFont(Font.font("Arial", 30));
        Scene scene = new Scene(ta, 450, 200);
        primaryStage.setTitle("Server");
        primaryStage.setScene(scene);
        primaryStage.show();

        new Thread(()->{
            response.add("Run.");
            response.add("Never do anything halfway.");
            response.add("Your heart will skip a beat.");
            response.add("Don't be afraid to take that big step.");
            response.add("Ignore previous fortune.");
            response.add("Help! I'm in your computer!");
            response.add("You are not illiterate.");
            response.add("Behind you.");
            response.add("Life is full of choices.");
            response.add("Listen to the voices in your head.");
            Platform.runLater(()-> ta.appendText("Start: " + new Date() + "\n"));
            try{
                ServerSocket server = new ServerSocket(5000);
                Socket socket = server.accept();
                fromClient = new DataInputStream(socket.getInputStream());
                toClient = new DataOutputStream(socket.getOutputStream());
                while(true){
                    int user = fromClient.readInt();
                    Platform.runLater(()-> ta.appendText("Client's fortune: " + response.get(user-1)+"\n"));
                    toClient.writeUTF(response.get(user-1));
                }
            } catch (IOException ex){
            }
        }).start();
    }
    public static void main(String[] args) {
        launch(args);
    }


}
