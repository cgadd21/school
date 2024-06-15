module com.example.m53example5 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.m53example5 to javafx.fxml;
    exports com.example.m53example5;
}