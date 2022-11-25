module com.example.g6_software_engineringnynynynynynygui {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.sql;
    requires java.sql.rowset;

    opens com.example.g6_software_engineringnynynynynynygui to javafx.fxml;
    //exports com.example.g6_software_engineringnynynynynynygui;
}