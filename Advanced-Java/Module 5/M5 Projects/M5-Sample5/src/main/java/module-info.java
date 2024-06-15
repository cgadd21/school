module com.example.m5sample5main5 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.m5sample5 to javafx.fxml;
    exports com.example.m5sample5;
}