module com.example.m53example6 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.m53example6 to javafx.fxml;
    exports com.example.m53example6;
}