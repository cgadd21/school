module com.example.m51sample5 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.m51sample5 to javafx.fxml;
    exports com.example.m51sample5;
}