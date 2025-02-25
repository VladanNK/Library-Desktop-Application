module com.example.bibliotekainterfejs {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires com.google.gson;
    requires org.json;
    requires org.controlsfx.controls;


    opens com.example.bibliotekainterfejs to javafx.fxml;
    exports com.example.bibliotekainterfejs;
}