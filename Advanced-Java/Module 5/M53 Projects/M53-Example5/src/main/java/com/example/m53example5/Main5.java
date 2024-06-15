package com.example.m53example5;



import javafx.animation.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

//Examples of different Transition types - see video as some parts may need commented out

public class Main5 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Rectangle square1 = new Rectangle(400, 400, Color.RED);
        Rectangle square2 = new Rectangle(350, 350, Color.ORANGE);
        Rectangle square3 = new Rectangle(300, 300, Color.YELLOW);
        Rectangle square4 = new Rectangle(250, 250, Color.LAWNGREEN);
        Rectangle square5 = new Rectangle(200, 200, Color.BLUE);
        Rectangle square6 = new Rectangle(150, 150, Color.INDIGO);
        Rectangle square7 = new Rectangle(100, 100, Color.PURPLE);
        Pane root = new Pane(square1, square2, square3, square4, square5, square6, square7);
        square1.xProperty().bind(root.widthProperty().divide(2).subtract(square1.widthProperty().divide(2)));
        square1.yProperty().bind(root.heightProperty().divide(2).subtract(square1.heightProperty().divide(2)));
        square2.xProperty().bind(root.widthProperty().divide(2).subtract(square2.widthProperty().divide(2)));
        square2.yProperty().bind(root.heightProperty().divide(2).subtract(square2.heightProperty().divide(2)));
        square3.xProperty().bind(root.widthProperty().divide(2).subtract(square3.widthProperty().divide(2)));
        square3.yProperty().bind(root.heightProperty().divide(2).subtract(square3.heightProperty().divide(2)));
        square4.xProperty().bind(root.widthProperty().divide(2).subtract(square4.widthProperty().divide(2)));
        square4.yProperty().bind(root.heightProperty().divide(2).subtract(square4.heightProperty().divide(2)));
        square5.xProperty().bind(root.widthProperty().divide(2).subtract(square5.widthProperty().divide(2)));
        square5.yProperty().bind(root.heightProperty().divide(2).subtract(square5.heightProperty().divide(2)));
        square6.xProperty().bind(root.widthProperty().divide(2).subtract(square6.widthProperty().divide(2)));
        square6.yProperty().bind(root.heightProperty().divide(2).subtract(square6.heightProperty().divide(2)));
        square7.xProperty().bind(root.widthProperty().divide(2).subtract(square7.widthProperty().divide(2)));
        square7.yProperty().bind(root.heightProperty().divide(2).subtract(square7.heightProperty().divide(2)));



        FillTransition changeFill7 = new FillTransition(Duration.millis(1000), square7);
        changeFill7.setFromValue(Color.PURPLE);
        changeFill7.setToValue(Color.INDIGO);
        changeFill7.setCycleCount(1);

        RotateTransition spin7 = new RotateTransition(Duration.millis(1000), square7);
        spin7.setFromAngle(0);
        spin7.setToAngle(360);
        spin7.setCycleCount(1);

        FadeTransition fade7 = new FadeTransition(Duration.millis(1), square7);
        fade7.setFromValue(1.0);
        fade7.setToValue(0.0);

        FillTransition changeFill6 = new FillTransition(Duration.millis(1000), square6);
        changeFill6.setFromValue(Color.INDIGO);
        changeFill6.setToValue(Color.BLUE);
        changeFill6.setCycleCount(1);

        RotateTransition spin6 = new RotateTransition(Duration.millis(1000), square6);
        spin6.setFromAngle(0);
        spin6.setToAngle(360);
        spin6.setCycleCount(1);

        FadeTransition fade6 = new FadeTransition(Duration.millis(1), square6);
        fade6.setFromValue(1.0);
        fade6.setToValue(0.0);

        FillTransition changeFill5 = new FillTransition(Duration.millis(1000), square5);
        changeFill5.setFromValue(Color.BLUE);
        changeFill5.setToValue(Color.LAWNGREEN);
        changeFill5.setCycleCount(1);

        RotateTransition spin5 = new RotateTransition(Duration.millis(1000), square5);
        spin5.setFromAngle(0);
        spin5.setToAngle(360);
        spin5.setCycleCount(1);

        FadeTransition fade5 = new FadeTransition(Duration.millis(1), square5);
        fade5.setFromValue(1.0);
        fade5.setToValue(0.0);

        FillTransition changeFill4 = new FillTransition(Duration.millis(1000), square4);
        changeFill4.setFromValue(Color.LAWNGREEN);
        changeFill4.setToValue(Color.YELLOW);
        changeFill4.setCycleCount(1);

        RotateTransition spin4 = new RotateTransition(Duration.millis(1000), square4);
        spin4.setFromAngle(0);
        spin4.setToAngle(360);
        spin4.setCycleCount(1);

        FadeTransition fade4 = new FadeTransition(Duration.millis(1), square4);
        fade4.setFromValue(1.0);
        fade4.setToValue(0.0);

        FillTransition changeFill3 = new FillTransition(Duration.millis(1000), square3);
        changeFill3.setFromValue(Color.YELLOW);
        changeFill3.setToValue(Color.ORANGE);
        changeFill3.setCycleCount(1);

        RotateTransition spin3 = new RotateTransition(Duration.millis(1000), square3);
        spin3.setFromAngle(0);
        spin3.setToAngle(360);
        spin3.setCycleCount(1);

        FadeTransition fade3 = new FadeTransition(Duration.millis(1), square3);
        fade3.setFromValue(1.0);
        fade3.setToValue(0.0);

        FillTransition changeFill2 = new FillTransition(Duration.millis(1000), square2);
        changeFill2.setFromValue(Color.ORANGE);
        changeFill2.setToValue(Color.RED);
        changeFill2.setCycleCount(1);

        RotateTransition spin2 = new RotateTransition(Duration.millis(1000), square2);
        spin2.setFromAngle(0);
        spin2.setToAngle(360);
        spin2.setCycleCount(1);

        FadeTransition fade2 = new FadeTransition(Duration.millis(1), square2);
        fade2.setFromValue(1.0);
        fade2.setToValue(0.0);

        FillTransition changeFill1 = new FillTransition(Duration.millis(1000), square1);
        changeFill1.setFromValue(Color.RED);
        changeFill1.setToValue(Color.PURPLE);
        changeFill1.setCycleCount(1);

        RotateTransition spin1 = new RotateTransition(Duration.millis(1000), square1);
        spin1.setFromAngle(0);
        spin1.setToAngle(360);
        spin1.setCycleCount(1);

        ParallelTransition firstSquare = new ParallelTransition(changeFill7, spin7);
        firstSquare.setCycleCount(1);
        ParallelTransition secondSquare = new ParallelTransition(changeFill6, spin6);
        secondSquare.setCycleCount(1);
        ParallelTransition thirdSquare = new ParallelTransition(changeFill5, spin5);
        thirdSquare.setCycleCount(1);
        ParallelTransition fourthSquare = new ParallelTransition(changeFill4, spin4);
        fourthSquare.setCycleCount(1);
        ParallelTransition fifthSquare = new ParallelTransition(changeFill3, spin3);
        fifthSquare.setCycleCount(1);
        ParallelTransition sixthSquare = new ParallelTransition(changeFill2, spin2);
        sixthSquare.setCycleCount(1);
        ParallelTransition seventhSquare = new ParallelTransition(changeFill1, spin1);
        seventhSquare.setCycleCount(1);

        SequentialTransition sequence = new SequentialTransition(firstSquare, fade7, secondSquare, fade6, thirdSquare, fade5, fourthSquare, fade4, fifthSquare, fade3, sixthSquare, fade2, seventhSquare);
        sequence.setCycleCount(SequentialTransition.INDEFINITE);
        sequence.setAutoReverse(true);
        sequence.play();

        Scene scene = new Scene(root, 600, 600);
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(scene);
        primaryStage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }
}
