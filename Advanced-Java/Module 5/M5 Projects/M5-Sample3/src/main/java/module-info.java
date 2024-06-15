module com.example.m5sample3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.m5sample3 to javafx.fxml;
    exports com.example.m5sample3;
}