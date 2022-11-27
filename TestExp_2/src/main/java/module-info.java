module com.example.g6brombrom {
    requires javafx.controls;
    requires javafx.fxml;
            
        requires org.controlsfx.controls;
            requires com.dlsc.formsfx;
                requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires java.sql.rowset;
    requires org.junit.jupiter.api;
    requires org.junit.jupiter.params;

    opens com.example.g6brombrom to javafx.fxml;
    exports com.example.g6brombrom;
}