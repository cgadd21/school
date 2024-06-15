module com.example.m42 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.m42 to javafx.fxml;
    exports com.example.m42;
}