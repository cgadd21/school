module com.example.m52example3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.m52example3 to javafx.fxml;
    exports com.example.m52example3;
}