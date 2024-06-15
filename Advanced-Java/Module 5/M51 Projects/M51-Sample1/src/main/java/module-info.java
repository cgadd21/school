module com.example.m51sample1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.m51sample1 to javafx.fxml;
    exports com.example.m51sample1;
}