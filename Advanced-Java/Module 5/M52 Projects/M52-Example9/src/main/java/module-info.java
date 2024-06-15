module com.example.m52example9 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.m52example9 to javafx.fxml;
    exports com.example.m52example9;
}