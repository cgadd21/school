module com.example.m53example4 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.m53example4 to javafx.fxml;
    exports com.example.m53example4;
}