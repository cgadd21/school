module com.example.project2gadd {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.project2gadd to javafx.fxml;
    exports com.example.project2gadd;
}