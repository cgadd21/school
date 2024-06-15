module com.example.m5sample2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.m5sample2 to javafx.fxml;
    exports com.example.m5sample2;
}