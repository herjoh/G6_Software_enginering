package sample.modelV2;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CarsDAO {

    //*******************************
    //SELECT an Employee
    //*******************************
    public static ObservableList<Cars> searchCar (String regNr) throws SQLException, ClassNotFoundException {
        //Declare a SELECT statement
        String selectStmt = "SELECT * FROM cars WHERE regnr="+regNr;

        //Execute SELECT statement
        try {
            //Get ResultSet from dbExecuteQuery method
            ResultSet rsEmp = DBUtil.dbExecuteQuery(selectStmt);

            //Send ResultSet to the getEmployeeFromResultSet method and get employee object
            ObservableList<Cars> car = (ObservableList<Cars>) getCarFromResultSet(rsEmp);

            //Return employee object
            return null;
        } catch (SQLException e) {
            System.out.println("While searching an employee with " + regNr + " id, an error occurred: " + e);
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
            car.setMerke(rs.getString("Merke"));
            car.setModel(rs.getString("Modell"));
            car.setEier(rs.getString("Eier"));
            car.setÅrsmodel(rs.getInt("Årsmodel"));
            car.setFarge(rs.getString("Farge"));
            car.setOmråde(rs.getString("Område"));
            car.setLedighet(rs.getBoolean("Ledighet"));
            car.setDato(rs.getString("Dato"));
            car.setRegestreringsNummer(rs.getString("Regnummer"));

        }
        return car;
    }

    //*******************************
    //SELECT Employees
    //*******************************
    public static ObservableList<Cars> searchEier () throws SQLException, ClassNotFoundException {
        //Declare a SELECT statement
        String selectStmt = "SELECT * FROM cars";

        //Execute SELECT statement
        try {
            //Get ResultSet from dbExecuteQuery method
            ResultSet rsEmps = DBUtil.dbExecuteQuery(selectStmt);

            //Send ResultSet to the getEmployeeList method and get employee object
            ObservableList<Cars> empList = getCarList(rsEmps);

            //Return employee object
            return empList;
        } catch (SQLException e) {
            System.out.println("SQL select operation has been failed: " + e);
            //Return exception
            throw e;
        }
    }

    //Select * from cars operation
    private static ObservableList<Cars> getCarList(ResultSet rs) throws SQLException, ClassNotFoundException {
        //Declare a observable List which comprises of Employee objects
        ObservableList<Cars> empList = FXCollections.observableArrayList();

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
            empList.add(car);
        }
        //return empList (ObservableList of Employees)
        return empList;
    }
    //*************************************
    //DELETE an employee
    //*************************************
    public static void deleteCar (String regnr) throws SQLException, ClassNotFoundException {
        //Declare a DELETE statement
        String updateStmt =
                " DELETE FROM cars WHERE regnr ="+ regnr;
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
    //*************************************
    //UPDATE an employee's email address
    //*************************************
    public static void updateCarEier (String regnr, String tilgjengelig) throws SQLException, ClassNotFoundException {
        //Declare a UPDATE statement
        String updateStmt1 =
                "UPDATE cars SET eier = ?  "
                        + "WHERE regnr = ?";
        DBUtil.dbPreparedStatementUpdate(updateStmt1,regnr,tilgjengelig);
       /*/ PreparedStatement stmt = DBUtil.getConn().prepareStatement(updateStmt1);
        stmt.setBoolean(1,tilgjengelig);
        stmt.setString(2,regnr);
        DBUtil.dbPreparedStatementUpdate(stmt);/*/

        //Execute UPDATE operation
        /*/try {
            DBUtil.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Error occurred while UPDATE Operation: " + e);
            throw e;
        }/*/
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
