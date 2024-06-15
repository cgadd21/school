module com.example.m52example11 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.m52example11 to javafx.fxml;
    exports com.example.m52example11;
}