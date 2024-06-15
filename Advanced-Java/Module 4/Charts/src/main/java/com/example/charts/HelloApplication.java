package com.example.charts;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Group;

import java.io.IOException;


public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        //This program contains 2 scenes - one with a BarChart, one with a PieChart
        //To view the BarChart, make sure the stage is set to view the scene object
        //To view the PieChart, make sure the stage is set to view the scene1 object

        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Year");
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Miles Driven");

        BarChart chart = new BarChart(xAxis, yAxis);
        chart.setTitle("Mileage per Year");
        chart.setStyle("-fx-font-size: 24");

        XYChart.Series myData = new XYChart.Series();
        myData.setName("Candy");
        XYChart.Series lizData = new XYChart.Series();
        lizData.setName("Liz");
        XYChart.Series catData = new XYChart.Series();
        catData.setName("Cats");

        myData.getData().add(new XYChart.Data("2010", 10222));
        myData.getData().add(new XYChart.Data("2011", 12523));
        myData.getData().add(new XYChart.Data("2012", 27400));
        myData.getData().add(new XYChart.Data("2013", 21654));
        myData.getData().add(new XYChart.Data("2014", 17201));
        myData.getData().add(new XYChart.Data("2015", 20099));
        myData.getData().add(new XYChart.Data("2016", 11322));
        myData.getData().add(new XYChart.Data("2017", 19983));
        myData.getData().add(new XYChart.Data("2018", 14071));

        lizData.getData().add(new XYChart.Data("2010", 15789));
        lizData.getData().add(new XYChart.Data("2011", 22966));
        lizData.getData().add(new XYChart.Data("2012", 14376));
        lizData.getData().add(new XYChart.Data("2013", 11765));
        lizData.getData().add(new XYChart.Data("2014", 19211));
        lizData.getData().add(new XYChart.Data("2015", 16287));
        lizData.getData().add(new XYChart.Data("2016", 9345));
        lizData.getData().add(new XYChart.Data("2017", 13780));
        lizData.getData().add(new XYChart.Data("2018", 20025));

        catData.getData().add(new XYChart.Data("2010", 1544));
        catData.getData().add(new XYChart.Data("2011", 765));
        catData.getData().add(new XYChart.Data("2012", 74));
        catData.getData().add(new XYChart.Data("2013", 908));
        catData.getData().add(new XYChart.Data("2014", 555));
        catData.getData().add(new XYChart.Data("2015", 3485));
        catData.getData().add(new XYChart.Data("2016", 452));
        catData.getData().add(new XYChart.Data("2017", 22));
        catData.getData().add(new XYChart.Data("2018", 1066));

        chart.getData().add(myData);
        chart.getData().add(lizData);
        chart.getData().add(catData);

        StackPane pane = new StackPane(chart);
        Scene scene = new Scene(pane, 700, 700);

        //To use this section, change the scene in setScene to scene1
        PieChart favoriteCandy = new PieChart();
        PieChart.Data slice1 = new PieChart.Data("Candy Corn", 100);
        PieChart.Data slice2 = new PieChart.Data("Reese's Cups", 22);
        PieChart.Data slice3 = new PieChart.Data("KitKat", 15);
        PieChart.Data slice4 = new PieChart.Data("Twizzlers", 20);
        PieChart.Data slice5 = new PieChart.Data("M&M's", 50);
        PieChart.Data slice6 = new PieChart.Data("Skittles", 35);
        PieChart.Data slice7 = new PieChart.Data("None", 4);

        favoriteCandy.getData().addAll(slice1, slice2, slice3, slice4, slice5, slice6, slice7);
        favoriteCandy.setStyle("-fx-font-size: 20");

        StackPane piePane = new StackPane(favoriteCandy);
        Scene scene1 = new Scene(piePane, 700, 700);
        stage.setTitle("Chart Sampler");
        stage.setScene(scene);  //modify this to see each chart 1 at a time
        stage.show();




    }




    public static void main(String[] args) {
        launch(args);
    }
}
