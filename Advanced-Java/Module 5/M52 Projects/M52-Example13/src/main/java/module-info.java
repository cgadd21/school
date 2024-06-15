module com.example.m52example13 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.m52example13 to javafx.fxml;
    exports com.example.m52example13;
}