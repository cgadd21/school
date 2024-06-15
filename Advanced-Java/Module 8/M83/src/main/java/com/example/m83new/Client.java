package com.example.m83new;

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
//To run multiple instances of Client, you must go to Run --> Edit Configurations
//and then click the Modify Options link towards the right side of the window.
//Select the top option - "Allow Multiple Instances"

public class Client extends Application {
    //Declare IO stream in class so accessible everywhere
    DataOutputStream toServer = null;
    DataInputStream fromServer = null;

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Panel p to hold the label and text field
        BorderPane pane = new BorderPane();
        pane.setPadding(new Insets(5));
        pane.setStyle("-fx-border-color: green");
        Label instructions = new Label("Enter radius");
        instructions.setFont(Font.font("Arial", 24));
        pane.setLeft(instructions);

        TextField tf = new TextField();
        tf.setAlignment(Pos.BOTTOM_RIGHT);
        tf.setFont(Font.font("Arial", 24));
        pane.setCenter(tf);

        BorderPane mainPane = new BorderPane();
        TextArea ta = new TextArea();
        ta.setFont(Font.font("Arial", 20));
        mainPane.setCenter(ta);
        mainPane.setTop(pane);

        //Create scene
        Scene scene = new Scene(mainPane, 600, 200);
        primaryStage.setTitle("Client");
        primaryStage.setScene(scene);
        primaryStage.show();


        try{
            //Create socket to connect to the server
            Socket socket = new Socket("localhost", 8001);
            //Create an input stream to receive data from the server
            fromServer = new DataInputStream(socket.getInputStream());
            //Create an output stream to send data to the server
            toServer = new DataOutputStream(socket.getOutputStream());
        } catch (IOException ex){
            ta.appendText(ex.toString() + '\n');
        }

        //Create a new task object using anonymous inner class and lambda
        tf.setOnAction(e->{
            try{
                //Get the radius from the text field
                double radius = Double.parseDouble(tf.getText().trim());
                //Send the radius to the server
                toServer.writeDouble(radius);
                toServer.flush();  //makes sure

                //Get area from the server
                double area = fromServer.readDouble();

                //Display to the text area
                ta.appendText("Radius is " + radius + "\n");
                ta.appendText("Area received from the server is " + area + '\n');
            } catch (IOException ex){

            }
        });



    }


    public static void main(String[] args) {
        launch(args);
    }
}
