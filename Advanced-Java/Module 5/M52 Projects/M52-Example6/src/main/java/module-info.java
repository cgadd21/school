module com.example.m52main6 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.m52example6 to javafx.fxml;
    exports com.example.m52example6;
}