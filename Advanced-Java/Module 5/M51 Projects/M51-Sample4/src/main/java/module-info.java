module com.example.m51sample4 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.m51sample4 to javafx.fxml;
    exports com.example.m51sample4;
}