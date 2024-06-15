module com.example.m52example7 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.m52example7 to javafx.fxml;
    exports com.example.m52example7;
}