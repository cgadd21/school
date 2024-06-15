package com.example.m42;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        HBox topPane = new HBox();
        HBox bottomPane = new HBox();
        VBox leftPane = new VBox();
        VBox rightPane = new VBox();
        VBox centerPane = new VBox();
        BorderPane root = new BorderPane(centerPane, topPane, rightPane, bottomPane, leftPane);

        Image pizzaImage = new Image("file:src/main/resources/images/pizza.png", 150, 0, true, true);
        ImageView view1 = new ImageView(pizzaImage);

        Image fruitImage = new Image("file:src/main/resources/images/fruit.png", 150, 0, true, true);
        ImageView view2 = new ImageView(fruitImage);
        //Styling Panes

        leftPane.setPadding(new Insets(25));
        leftPane.setSpacing(25);
        leftPane.setBackground(new Background(new BackgroundFill(Color.DARKBLUE, new CornerRadii(5), new Insets(5))));
        //rightPane.setPrefWidth(200);
        rightPane.setPadding(new Insets(25));
        rightPane.setSpacing(25);
        rightPane.setStyle("-fx-background-color: #f5f5dc; -fx-border-color: #8b0000");

        centerPane.setPrefWidth(600);
        centerPane.setPadding(new Insets(25));
        centerPane.setSpacing(25);

        //Top Pane Controls
        Menu fileMenu = new Menu("File");
        Menu optionsMenu = new Menu("Options");
        Menu editMenu = new Menu("Edit");
        Menu helpMenu = new Menu("Help");
        MenuBar topMenuBar = new MenuBar(fileMenu, optionsMenu, editMenu, helpMenu);
        topPane.getChildren().add(topMenuBar);

        topMenuBar.prefWidthProperty().bind(stage.widthProperty());

        //Left Pane Controls
        Button thing1Button = createButton("Thing 1");
        Button thing2Button = createButton("Thing 2");
        Button thing3Button = createButton("Thing 3");
        Button thing4Button = createButton("Thing 4");

        leftPane.getChildren().addAll(thing1Button, thing2Button, thing3Button, thing4Button);

        //Right Pane Controls
        Label rightTitleLabel = createLabel("Here are things to read:");
        Label read1Label = createLabel("This label is awesome and so are you.");
        Label read2Label = createLabel("This label has no actual purpose.");
        Label read3Label = createLabel("Not a single label is necessary here but that's okay.");
        rightPane.getChildren().addAll(rightTitleLabel, read1Label, view1, read2Label, view2, read3Label);

        //Center Pane Controls
        TitledPane fruitPane = new TitledPane("Fruits", new Label("Apples, Oranges, Bananas, Kiwis, Grapes, Strawberries"));
        TitledPane vegetablePane = new TitledPane("Vegetables", new Label("Carrots, Onions, Kale, Peas, Squash, Peppers"));
        TitledPane cheesePane = new TitledPane("Cheeses", new Label("Cheddar, Swiss, Provolone, Mozzarella, Pepper Jack"));
        Accordion centerAccord = new Accordion(fruitPane, vegetablePane, cheesePane);
        centerPane.getChildren().add(centerAccord);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Module 4 Demo");
        stage.show();
    }

    public static Button createButton(String text){
        Button button = new Button(text);
        button.setPrefWidth(150);
        button.setPrefHeight(50);
        button.setPadding(new Insets(20));
        button.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        button.setTextFill(Color.DARKBLUE);
        button.setBackground(new Background(new BackgroundFill(Color.BEIGE, new CornerRadii(5), new Insets(5))));
        button.setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.DOTTED, new CornerRadii(5), new BorderWidths(3), new Insets(5))));
        return button;
    }

    public static Label createLabel(String text){
        Label label = new Label(text);
        label.setPrefWidth(150);
        label.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC, 16));
        label.setTextFill(Color.DARKRED);
        label.setWrapText(true);
        return label;
    }

    public static void main(String[] args) {
        launch();
    }
}