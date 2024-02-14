module org.example.ratioedt {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.ratioedt to javafx.fxml;
    exports org.example.ratioedt;
}