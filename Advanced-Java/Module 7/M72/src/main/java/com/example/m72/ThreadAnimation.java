package com.example.m72;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ThreadAnimation extends Application {
    private String text = "";
    @Override
    public void start(Stage primaryStage) {
        StackPane pane = new StackPane();
        Label lblText = new Label("Hi");
        lblText.setFont(new Font("Arial", 50));
        pane.getChildren().add(lblText);

        //create a new thread and run the .start() method on it
        //this thread is not being saved to a variable
        new Thread(new Runnable(){                                              //create a Runnable object because this is what Threads require
            @Override
            public void run(){                                                  //override the run method from runnable
                try{                                                            //use try/catch for Thread.sleep()
                    while(true){
                        if(lblText.getText().trim().length() == 0){
                            text = "Hi";                                        //set text based on current length label text
                        } else {
                            text = "";
                        }
                        Platform.runLater(()-> lblText.setText(text));          //updating the GUI from this thread (lambda)
                        Thread.sleep(200);                                      //wait 200 ms before relooping
                    }
                } catch (InterruptedException ignored){
                }
            }
        }).start();

        Scene scene = new Scene(pane);
        primaryStage.setTitle("FlashText");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }


}
