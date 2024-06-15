module com.example.m53example3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.m53example3 to javafx.fxml;
    exports com.example.m53example3;
}