module com.example.m53example1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.m53example1 to javafx.fxml;
    exports com.example.m53example1;
}