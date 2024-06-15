module com.example.m53example2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.m53example2 to javafx.fxml;
    exports com.example.m53example2;
}