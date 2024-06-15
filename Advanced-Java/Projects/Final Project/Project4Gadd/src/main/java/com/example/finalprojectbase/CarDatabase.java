package com.example.finalprojectbase;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.sql.*;

public class CarDatabase extends Application {

    private final TableView<Car> table = new TableView<>();
    private final ObservableList<Car> carData = FXCollections.observableArrayList();

    @Override
    public void init() throws Exception {
        try (Connection connect = DriverManager.getConnection("jdbc:derby:CarDatabase; create = true");
             Statement state = connect.createStatement();) {

            DatabaseMetaData dbm = connect.getMetaData();
            ResultSet result = dbm.getTables(null, null, "CAR_INFO", null);

            if (result.next()) {
                System.out.println("car_info exists");
            } else {
                state.execute("create table car_info(manufacturer varchar(100), model varchar(100), mpg int, hp int, usa_status boolean)");
                System.out.println("car_info created");
            }

        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Label title = new Label("Car Information Form");
        title.setPrefWidth(850);
        title.setAlignment(Pos.CENTER);
        title.setPadding(new Insets(20, 0, 40, 0));

        Label lbManufacturer = new Label("Car's Manufacturer");
        TextField tfManufacturer = new TextField();
        Label lbModel = new Label("Car's Model");
        TextField tfModel = new TextField();
        Label lbMPG = new Label("Car's MPG");
        TextField tfMPG = new TextField();
        Label lbHP = new Label("Car's HP");
        TextField tfHP = new TextField();
        Label lbUSA = new Label("Made in the USA?");
        RadioButton rbYes = new RadioButton("Yes");
        RadioButton rbNo = new RadioButton("No");
        ToggleGroup tgVax = new ToggleGroup();
        rbNo.setToggleGroup(tgVax);
        rbYes.setToggleGroup(tgVax);
        Button submit = new Button("Submit Record");
        Button view = new Button("View Table");
        Button power = new Button("Show Power");

        title.setFont(Font.font("Verdana", 28));
        lbManufacturer.setFont(Font.font("Verdana", 28));
        tfManufacturer.setFont(Font.font("Verdana", 28));
        lbModel.setFont(Font.font("Verdana", 28));
        tfModel.setFont(Font.font("Verdana", 28));
        lbMPG.setFont(Font.font("Verdana", 28));
        tfMPG.setFont(Font.font("Verdana", 28));
        lbHP.setFont(Font.font("Verdana", 28));
        tfHP.setFont(Font.font("Verdana", 28));
        lbUSA.setFont(Font.font("Verdana", 28));
        rbNo.setFont(Font.font("Verdana", 28));
        rbYes.setFont(Font.font("Verdana", 28));
        submit.setFont(Font.font("Verdana", 28));
        view.setFont(Font.font("Verdana", 28));
        power.setFont(Font.font("Verdana", 28));

        GridPane gp = new GridPane();
        gp.add(lbManufacturer, 0, 0);
        gp.add(tfManufacturer, 1, 0, 2, 1);
        gp.add(lbModel, 0, 1);
        gp.add(tfModel, 1, 1, 2, 1);
        gp.add(lbMPG, 0, 2);
        gp.add(tfMPG, 1, 2, 2, 1);
        gp.add(lbHP, 0, 3);
        gp.add(tfHP, 1, 3, 2, 1);
        gp.add(lbUSA, 0, 4);
        gp.add(rbYes, 1, 4);
        gp.add(rbNo, 2, 4);
        gp.add(submit, 0, 5);
        gp.add(view, 1, 5);
        gp.add(power, 2, 5);
        gp.setVgap(30);
        gp.setHgap(20);

        VBox mainLayout = new VBox(title, gp);
        mainLayout.setPadding(new Insets(20));

        TableColumn<Car, String> manufacturerCol = new TableColumn<>("Manufacturer");
        TableColumn<Car, String> modelCol = new TableColumn<>("Model");
        TableColumn<Car, Integer> wpgCol = new TableColumn<>("MPG");
        TableColumn<Car, Integer> hpCol = new TableColumn<>("HP");
        TableColumn<Car, Boolean> usaCol = new TableColumn<>("'Merica");

        table.getColumns().add(manufacturerCol);
        table.getColumns().add(modelCol);
        table.getColumns().add(wpgCol);
        table.getColumns().add(hpCol);
        table.getColumns().add(usaCol);

        table.setStyle("-fx-font-size: 30px; -fx-pref-width: 1100px");
        manufacturerCol.setStyle("-fx-font-size: 30px; -fx-pref-width: 220px");
        modelCol.setStyle("-fx-font-size: 30px; -fx-pref-width: 220px");
        wpgCol.setStyle("-fx-font-size: 30px; -fx-pref-width: 220px");
        hpCol.setStyle("-fx-font-size: 30px; -fx-pref-width: 220px");
        usaCol.setStyle("-fx-font-size: 30px; -fx-pref-width: 220px");

        Scene viewScene = new Scene(table);

        submit.setOnAction(e -> {
            try (Connection connect = DriverManager.getConnection("jdbc:derby:CarDatabase");
                 PreparedStatement addRecord = connect.prepareStatement("INSERT INTO car_info VALUES(?, ?, ?, ?, ?)");) {

                String carsManufacturer = tfManufacturer.getText();
                String carsModel = (tfModel.getText());
                int carsMPG = Integer.parseInt(tfMPG.getText());
                int carsHP = Integer.parseInt(tfHP.getText());
                boolean usaStatus = rbYes.isSelected();

                addRecord.setString(1, carsManufacturer);
                addRecord.setString(2, carsModel);
                addRecord.setInt(3, carsMPG);
                addRecord.setInt(4, carsHP);
                addRecord.setBoolean(5, usaStatus);
                addRecord.executeUpdate();

                tfManufacturer.setText("");
                tfModel.setText("");
                tfMPG.setText("");
                tfHP.setText("");
                rbYes.setSelected(true);

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Successful Operation");
                alert.setHeaderText(null);
                alert.setContentText("Record Added.");
                alert.show();

            } catch(SQLException ex){
                System.out.println(ex.getMessage());
            }
        });

        view.setOnAction(e->{

            table.getItems().clear();

            try(Connection connect = DriverManager.getConnection("jdbc:derby:CarDatabase");
                Statement state = connect.createStatement();
                ResultSet result = state.executeQuery("SELECT * FROM car_info");) {

                while (result.next()) {
                    String carManufacturer = result.getString("manufacturer");
                    String carModel = result.getString("model");
                    int carMPG = result.getInt("mpg");
                    int carHP = result.getInt("hp");
                    boolean carUSA = result.getBoolean("usa_status");

                    Car currentCar = new Car(carManufacturer, carModel, carMPG, carHP ,carUSA);

                    carData.add(currentCar);

                    manufacturerCol.setCellValueFactory(new PropertyValueFactory<>("manufacturer"));
                    modelCol.setCellValueFactory(new PropertyValueFactory<>("model"));
                    wpgCol.setCellValueFactory(new PropertyValueFactory<>("mpg"));
                    hpCol.setCellValueFactory(new PropertyValueFactory<>("hp"));
                    usaCol.setCellValueFactory(new PropertyValueFactory<>("usa"));

                    table.setItems(carData);
                }

                Stage smallStage = new Stage();
                smallStage.setScene(viewScene);
                smallStage.setTitle("All Records");
                smallStage.show();

            } catch(SQLException ex){
                System.out.println(ex.getMessage());
            }
        });

        power.setOnAction(e->{
            table.getItems().clear();
            try (Connection connect = DriverManager.getConnection("jdbc:derby:CarDatabase");
                Statement state = connect.createStatement();
                ResultSet result = state.executeQuery("SELECT * FROM car_info ORDER BY hp DESC ");) {

                while (result.next()) {
                    String carManufacturer = result.getString("manufacturer");
                    String carModel = result.getString("model");
                    int carMPG = result.getInt("mpg");
                    int carHP = result.getInt("hp");
                    boolean carUSA = result.getBoolean("usa_status");
                    Car currentCar = new Car(carManufacturer, carModel, carMPG, carHP ,carUSA);
                    carData.add(currentCar);

                    manufacturerCol.setCellValueFactory(new PropertyValueFactory<>("manufacturer"));
                    modelCol.setCellValueFactory(new PropertyValueFactory<>("model"));
                    wpgCol.setCellValueFactory(new PropertyValueFactory<>("mpg"));
                    hpCol.setCellValueFactory(new PropertyValueFactory<>("hp"));
                    usaCol.setCellValueFactory(new PropertyValueFactory<>("usa"));
                    table.setItems(carData);
                }
                Stage smallStage = new Stage();
                smallStage.setScene(viewScene);
                smallStage.setTitle("All Records");
                smallStage.show();

                } catch(SQLException ex){
                System.out.println(ex.getMessage());
            }
        });

        primaryStage.setTitle("Car Information Entry Form");
        Scene scene = new Scene(mainLayout, 800, 800);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void stop(){
        try{
            DriverManager.getConnection("jdbc:derby:CarDatabase:;shutdown=true");
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
