package com.example.g6brombrom;


import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import com.example.g6brombrom.HelloApplication;

public class HelloController {

    /*//Reference to the main application
    private Sample.Main main;

    //Is called by the main application to give a reference back to itself.
    public void setMain (Sample.Main main) {
        this.main = main;
    }*/

    //Exit the program
    public void handleExit(ActionEvent actionEvent) {
        System.exit(0);
    }

    //Help Menu button behavior
    public void handleHelp(ActionEvent actionEvent) {
        Alert alert = new Alert (Alert.AlertType.INFORMATION);
        alert.setTitle("Program Information");
        alert.setHeaderText("This is a sample JAVAFX application for SWTESTACADEMY!");
        alert.setContentText("You can search, delete, update, insert a new employee with this program.");
        alert.show();
    }
}