package BL;

import DB_handler.database_connection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import java.sql.*;

public class Kitchen
{
    String Status;
    int request;
    int empID;


    // ---------- 2. UPDATE EMPLOYEE ----------
    public int updateEmployee(int id) throws SQLException

    {
        int numberOfRequests = 0;
        String sql = "UPDATE kitchen_status SET request = request + 1 WHERE empID = '" + id + "'";
        //String sql = "UPDATE kitchen_status SET request = request '" + +1 + "' where Employee_id = '"+ id +"' ";
        DB_handler.database_connection connection = new database_connection(); // making object of database class
        Connection connectDB = connection.getConnection();             // returning connection from function of object of the class
        Statement statement = connectDB.createStatement();

        try
        {

            int queryResult = statement.executeUpdate(sql);
            try
            {
                String sql2 = "SELECT COUNT(*) AS request FROM kitchen_status WHERE empID = '" + id + "'";


                try (PreparedStatement preparedStatement = connectDB.prepareStatement(sql2)) {
                   // preparedStatement.setString(1, employeeId);

                    try (ResultSet resultSet = preparedStatement.executeQuery())
                    {
                        if (resultSet.next()) {
                            numberOfRequests = resultSet.getInt("request");
                        }
                    }
                }


            }
            catch (SQLException e)
            {
                e.printStackTrace(); // Handle the exception appropriately
            }

        }
        catch(Exception e)
        {
            System.out.println("Exception occurred");
            e.printStackTrace();
            throw e;
        }
        return numberOfRequests;
    }

    // ----------- 3. DELETE EMPLOYEE ----------
    @FXML
    public void deleteEmployee(int id) throws SQLException
    {
        String sql = "DELETE from employee where Employee_id = '"+ id +"' ";
        String sql2 = "DELETE from kitchen_status where empID = '"+ id +"' ";
        DB_handler.database_connection connection = new database_connection(); // making object of database class
        Connection connectDB = connection.getConnection();                     // returning connection from function of object of the class
        Statement statement = connectDB.createStatement();

        try
        {
            int queryResult = statement.executeUpdate(sql);
            int queryResult2 = statement.executeUpdate(sql2);

        }
        catch(Exception e)
        {
            System.out.println("Exception occurred");
            e.printStackTrace();
            throw e;
        }
    }

    // ----------- 4. SEARCH EMPLOYEE ----------
    public ObservableList<Zkitchen> searchEmployee(int id) throws SQLException
    {
        DB_handler.database_connection connection = new database_connection(); // making object of databse class
        Connection connectDB = connection.getConnection();             // returning connection from function of object of the class
        String sql = "SELECT * FROM kitchen_status WHERE empID = "+ id;

        try
        {
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(sql);  // verifying login


            // getEmployeeObjects is a function
            ObservableList <Zkitchen> empList = getEmployeeObjects(queryResult);
            return empList;

        }
        catch(Exception e )
        {
            System.out.println("Exception occurred");
            e.printStackTrace();
            throw e;
        }
    }

    // ----------- 4. DISPLAY EMPLOYEE ----------

    public ObservableList<Zkitchen> getAllRecords() throws SQLException
    {
        DB_handler.database_connection connection = new database_connection(); // making object of databse class
        Connection connectDB = connection.getConnection();             // returning connection from function of object of the class

        String sql = "SELECT* FROM kitchen_status";

        try
        {
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(sql);  // verifying login

            // getEmployeeObjects is a function
            ObservableList <Zkitchen> empList = getEmployeeObjects(queryResult);
            return empList;


        }
        catch(Exception e)
        {
            System.out.println("Exception occurred");
            e.printStackTrace();
            throw e;
        }

    }

    private static ObservableList<Zkitchen> getEmployeeObjects(ResultSet queryResult) throws SQLException {
        try
        {
            ObservableList<Zkitchen> empList = FXCollections.observableArrayList();
            while (queryResult.next())
            {
                Zkitchen emp = new Zkitchen();
                emp.setId(queryResult.getInt("empID"));
                emp.setStatus(queryResult.getString("status"));
                emp.setRequest(queryResult.getInt("request"));
               // emp.setWorkHours(queryResult.getInt("work_hours"));
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


}
