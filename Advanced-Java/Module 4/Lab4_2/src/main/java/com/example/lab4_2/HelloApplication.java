package com.example.lab4_2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Pane pane = new Pane();
        Random random = new Random();

        int redValue1 = random.nextInt(256);
        int greenValue1 = random.nextInt(256);
        int blueValue1 = random.nextInt(256);
        Circle boundCircle1 = new Circle(50, Color.rgb(redValue1,greenValue1,blueValue1));
        boundCircle1.centerXProperty().bind(pane.widthProperty().divide(5));
        boundCircle1.centerYProperty().bind(pane.heightProperty().divide(5));
        pane.getChildren().add(boundCircle1);

        int redValue2 = random.nextInt(256);
        int greenValue2 = random.nextInt(256);
        int blueValue2 = random.nextInt(256);
        Circle boundCircle2 = new Circle(50, Color.rgb(redValue2,greenValue2,blueValue2));
        boundCircle2.centerXProperty().bind(pane.widthProperty().divide(5));
        boundCircle2.centerYProperty().bind(pane.heightProperty().multiply(4).divide(5));
        pane.getChildren().add(boundCircle2);

        int redValue3 = random.nextInt(256);
        int greenValue3 = random.nextInt(256);
        int blueValue3 = random.nextInt(256);
        Circle boundCircle3 = new Circle(50, Color.rgb(redValue3,greenValue3,blueValue3));
        boundCircle3.centerXProperty().bind(pane.widthProperty().multiply(2).divide(5));
        boundCircle3.centerYProperty().bind(pane.heightProperty().multiply(2).divide(5));
        pane.getChildren().add(boundCircle3);

        int redValue4 = random.nextInt(256);
        int greenValue4 = random.nextInt(256);
        int blueValue4 = random.nextInt(256);
        Circle boundCircle4 = new Circle(50, Color.rgb(redValue4,greenValue4,blueValue4));
        boundCircle4.centerXProperty().bind(pane.widthProperty().multiply(2).divide(5));
        boundCircle4.centerYProperty().bind(pane.heightProperty().multiply(3).divide(5));
        pane.getChildren().add(boundCircle4);

        int redValue5 = random.nextInt(256);
        int greenValue5 = random.nextInt(256);
        int blueValue5 = random.nextInt(256);
        Circle boundCircle5 = new Circle(50, Color.rgb(redValue5,greenValue5,blueValue5));
        boundCircle5.centerXProperty().bind(pane.widthProperty().multiply(3).divide(5));
        boundCircle5.centerYProperty().bind(pane.heightProperty().multiply(2).divide(5));
        pane.getChildren().add(boundCircle5);

        int redValue6 = random.nextInt(256);
        int greenValue6 = random.nextInt(256);
        int blueValue6 = random.nextInt(256);
        Circle boundCircle6 = new Circle(50, Color.rgb(redValue6,greenValue6,blueValue6));
        boundCircle6.centerXProperty().bind(pane.widthProperty().multiply(3).divide(5));
        boundCircle6.centerYProperty().bind(pane.heightProperty().multiply(3).divide(5));
        pane.getChildren().add(boundCircle6);

        int redValue7 = random.nextInt(256);
        int greenValue7 = random.nextInt(256);
        int blueValue7 = random.nextInt(256);
        Circle boundCircle7 = new Circle(50, Color.rgb(redValue7,greenValue7,blueValue7));
        boundCircle7.centerXProperty().bind(pane.widthProperty().multiply(4).divide(5));
        boundCircle7.centerYProperty().bind(pane.heightProperty().divide(5));
        pane.getChildren().add(boundCircle7);

        int redValue8 = random.nextInt(256);
        int greenValue8 = random.nextInt(256);
        int blueValue8 = random.nextInt(256);
        Circle boundCircle8 = new Circle(50, Color.rgb(redValue8,greenValue8,blueValue8));
        boundCircle8.centerXProperty().bind(pane.widthProperty().multiply(4).divide(5));
        boundCircle8.centerYProperty().bind(pane.heightProperty().multiply(4).divide(5));
        pane.getChildren().add(boundCircle8);

        Scene scene = new Scene(pane,600, 600);
        stage.setTitle("Lab 4.2");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
