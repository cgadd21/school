module com.example.m5sample5main9 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.m5sample7 to javafx.fxml;
    exports com.example.m5sample7;
}