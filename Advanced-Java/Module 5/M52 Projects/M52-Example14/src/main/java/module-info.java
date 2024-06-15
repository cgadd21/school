module com.example.m52example14 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.m52example14 to javafx.fxml;
    exports com.example.m52example14;
}