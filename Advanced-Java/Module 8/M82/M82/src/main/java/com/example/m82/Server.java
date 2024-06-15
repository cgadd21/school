package com.example.m82;

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
import java.util.Date;

public class Server extends Application {

    DataInputStream fromClient = null;
    DataOutputStream toClient = null;

    @Override
    public void start(Stage primaryStage) throws IOException {
        TextArea ta = new TextArea();
        ta.setFont(Font.font("Arial", 30));
        Scene scene = new Scene(ta, 450, 200);
        primaryStage.setTitle("Server");
        primaryStage.setScene(scene);
        primaryStage.show();


        new Thread(()->{
            Platform.runLater(()-> ta.appendText("Start: " + new Date() + "\n"));
            try{
                ServerSocket server = new ServerSocket(8000);
                Socket socket = server.accept();
                fromClient = new DataInputStream(socket.getInputStream());
                toClient = new DataOutputStream(socket.getOutputStream());
                while(true){
                    double radius = fromClient.readDouble();
                    double area = radius * radius * Math.PI;
                    Platform.runLater(()-> ta.appendText("Client's Radius: "+radius+", Area: "+area +"\n"));
                    toClient.writeDouble(area);
                }
            } catch (IOException ex){
            }
        }).start();
    }
    public static void main(String[] args) {
        launch(args);
    }


}
