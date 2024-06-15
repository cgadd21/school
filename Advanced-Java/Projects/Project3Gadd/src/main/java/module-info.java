module com.example.project3gadd {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.project3gadd to javafx.fxml;
    exports com.example.project3gadd;
}