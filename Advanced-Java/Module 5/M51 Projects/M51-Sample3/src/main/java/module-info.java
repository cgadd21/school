module com.example.m51sample3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.m51sample3 to javafx.fxml;
    exports com.example.m51sample3;
}