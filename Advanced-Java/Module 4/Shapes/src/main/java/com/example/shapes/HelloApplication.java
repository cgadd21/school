package com.example.shapes;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Pane pane = new Pane();

        Circle c1 = new Circle();
        c1.setCenterX(300);
        c1.setCenterY(300);
        c1.setRadius(50);
        c1.setStroke(Color.BLACK);
        c1.setFill(Color.YELLOWGREEN);

        pane.getChildren().add(c1);

        Rectangle r1 = new Rectangle();
        r1.setX(40);
        r1.setY(40);
        r1.setWidth(100);
        r1.setHeight(75);
        r1.setStroke(Color.DARKBLUE);
        r1.setFill(Color.LIGHTSALMON);
        r1.setRotate(45);
        r1.setArcWidth(20);
        r1.setArcHeight(55);

        pane.getChildren().add(r1);

        Ellipse e1 = new Ellipse();
        e1.setCenterX(100);
        e1.setCenterY(400);
        e1.setRadiusX(100);
        e1.setRadiusY(50);
        e1.setFill(Color.AQUAMARINE);
        e1.setStroke(Color.DARKMAGENTA);

        pane.getChildren().add(e1);
        Arc a1 = new Arc(150, 100, 80, 80, 30, 35);
        a1.setFill(Color.RED);
        a1.setType(ArcType.ROUND);

        pane.getChildren().add(a1);

        Line line1 = new Line(400, 400, 500, 500);
        Line line2 = new Line(400, 500, 500, 400);
        line1.setStrokeWidth(10);
        line2.setStrokeWidth(10);
        line1.setStroke(Color.GREEN);
        line2.setStroke(Color.BLUE);

        pane.getChildren().addAll(line1, line2);

        Polygon p1 = new Polygon();
        p1.setFill(Color.ORANGE);
        p1.setStroke(Color.BLACK);
        Double[] points = {
                200.0, 50.0,
                400.0, 50.0,
                450.0, 150.0,
                400.0, 250.0,
                200.0, 250.0,
                150.0, 150.0};
        p1.getPoints().addAll(points);

        pane.getChildren().add(p1);

        Text t1 = new Text(300, 300, "WOW");
        t1.setFont(Font.font("Verdana", FontWeight.BOLD, 85));
        t1.setFill(Color.PURPLE);
        t1.setStroke(Color.YELLOW);
        t1.setStrokeWidth(6);
        t1.setUnderline(false);

        pane.getChildren().add(t1);

        //Section on Property Binding

        Circle boundCircle = new Circle(200, Color.CYAN);
        boundCircle.centerXProperty().bind(pane.widthProperty().divide(2));
        boundCircle.centerYProperty().bind(pane.heightProperty().divide(2));

        pane.getChildren().add(boundCircle);

        Rectangle r2 = new Rectangle(100, 100);

        r2.heightProperty().bind(pane.heightProperty().multiply(2).divide(3));
        r2.widthProperty().bind(pane.widthProperty().multiply(2).divide(3));

        r2.xProperty().bind(pane.widthProperty().divide(2).subtract(r2.widthProperty().divide(2)));
        r2.yProperty().bind(pane.heightProperty().divide(2).subtract(r2.heightProperty().divide(2)));
        r2.setFill(Color.rgb(100, 200, 5));
        pane.getChildren().add(r2);

        Scene scene = new Scene(pane,600, 600);
        stage.setTitle("Hello World");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}