module com.example.m5sample {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.m5sample to javafx.fxml;
    exports com.example.m5sample;
}