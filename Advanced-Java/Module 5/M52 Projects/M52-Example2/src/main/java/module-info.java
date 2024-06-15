module com.example.m52example2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.m52example2 to javafx.fxml;
    exports com.example.m52example2;
}