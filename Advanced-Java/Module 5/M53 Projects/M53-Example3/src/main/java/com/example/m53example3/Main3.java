package com.example.m53example3;


import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

//Using animation to make a window close after a length of time

public class Main3 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Button on the primary stage
        Button popButton = new Button("See Pop-Up Window");
        //Layout for primary stage
        Pane root = new Pane(popButton);
        //Binds the center of the button to the center of the pane - had to account for size of button
        popButton.layoutXProperty().bind(root.widthProperty().divide(2).subtract(popButton.widthProperty().divide(2)));
        popButton.layoutYProperty().bind(root.heightProperty().divide(2).subtract(popButton.heightProperty().divide(2)));
        Scene scene = new Scene(root, 600, 600);
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(scene);
        primaryStage.show();

        //Setup of the pop-up window - new scene, new stage
        Label popLabel = new Label("This will disappear very soon...");
        popLabel.setFont(new Font("Arial", 18));
        Pane root2 = new Pane(popLabel);
        popLabel.layoutXProperty().bind(root2.widthProperty().divide(2).subtract(popLabel.widthProperty().divide(2)));
        popLabel.layoutYProperty().bind(root2.heightProperty().divide(2).subtract(popLabel.heightProperty().divide(2)));
        //Scene and setScene for pop-up stage
        Scene scene2 = new Scene(root2, 400, 200);
        Stage stage2 = new Stage();
        stage2.setScene(scene2);

        //EventHandler for first half of the animation - showing the pop-up
        EventHandler<ActionEvent> showStage = actionEvent -> stage2.show();

        //EventHandler for second half of the animation - hiding the pop-up
        EventHandler<ActionEvent> hideStage = actionEvent -> stage2.hide();

        //A KeyFrame that will execute the showStage event handler after 5 milliseconds
        KeyFrame frame = new KeyFrame(Duration.millis(5), showStage);
        //A KeyFrame that will execute the hideStage event handler after 3 seconds
        KeyFrame frame2 = new KeyFrame(Duration.seconds(3), hideStage);
        //The Timeline that will enable animation - first frame, then frame 2
        Timeline animation = new Timeline(frame, frame2);
        //How many times the animation should run
        animation.setCycleCount(1);

        //The final user interaction that triggers the whole thing
        //When the user clicks the button, the Timeline object (animation) will play.
        popButton.setOnAction(e-> animation.play());
    }


    public static void main(String[] args) {
        launch(args);
    }
}
