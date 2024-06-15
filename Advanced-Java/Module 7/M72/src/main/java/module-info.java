module com.example.m72 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.m72 to javafx.fxml;
    exports com.example.m72;
}