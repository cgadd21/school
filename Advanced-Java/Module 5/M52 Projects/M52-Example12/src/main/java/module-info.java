module com.example.m52example12 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.m52example12 to javafx.fxml;
    exports com.example.m52example12;
}