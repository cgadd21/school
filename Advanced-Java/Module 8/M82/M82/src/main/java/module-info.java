module com.example.m82 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.m82 to javafx.fxml;
    exports com.example.m82;
}