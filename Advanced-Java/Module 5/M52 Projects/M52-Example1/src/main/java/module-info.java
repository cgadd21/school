module com.example.m52example1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.m52example1 to javafx.fxml;
    exports com.example.m52example1;
}