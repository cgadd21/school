module com.example.m51sample6 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.m51sample6 to javafx.fxml;
    exports com.example.m51sample6;
}