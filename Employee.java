package BL;

import DB_handler.database_connection;
import com.almasb.fxgl.core.collection.Array;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.sql.*;

import java.util.ArrayList;

public class Employee
{
    int E_ID;
    String Employee_name;
    int work_hours;
    int salary;

    // ------------- CONSTRUCTORS ------------
    public Employee()
    {
        this.E_ID= 0;this.Employee_name= "";this.work_hours=0;this.salary= 0;
    }
    public Employee(int eId, String employeeName, int workHours, int salary)
    {
        this.E_ID= eId;this.Employee_name= employeeName;this.work_hours= workHours;this.salary= salary;
    }


    // -------------    GETTERS    ------------
    public int getE_ID()
    {
        return this.E_ID;
    }
    public String getName()
    {
        return this.Employee_name;
    }
    public int getWork_hours()
    {
        return this.work_hours;
    }
    public int getSalary()
    {
        return this.salary;
    }



    // ------------- CRUD OPERATIONS ------------


    // ---------- 1. INSERT EMPLOYEE ----------
    public void addEmployee(int id, String name, int workHours, int salary) throws SQLException {
        // QUERY
        String sql = "INSERT into EMPLOYEE (Employee_id, Employee_name, salary, work_hours) values ('"+ id +"', '"+ name +"', '"+ salary +"', '"+ workHours +"' )";
        DB_handler.database_connection connection = new database_connection(); // making object of database class
        Connection connectDB = connection.getConnection();             // returning connection from function of object of the class
        Statement statement = connectDB.createStatement();
        String sql2 = "INSERT into kitchen_status (EmpId) values ('"+ id +"')";

        try
        {

            int queryResult = statement.executeUpdate(sql);  // inserting
            int queryResult2 = statement.executeUpdate(sql2);  // inserting
        }
        catch(Exception e)
        {
            System.out.println("Exception occurred");
            e.printStackTrace();
            throw e;
        }

    }

    // ---------- 2. UPDATE EMPLOYEE ----------
    public void updateEmployee(int id, int salary) throws SQLException
    {
        String sql = "UPDATE employee SET salary = '" + salary + "' where Employee_id = '"+ id +"' ";
        DB_handler.database_connection connection = new database_connection(); // making object of database class
        Connection connectDB = connection.getConnection();             // returning connection from function of object of the class
        Statement statement = connectDB.createStatement();

        try
        {
            //ResultSet queryResult = statement.executeQuery(sql);  // inserting
            int queryResult = statement.executeUpdate(sql);

        }
        catch(Exception e)
        {
            System.out.println("Exception occurred");
            e.printStackTrace();
            throw e;
        }
    }

    // ----------- 3. DELETE EMPLOYEE ----------
    @FXML
    public void deleteEmployee(int id) throws SQLException
    {
        String sql = "DELETE from employee where Employee_id = '"+ id +"' ";
        DB_handler.database_connection connection = new database_connection(); // making object of database class
        Connection connectDB = connection.getConnection();                     // returning connection from function of object of the class
        Statement statement = connectDB.createStatement();

        try
        {
            int queryResult = statement.executeUpdate(sql);
            //ResultSet queryResult = statement.executeQuery(sql);  // inserting
        }
        catch(Exception e)
        {
            System.out.println("Exception occurred");
            e.printStackTrace();
            throw e;
        }
    }

    // ----------- 4. DISPLAY EMPLOYEE ----------

    public ObservableList<Zemployee> getAllRecords() throws SQLException
    {
        DB_handler.database_connection connection = new database_connection(); // making object of databse class
        Connection connectDB = connection.getConnection();             // returning connection from function of object of the class

        String sql = "SELECT* FROM employee";

        try
        {
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(sql);  // verifying login

            // getEmployeeObjects is a function
            ObservableList <Zemployee> empList = getEmployeeObjects(queryResult);
            return empList;


        }
        catch(Exception e)
        {
            System.out.println("Exception occurred");
            e.printStackTrace();
            throw e;
        }

    }

    private static ObservableList<Zemployee> getEmployeeObjects(ResultSet queryResult) throws SQLException {
        try
        {
            ObservableList<Zemployee> empList = FXCollections.observableArrayList();
            while (queryResult.next())
            {
                Zemployee emp = new Zemployee();
                emp.setId(queryResult.getInt("Employee_id"));
                emp.setName(queryResult.getString("Employee_name"));
                emp.setSalary(queryResult.getInt("salary"));
                emp.setWorkHours(queryResult.getInt("work_hours"));
                empList.add(emp);
            }
            // store data from database in object
            return empList;

        }
        catch (Exception e)
        {
            System.out.println("Exception occurred while employee");
            e.printStackTrace();
            throw e;

        }

    }


    // ---------- SEARCH EMPLOYEE ----------
    public ObservableList<Zemployee> searchEmployee(int id) throws SQLException
    {
        DB_handler.database_connection connection = new database_connection(); // making object of databse class
        Connection connectDB = connection.getConnection();             // returning connection from function of object of the class
        String sql = "SELECT * FROM employee WHERE Employee_id = "+ id;

        try
        {
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(sql);  // verifying login


            // getEmployeeObjects is a function
            ObservableList <Zemployee> empList = getEmployeeObjects(queryResult);
            return empList;

        }
        catch(Exception e )
        {
            System.out.println("Exception occurred");
            e.printStackTrace();
            throw e;
        }
    }

}
