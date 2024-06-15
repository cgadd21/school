module com.example.m52example10 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.m52example10 to javafx.fxml;
    exports com.example.m52example10;
}