package com.example.lab7;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HelloApplication extends Application {

    TextArea textArea = new TextArea();

    @Override
    public void start(Stage stage) throws IOException {
        ExecutorService executor = Executors.newCachedThreadPool();
        textArea.setWrapText(true);
        Button button = new Button("Start Task");
        VBox root = new VBox(textArea,button);
        Scene scene = new Scene(root,600,200);
        stage.setTitle("Lab 7");
        stage.setScene(scene);
        stage.show();

    button.setOnAction(e->{
        for(int i=0; i<10; i++) {
            int finalI = i;
            executor.execute(() -> printInt(finalI, 100));
        }
    });

    }
        public void printInt(int digit, int times) {
            try {
                for (int i = 0; i < times; i++) {
                    Platform.runLater(() -> {
                        textArea.appendText(String.valueOf(digit));
                    });
                    Thread.sleep(1);
                }
            } catch (InterruptedException e){
                System.out.println();
            }

        }

    public static void main(String[] args) {
        launch();
    }
}