module com.example.m51sample2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.m51sample2 to javafx.fxml;
    exports com.example.m51sample2;
}