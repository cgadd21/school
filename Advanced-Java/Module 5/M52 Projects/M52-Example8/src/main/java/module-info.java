module com.example.m52example8 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.m52example8 to javafx.fxml;
    exports com.example.m52example8;
}