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
import sample.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
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
    private TextField insert;
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
            Cars car = CarsDAO.searchCar(regnr.getText());
            //Populate Employee on TableView and Display on TextArea
            populateAndShowCar(car);
        } catch (SQLException e) {
            e.printStackTrace();
            //resultArea.setText("Error occurred while getting employee information from DB.\n" + e);
            System.out.println("Error occurred while getting employee information from DB.\n" + e);
            System.out.println("Hip Huop.\n" + e);
            throw e;
        }
    }
    //Search all employees
    @FXML
    private void searchCars(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            //Get all Employees information
            ObservableList<Cars> carData = CarsDAO.searchCars();
            //Populate Employees on TableView
            populateCars(carData);
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
    private void populateCar (Cars car) throws ClassNotFoundException {
        //Declare and ObservableList for table view
        ObservableList<Cars> carData = FXCollections.observableArrayList();
        //Add employee to the ObservableList
        carData.add(car);
        //Set items to the employeeTable
        tableid.setItems(carData);
    }
    //Populate Employee for TableView and Display Employee on TextArea
    @FXML
    private void populateAndShowCar(Cars car) throws ClassNotFoundException {
        if (car != null) {
            populateCar(car);
            //setEmpInfoToTextArea(emp);
        } else {
        System.out.println("Dont exist");
        }
    }
    //Populate Employee
    @FXML
    private void populateCars (ObservableList<Cars> carData) throws ClassNotFoundException {

        //Set items to the employeeTable
        tableid.setItems(carData);
    }
    @FXML
    private void deleteCar (ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            //EmployeeDAO.deleteEmpWithId(empIdText.getText());
            CarsDAO.deleteCar(regnr.getText());

        } catch (SQLException e) {

            throw e;
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

    @FXML
    private void updateCar(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        System.out.println(regnr.getText());
        String[] collumnNames = {"merke", "modell", "eier", "årsmodell", "farge", "område", "tilgjenglig", "ledigdato", "regnr"};
        ResultSet rs = DBUtil.dbExecuteQuery("SELECT * from cars");

        if (Objects.equals(regnr.getText(), "")) {
            System.out.println("Du må skrive inn registreringsnummeret før du kan oppdatere biler.");
        } else {
            while (rs.next()) {
                if (!Objects.equals(rs.getString(collumnNames[0]), merkefelt.getText())) {CarsDAO.updateCarMerke(regnr.getText(), merkefelt.getText());}
                if (!Objects.equals(rs.getString(collumnNames[1]), modellfelt.getText())) {CarsDAO.updateCarModell(regnr.getText(), modellfelt.getText());}
                if (!Objects.equals(rs.getString(collumnNames[2]), eierfelt.getText())) {CarsDAO.updateCarEier(regnr.getText(), eierfelt.getText());}
                if (!Objects.equals(rs.getString(collumnNames[3]), årsmodellfelt.getText())) {CarsDAO.updateCarÅrsModell(regnr.getText(), Integer.parseInt(årsmodellfelt.getText()));}
                if (!Objects.equals(rs.getString(collumnNames[4]), fargefelt.getText())) {CarsDAO.updateCarFarge(regnr.getText(), fargefelt.getText());}
                if (!Objects.equals(rs.getString(collumnNames[5]), områdefelt.getText())) {CarsDAO.updateCarOmråde(regnr.getText(), områdefelt.getText());}
                if (!Objects.equals(rs.getString(collumnNames[6]), ledigfelt.getText())) {CarsDAO.updateCarLedig(regnr.getText(), ledigfelt.getText());}
                if (!Objects.equals(rs.getString(collumnNames[7]), ledigdatofelt.getText())) {CarsDAO.updateCarledigDato(regnr.getText(), ledigdatofelt.getText());}
                if (!Objects.equals(rs.getString(collumnNames[8]), regnr.getText())) {CarsDAO.updateCarRegnr(regnr.getText(), regnr.getText());}
            }

        }
    }


}


