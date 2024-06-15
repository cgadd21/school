module com.example.m5sample5main7 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.m5sample6 to javafx.fxml;
    exports com.example.m5sample6;
}