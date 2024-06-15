module com.example.fxdemo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.m41 to javafx.fxml;
    exports com.example.m41;
}