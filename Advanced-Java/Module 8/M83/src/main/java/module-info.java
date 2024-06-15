module com.example.m83new {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.m83new to javafx.fxml;
    exports com.example.m83new;
}