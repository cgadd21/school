package com.example.m83new;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class MultiThreadServer extends Application {
    private TextArea textArea = new TextArea();
    private int clientNo = 0;

    @Override
    public void start(Stage stage) throws IOException {
        textArea.setFont(new Font(20));
        Scene scene = new Scene(textArea, 600, 200);
        stage.setTitle("MultiThreadServer");
        stage.setScene(scene);
        stage.show();

        new Thread( () ->{
            try{
                ServerSocket serverSocket = new ServerSocket(8001);
                Platform.runLater(() -> textArea.appendText("MultiThreadServer started at " + new Date() + "\n"));

                while(true){
                    Socket socket = serverSocket.accept();
                    clientNo++;
                    Platform.runLater(() -> {
                        textArea.appendText("Starting thread for client " + clientNo + " at " + new Date() + "\n");
                        //Get the clients host name and IP address
                        InetAddress inetAddress = socket.getInetAddress();
                        textArea.appendText("Client " + clientNo + "'s host name is " + inetAddress.getHostAddress()+"\n");
                        textArea.appendText("Client " + clientNo + "'s IP Address is " + inetAddress.getHostAddress() + "\n");
                    });
                    new Thread(()->{
                        try{
                            DataInputStream inputFromClient = new DataInputStream(socket.getInputStream());
                            DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());
                            while(true){
                                double radius = inputFromClient.readDouble();
                                double area = radius * radius * Math.PI;
                                outputToClient.writeDouble(area);
                                Platform.runLater(() -> {
                                    textArea.appendText("Radius received from client " + radius + "\n");
                                    textArea.appendText("Area found: " + area + "\n");
                                });
                            }
                        } catch (IOException ex){
                            ex.printStackTrace();
                        }
                    }).start();

                }
            }
            catch (IOException ex){
                System.err.println(ex);
            }
        }).start();
    }

    public static void main(String[] args) {
        launch();
    }
}