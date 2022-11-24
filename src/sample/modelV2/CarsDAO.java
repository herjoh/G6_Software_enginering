package sample.modelV2;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.model.Employee;
import sample.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CarsDAO {

    //*******************************
    //SELECT an Employee
    //*******************************
    public static Cars searchCar (String regnr) throws SQLException, ClassNotFoundException {
        //Declare a SELECT statement
        String selectStmt = "SELECT regnr FROM cars" ;

        //Execute SELECT statement
        try {
            //Get ResultSet from dbExecuteQuery method
            ResultSet rsEmp = DBUtil.dbExecuteQuery(selectStmt);

            //Send ResultSet to the getEmployeeFromResultSet method and get employee object
            Cars car = getCarFromResultSet(rsEmp);

            //Return employee object
            return car;
        } catch (SQLException e) {
            System.out.println("While searching an car with " + regnr + " id, an error occurred: " + e);
            //Return exception
            throw e;
        }
    }

    //Use ResultSet from DB as parameter and set Employee Object's attributes and return employee object.
    private static Cars getCarFromResultSet(ResultSet rs) throws SQLException
    {
        Cars car = null;
        if (rs.next()) {
            car = new Cars();
            car.setMerke(rs.getString("merke"));
            car.setModel(rs.getString("modell"));
            car.setEier(rs.getString("eier"));
            car.setÅrsmodel(rs.getInt("årsmodell"));
            car.setFarge(rs.getString("farge"));
            car.setOmråde(rs.getString("område"));
            car.setLedighet(rs.getBoolean("ledigdato"));
            car.setDato(rs.getString("dato"));
            car.setRegestreringsNummer(rs.getString("regnr"));

        }
        return car;
    }

    //*******************************
    //SELECT Employees
    //*******************************
    public static ObservableList<Cars> searchCars() throws SQLException, ClassNotFoundException {
        //Declare a SELECT statement
        String selectStmt = "SELECT * FROM cars";

        //Execute SELECT statement
        try {
            //Get ResultSet from dbExecuteQuery method
            ResultSet rsEmps = DBUtil.dbExecuteQuery(selectStmt);

            //Send ResultSet to the getEmployeeList method and get employee object
            ObservableList<Cars> carList = getCarList(rsEmps);

            //Return employee object
            return carList;
        } catch (SQLException e) {
            System.out.println("SQL select operation has been failed: " + e);
            //Return exception
            throw e;
        }
    }

    //Select * from cars operation
    private static ObservableList<Cars> getCarList(ResultSet rs) throws SQLException, ClassNotFoundException {
        //Declare a observable List which comprises of Employee objects
        ObservableList<Cars> carList = FXCollections.observableArrayList();

        while (rs.next()) {
            Cars car = new Cars();
            car.setMerke(rs.getString("Merke"));
            car.setModel(rs.getString("Modell"));
            car.setEier(rs.getString("Eier"));
            car.setÅrsmodel(rs.getInt("Årsmodel"));
            car.setFarge(rs.getString("Farge"));
            car.setOmråde(rs.getString("Område"));
            car.setLedighet(rs.getBoolean("Ledighet"));
            car.setDato(rs.getString("Dato"));
            car.setRegestreringsNummer(rs.getString("Regnummer"));

            //Add employee to the ObservableList
            carList.add(car);
        }
        //return empList (ObservableList of Employees)
        return carList;
    }
    //*************************************
    //DELETE an employee
    //*************************************
    public static void deleteCar (String regnr) throws SQLException, ClassNotFoundException {
        //Declare a DELETE statement
        String updateStmt =
                " DELETE FROM cars WHERE regnr ="+ regnr;
        //Testing placeholder string, for testing av ulike SQL insetninger
        String sql =
                "DELETE FROM cars WHERE farge = blaa";

        //Execute UPDATE operation
        try {
            DBUtil.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Error occurred while DELETE Operation: " + e);
            throw e;
        }
    }
    public static void updateCarMerke (String regnr, String merke) throws SQLException, ClassNotFoundException {
        String updateStmt =
                "UPDATE cars SET merke  = ?  "
                        + "WHERE regnr = ?";
        DBUtil.dbPreparedStatementUpdateString(updateStmt,regnr,merke);
    }
    public static void updateCarModell (String regnr, String modell) throws SQLException, ClassNotFoundException {
        String updateStmt1 =
                "UPDATE cars SET modell = ?  "
                        + "WHERE regnr = ?";
        DBUtil.dbPreparedStatementUpdateString(updateStmt1,regnr,modell);
    }
    public static void updateCarEier (String regnr, String eier) throws SQLException, ClassNotFoundException {
        String updateStmt1 =
                "UPDATE cars SET eier = ?  "
                        + "WHERE regnr = ?";
        DBUtil.dbPreparedStatementUpdateString(updateStmt1,regnr,eier);
    }
    public static void updateCarFarge (String regnr, String farge) throws SQLException, ClassNotFoundException {
        String updateStmt1 =
                "UPDATE cars SET farge = ?  "
                        + "WHERE regnr = ?";
        DBUtil.dbPreparedStatementUpdateString(updateStmt1,regnr,farge);
    }
    public static void updateCarOmråde (String regnr, String område) throws SQLException, ClassNotFoundException {
        String updateStmt1 =
                "UPDATE cars SET område = ?  "
                        + "WHERE regnr = ?";
        DBUtil.dbPreparedStatementUpdateString(updateStmt1,regnr,område);
    }

    public static void updateCarledigDato (String regnr, String ledigDato) throws SQLException, ClassNotFoundException {
        String updateStmt1 =
                "UPDATE cars SET  = ?  "
                        + "WHERE regnr = ?";
        DBUtil.dbPreparedStatementUpdateString(updateStmt1,regnr,ledigDato);
    }

    public static void updateCarLedig (String regnr, String ledig) throws SQLException, ClassNotFoundException {
        String updateStmt1 =
                "UPDATE cars SET regnr = ?  "
                        + "WHERE regnr = ?";
        DBUtil.dbPreparedStatementUpdateString(updateStmt1,regnr,ledig);
    }

    public static void updateCarÅrsModell (String regnr, int årsModell) throws SQLException, ClassNotFoundException {
        String updateStmt1 =
                "UPDATE cars SET årsmodell  = ?  "
                        + "WHERE regnr = ?";
        DBUtil.dbPreparedStatementUpdateInt(updateStmt1,regnr,årsModell);
    }

    public static void updateCarRegnr (String regnr, String nyReg) throws SQLException, ClassNotFoundException {
        String updateStmt1 =
                "UPDATE cars SET regnr = ?  "
                        + "WHERE regnr = ?";
        DBUtil.dbPreparedStatementUpdateString(updateStmt1,regnr,nyReg);
    }
    //*************************************
    //INSERT an employee
    //*************************************
    public static void insertCar (String merke, String modell, String eier, Integer årsmodel, String farge, String område,
                                  String ledighet, String dato, String regestreringsNummer ) throws SQLException, ClassNotFoundException {
        //Declare a DELETE statement
        String updateStmt =
                        "INSERT INTO cars (merke, modell, eier, årsmodell, farge, område, tilgjenglig, ledigdato, regnr) VALUES ('"+merke+"', '"+modell+"','"+eier+"','"+årsmodel+"','"+farge+"','"+område+"','"+ledighet+"', '"+dato+"','"+regestreringsNummer+"')";

        //Execute DELETE operation
        try {
            DBUtil.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Error occurred while DELETE Operation: " + e);
            throw e;
        }
    }
}
