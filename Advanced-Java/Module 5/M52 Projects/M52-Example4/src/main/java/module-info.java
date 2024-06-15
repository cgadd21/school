module com.example.m52example4 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.m52example4 to javafx.fxml;
    exports com.example.m52example4;
}