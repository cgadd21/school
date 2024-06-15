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
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.sql.*;

public class CatDatabase extends Application {
    //TableView is a JavaFX class that displays data in columns and rows
    //It is a "generic" so you must put your object type in the diamonds
    //This type is set up in a class of the same name in this project - Cat.java
    private final TableView<Cat> table = new TableView<>();

    //ObservableList is a type of list that listens for changes and will update itself automatically
    //It gets created using the observableArrayList() static method from FXCollections
    //Stores Cat objects and is also a generic--> See Cat.java
    private final ObservableList<Cat> catData = FXCollections.observableArrayList();

    //Using the init() method to create the database and table if not already created
    @Override
    public void init() throws Exception {
        try {
            Connection connect = DriverManager.getConnection("jdbc:derby:CatDatabase; create = true");
            System.out.println("Connected to database.");
            Statement state = connect.createStatement();
            System.out.println("Statement created.");
            DatabaseMetaData dbm = connect.getMetaData();
            System.out.println("MetaData created.");
            ResultSet result = dbm.getTables(null, null, "CAT_INFO", null);
            System.out.println("ResultSet created.");
            if (result.next()) {
                System.out.println("cat_info exists");
            } else {
                state.execute("create table cat_info(name varchar(100), birth_year int, weight double, vax_status boolean)");
                System.out.println("cat_info created");
            }
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    //GUI components and event handlers for communicating with database
    @Override
    public void start(Stage primaryStage) throws Exception{
        //Header Label and settings
        Label title = new Label("Cat Information Form");
        title.setPrefWidth(850);
        title.setAlignment(Pos.CENTER);
        title.setPadding(new Insets(20, 0, 40, 0));

        //Form Labels, TextFields, RadioButtons
        Label lbName = new Label("Cat's name");
        TextField tfName = new TextField();
        Label lbYear = new Label("Cat's birth year");
        TextField tfYear = new TextField();
        Label lbWeight = new Label("Cat's weight");
        TextField tfWeight = new TextField();
        Label lbVax = new Label("Vaccinated?");
        RadioButton rbYes = new RadioButton("yes");
        RadioButton rbNo = new RadioButton("no");
        ToggleGroup tgVax = new ToggleGroup();
        rbNo.setToggleGroup(tgVax);
        rbYes.setToggleGroup(tgVax);
        Button submit = new Button("Submit Record");
        Button view = new Button("View Table");
        Button shots = new Button("Needs Shots");

        //Node font settings
        title.setFont(Font.font("Verdana", 28));
        lbName.setFont(Font.font("Verdana", 28));
        tfName.setFont(Font.font("Verdana", 28));
        lbYear.setFont(Font.font("Verdana", 28));
        tfYear.setFont(Font.font("Verdana", 28));
        lbWeight.setFont(Font.font("Verdana", 28));
        tfWeight.setFont(Font.font("Verdana", 28));
        lbVax.setFont(Font.font("Verdana", 28));
        rbNo.setFont(Font.font("Verdana", 28));
        rbYes.setFont(Font.font("Verdana", 28));
        submit.setFont(Font.font("Verdana", 28));
        view.setFont(Font.font("Verdana", 28));
        shots.setFont(Font.font("Verdana", 28));

        //Form layout
        GridPane gp = new GridPane();
        gp.add(lbName, 0, 0);
        gp.add(tfName, 1, 0, 2, 1);
        gp.add(lbYear, 0, 1);
        gp.add(tfYear, 1, 1, 2, 1);
        gp.add(lbWeight, 0, 2);
        gp.add(tfWeight, 1, 2, 2, 1);
        gp.add(lbVax, 0, 3);
        gp.add(rbYes, 1, 3);
        gp.add(rbNo, 2, 3);
        gp.add(submit, 0, 4);
        gp.add(view, 1, 4);
        gp.add(shots, 2, 4);
        gp.setVgap(30);
        gp.setHgap(20);

        //Main layout for header label and gridpane
        VBox mainLayout = new VBox(title, gp);
        mainLayout.setPadding(new Insets(20));

        //Configure tableview that will be displayed when user hits View button
        //Create each column with header text in quotes
        TableColumn<Cat, String> nameCol = new TableColumn<>("Cat's Name");
        TableColumn<Cat, Integer> yearCol = new TableColumn<>("Cat's Birthdate");
        TableColumn<Cat, Double> weightCol = new TableColumn<>("Cat's Weight");
        TableColumn<Cat, Boolean> vaxCol = new TableColumn<>("Vaccinated?");

        //Add TableColumns to the javafx TableView
        table.getColumns().add(nameCol);
        table.getColumns().add(yearCol);
        table.getColumns().add(weightCol);
        table.getColumns().add(vaxCol);

        //Set styling for javafx table view and table columns - so pretty
        table.setStyle("-fx-font-size: 30px; -fx-pref-width: 880px");
        nameCol.setStyle("-fx-font-size: 30px; -fx-pref-width: 220px");
        yearCol.setStyle("-fx-font-size: 30px; -fx-pref-width: 220px");
        weightCol.setStyle("-fx-font-size: 30px; -fx-pref-width: 220px");
        vaxCol.setStyle("-fx-font-size: 30px; -fx-pref-width: 220px");

        //Add table to its own scene to be used later in View event handler and pop-up stage
        Scene viewScene = new Scene(table);

        //Event handler for Submit button
        submit.setOnAction(e -> {
            try {
                //Connect to database and create PreparedStatement for adding records
                Connection connect = DriverManager.getConnection("jdbc:derby:CatDatabase");
                System.out.println("Connected to database.");
                PreparedStatement addRecord = connect.prepareStatement("INSERT INTO cat_info VALUES(?, ?, ?, ?)");
                System.out.println("Prepared Statement created.");

                //Grab data from textfields and radiobuttons, store in variables
                String catsName = tfName.getText();
                int catsYear = Integer.parseInt(tfYear.getText());
                double catsWeight = Double.parseDouble(tfWeight.getText());
                boolean vaxStatus = rbYes.isSelected(); //isSelected will return true or false

                System.out.println("Data retrieved from controls.");

                //Put data into prepared statement and execute update to add to database table
                addRecord.setString(1, catsName);
                addRecord.setInt(2, catsYear);
                addRecord.setDouble(3, catsWeight);
                addRecord.setBoolean(4, vaxStatus);
                addRecord.executeUpdate();
                System.out.println("Added record to table");

                //After submitting, clear text fields in preparation for next entry.
                tfName.setText("");
                tfYear.setText("");
                tfWeight.setText("");
                rbYes.setSelected(true);

                //Create new stage to be displayed and pass in scene for confirmation
                //if a sql exception occurs during the above process, we will never reach
                //the confirmation below
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Successful Operation");
                alert.setHeaderText(null);
                alert.setContentText("Record Added.");
                alert.show();
            } catch(SQLException ex){
                System.out.println(ex.getMessage());
            }
        });

        //Event handler for View button to see entire table
        view.setOnAction(e->{
            //Clear the javafx tableview each time so that new views don't keep
            //getting appended to old views
            table.getItems().clear();

            try {
                //Connect to database and create statement for executing queries
                Connection connect = DriverManager.getConnection("jdbc:derby:CatDatabase");
                System.out.println("Connected to database.");
                Statement state = connect.createStatement();
                System.out.println("Statement created.");
                //Using * will select all fields from the table
                ResultSet result = state.executeQuery("SELECT * FROM cat_info");
                System.out.println("ResultSet created.");
                //Loop through the results from the query and grab each value
                while (result.next()) {
                    String catName = result.getString("name");
                    int birthYear = result.getInt("birth_year");
                    double weight = result.getDouble("weight");
                    boolean vaxInfo = result.getBoolean("vax_status");

                    //Store retrieved values from the resultset in a Cat object --> See Cat.java
                    //This is necessary for using observable list, which is necessary
                    //for adding values to your javafx tableview
                    Cat currentCat = new Cat(catName, birthYear, weight, vaxInfo);

                    //Add Cat object to observable list
                    catData.add(currentCat);

                    //tell each column which Cat data member to connect to
                    //THIS PART IS WEIRD!!!!!!
                    //notice that name, year, weight and vaccinated are my private data member variables from Cat
                    //the words in quotes are variables from Cat, not the names of my columns in the table
                    nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
                    yearCol.setCellValueFactory(new PropertyValueFactory<>("year"));
                    weightCol.setCellValueFactory(new PropertyValueFactory<>("weight"));
                    vaxCol.setCellValueFactory(new PropertyValueFactory<>("vaccinated"));

                    //Add catData to the table
                    table.setItems(catData);
                }

                //Another event handler must be added for third button option


                System.out.println("Table populated.");
                //A new stage so a new window pops up
                Stage smallStage = new Stage();
                //Add earlier scene to it that holds the table
                smallStage.setScene(viewScene);
                System.out.println("Scene set to stage.");
                smallStage.setTitle("All Records");
                smallStage.show();
            } catch(SQLException ex){
                System.out.println(ex.getMessage());
            }
        });

        //Main scene and stage
        primaryStage.setTitle("Cat Information Entry Form");
        Scene scene = new Scene(mainLayout, 800, 550);
        primaryStage.setScene(scene);
        primaryStage.show();
    }





    public static void main(String[] args) {
        launch(args);
    }
}
