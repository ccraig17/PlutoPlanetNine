module com.example.plutoplanetnine {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    requires org.controlsfx.controls;

    opens com.example.plutoplanetnine to javafx.fxml;
    exports com.example.plutoplanetnine;
}