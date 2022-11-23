package sample.modelV2;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.model.Employee;
import sample.util.DBUtil;

import java.sql.PreparedStatement;
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
            ObservableList<Cars> car = getCarFromResultSet(rsEmp);

            //Return employee object
            return null;
        } catch (SQLException e) {
            System.out.println("While searching an employee with " + regNr + " id, an error occurred: " + e);
            //Return exception
            throw e;
        }
    }

    //Use ResultSet from DB as parameter and set Employee Object's attributes and return employee object.
    private static ObservableList<Cars> getCarFromResultSet(ResultSet rs) throws SQLException
    {
        ObservableList<Cars> empList = FXCollections.observableArrayList();

        while (rs.next()) {
            Cars emp = new Cars();
            emp.setMerke(rs.getString("merke"));
            emp.setModell(rs.getString("modell"));
            emp.setEier(rs.getString("eier"));
            emp.setÅrsmodel(rs.getInt("årsmodell"));
            emp.setFarge(rs.getString("farge"));
            emp.setOmråde(rs.getString("område"));
            emp.setTilgjenglig(rs.getBoolean("tilgjengelig"));
            emp.setLedigdatoDato(rs.getString("ledigdato"));
            emp.setRegnr(rs.getString("regnr"));

            empList.add(emp);
        }
        return empList;
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
            ObservableList<Cars> empList = getCarList(rsEmps);

            //Return employee object
            return empList;
        } catch (SQLException e) {
            System.out.println("SQL select operation has been failed: " + e);
            //Return exception
            throw e;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    //Select * from employees operation
    private static ObservableList<Cars> getCarList(ResultSet rs) throws SQLException, ClassNotFoundException {
        //Declare a observable List which comprises of Employee objects
        ObservableList<Cars> empList = FXCollections.observableArrayList();

        while (rs.next()) {
            Cars emp = new Cars();
            emp.setMerke(rs.getString("merke"));
            emp.setModell(rs.getString("modell"));
            emp.setEier(rs.getString("eier"));
            emp.setÅrsmodel(rs.getInt("årsmodell"));
            emp.setFarge(rs.getString("farge"));
            emp.setOmråde(rs.getString("område"));
            emp.setTilgjenglig(rs.getBoolean("tilgjengelig"));
            emp.setLedigdatoDato(rs.getString("ledigdato"));
            emp.setRegnr(rs.getString("regnr"));
            //Add employee to the ObservableList
            empList.add(emp);
        }
        //return empList (ObservableList of Employees)
        return empList;
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
    //DELETE an employee
    //*************************************
    public static void deleteEmpWithId (String empId) throws SQLException, ClassNotFoundException {
        //Declare a DELETE statement
        String updateStmt =
                "BEGIN\n" +
                        "   DELETE FROM employees\n" +
                        "         WHERE employee_id ="+ empId +";\n" +
                        "   COMMIT;\n" +
                        "END;";

        //Execute UPDATE operation
        try {
            DBUtil.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Error occurred while DELETE Operation: " + e);
            throw e;
        }
    }

    //*************************************
    //INSERT an employee
    //*************************************
    public static void insertEmp (String name, String lastname, String email) throws SQLException, ClassNotFoundException {
        //Declare a DELETE statement
        String updateStmt =
                "BEGIN\n" +
                        "INSERT INTO employees\n" +
                        "(EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL, HIRE_DATE, JOB_ID)\n" +
                        "VALUES\n" +
                        "(sequence_employee.nextval, '"+name+"', '"+lastname+"','"+email+"', SYSDATE, 'IT_PROG');\n" +
                        "END;";

        //Execute DELETE operation
        try {
            DBUtil.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Error occurred while DELETE Operation: " + e);
            throw e;
        }
    }
}