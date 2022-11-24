package sample.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import sample.model.Employee;
import sample.model.EmployeeDAO;
import sample.modelV2.Cars;
import sample.modelV2.CarsDAO;

import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

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
    private TableView tableid;
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

    //Search an employee
    @FXML
    private void searchCar (ActionEvent actionEvent) throws ClassNotFoundException, SQLException {
        try {
            //Get Employee information

            Cars emp = CarsDAO.searchCar(regnr.getText());
            //Populate Employee on TableView and Display on TextArea
            populateAndShowEmployee(emp);
        } catch (SQLException e) {
            e.printStackTrace();
            //resultArea.setText("Error occurred while getting employee information from DB.\n" + e);
            throw e;
        }
    }
    //Search all employees
    @FXML
    private void searchCars(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            //Get all Employees information
            ObservableList<Cars> empData = CarsDAO.searchCars();
            //Populate Employees on TableView
            populateCarsTabele(empData);
        } catch (SQLException e){
            System.out.println("Error occurred while getting employees information from DB.\n" + e);
            throw e;
        }
    }
    private void fillCarsTable(ActionEvent event) throws SQLException, ClassNotFoundException {
        Task<List<Cars>> task = new Task<List<Cars>>(){
            @Override
            public ObservableList<Cars> call() throws Exception{

                return CarsDAO.searchCars();
            }
        };

        task.setOnFailed(e-> task.getException().printStackTrace());
        task.setOnSucceeded(e-> tableid.setItems((ObservableList<Cars>) task.getValue()));
        exec.execute(task);
    }
    //Populate cars for TableView
    @FXML
    private void populateCarsTabele (ObservableList<Cars> empData) throws ClassNotFoundException {
        //Set items to the employeeTable
        tableid.setItems(empData);
    }
    //Delete an employee with a given employee Id from DB
    @FXML
    private void deleteCar (ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            //EmployeeDAO.deleteEmpWithId(empIdText.getText());
            CarsDAO.deleteCar(regnr.getText());

        } catch (SQLException e) {

            throw e;
        }
    }
    //Populate Employee
    @FXML
    private void populateCars (Cars emp) throws ClassNotFoundException {
        //Declare and ObservableList for table view
        ObservableList<Cars> empData = FXCollections.observableArrayList();
        //Add employee to the ObservableList
        empData.add(emp);
        //Set items to the employeeTable
        tableid.setItems(empData);
    }
    //Populate Employee for TableView and Display Employee on TextArea
    @FXML
    private void populateAndShowEmployee(Cars emp) throws ClassNotFoundException {
        if (emp != null) {
            populateCars(emp);
            //setEmpInfoToTextArea(emp);
        } else {

        }
    }


    //Insert an car to the DB
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


