package sample.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import sample.model.Employee;
import sample.model.EmployeeDAO;
import sample.modelV2.Cars;
import sample.modelV2.CarsDAO;
import sample.util.DBUtil;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import java.awt.*;

public class GuiController {

    @FXML
    private TextField merkefelt;
    @FXML
    private TextField modellfelt;
    @FXML
    private TextField eierfelt;
    @FXML
    private TextField årsmodellfelt;
    @FXML
    private TextField fargefelt;
    @FXML
    private TextField områdefelt;
    @FXML
    private TextField ledigfelt;
    @FXML
    private TextField ledigdatofelt;
    @FXML
    private TextField regnr;
    @FXML
    private TableColumn <Cars, String>  merkeIdColum;
    @FXML
    private TableColumn <Cars, String>  modelIdColum;
    @FXML
    private TableColumn <Cars, String>  eierIdColum;
    @FXML
    private TableColumn <Cars, Integer>  årsmodelIdColumn;
    @FXML
    private TableColumn <Cars, String>  fargeIdColumn;
    @FXML
    private TableColumn <Cars, String>  områdeIdColumn;
    @FXML
    private TableColumn <Cars, Boolean>  ledigIdColumn;
    @FXML
    private TableColumn <Cars, String>  datoIdColumn;
    @FXML
    private TableColumn <Cars, String>  regnrIdColumn;

    //For MultiThreading
    private Executor exec;


    @FXML
    private void initialize () {
        /*
        The setCellValueFactory(...) that we set on the table columns are used to determine
        which field inside the Employee objects should be used for the particular column.
        The arrow -> indicates that we're using a Java 8 feature called Lambdas.
        (Another option would be to use a PropertyValueFactory, but this is not type-safe

        We're only using StringProperty values for our table columns in this example.
        When you want to use IntegerProperty or DoubleProperty, the setCellValueFactory(...)
        must have an additional asObject():
        */

        //For multithreading: Create executor that uses daemon threads:
        exec = Executors.newCachedThreadPool((runnable) -> {
            Thread t = new Thread (runnable);
            t.setDaemon(true);
            return t;
        });

        merkeIdColum.setCellValueFactory(cellData -> cellData.getValue().merkeProperty());
        modelIdColum.setCellValueFactory(cellData -> cellData.getValue().modelProperty());
        eierIdColum.setCellValueFactory(cellData -> cellData.getValue().eierProperty());
        årsmodelIdColumn.setCellValueFactory(cellData -> cellData.getValue().årsmodelProperty().asObject());
        fargeIdColumn.setCellValueFactory(cellData -> cellData.getValue().fargeProperty());
        områdeIdColumn.setCellValueFactory(cellData -> cellData.getValue().områdeProperty());
        ledigIdColumn.setCellValueFactory(cellData -> cellData.getValue().ledighetProperty().asObject());
        datoIdColumn.setCellValueFactory(cellData -> cellData.getValue().datoProperty());
        regnrIdColumn.setCellValueFactory(cellData -> cellData.getValue().regestreringsNummerProperty());
        }




    //Insert an employee to the DB
    @FXML
    private void insertCar (ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            CarsDAO.insertCar(merkefelt.getText(),modellfelt.getText(),eierfelt.getText(),
                    årsmodellfelt.getAnchor(),fargefelt.getText(),områdefelt.getText(),
                    ledigfelt.getText(),ledigdatofelt.getText(),regnr.getText());

        } catch (SQLException e) {

            throw e;
        }
    }

}


