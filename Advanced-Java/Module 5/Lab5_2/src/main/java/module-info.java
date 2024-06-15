module com.example.lab5_2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.lab5_2 to javafx.fxml;
    exports com.example.lab5_2;
}