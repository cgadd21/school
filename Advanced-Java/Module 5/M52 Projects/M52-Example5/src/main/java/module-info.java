module com.example.m52example5 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.m52example5 to javafx.fxml;
    exports com.example.m52example5;
}