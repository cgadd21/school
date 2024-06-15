module com.example.m5sample6main10 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.m5sample8 to javafx.fxml;
    exports com.example.m5sample8;
}