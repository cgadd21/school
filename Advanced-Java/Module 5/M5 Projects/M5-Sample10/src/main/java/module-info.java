module com.example.m5sample6main12 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.m5sample10 to javafx.fxml;
    exports com.example.m5sample10;
}