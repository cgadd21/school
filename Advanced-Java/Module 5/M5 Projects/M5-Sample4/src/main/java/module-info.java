module com.example.m5sample4 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.m5sample4 to javafx.fxml;
    exports com.example.m5sample4;
}