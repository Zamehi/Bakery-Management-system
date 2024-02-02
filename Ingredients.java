package BL;

import DB_handler.database_connection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ingredients
{
    String name;
    int id ;
    int quantity;
    String arrivalStatus;

    public Ingredients(String name, int id, int quantity, String arrivalStatus) {
        this.name = name;
        this.id = id;
        this.quantity = quantity;
        this.arrivalStatus = arrivalStatus;
    }
    public Ingredients() 
    {
        this.name = "";
        this.id = -1;
        this.quantity = 0;
        this.arrivalStatus = "";
    }

    // ------------- CRUD OPERATIONS ------------


    // ---------- 1. INSERT SALES ----------
    public void addSales(int id, String name, int revenue, String month) throws SQLException
    {
        // QUERY
        String sql = "INSERT into ingredients (ID, name, quantity, status) values ('"+ id +"', '"+ name +"', '"+ revenue +"', '"+ month +"')";
        DB_handler.database_connection connection = new database_connection(); // making object of database class
        Connection connectDB = connection.getConnection();             // returning connection from function of object of the class
        Statement statement = connectDB.createStatement();

        try
        {

            int queryResult = statement.executeUpdate(sql);  // inserting
        }
        catch(Exception e)
        {
            System.out.println("Exception occurred");
            e.printStackTrace();
            throw e;
        }

    }

    // ---------- 2. UPDATE SALES ----------
    public void updateSales(int id, String budget) throws SQLException
    {
        String sql = "UPDATE ingredients SET status = '" + budget + "' where ID = '"+ id +"' ";
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

    // ----------- 3. DELETE SALES ----------
    @FXML
    public void deleteSales(int id) throws SQLException
    {
        String sql = "DELETE from ingredients where ID = '"+ id +"' ";
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

    // ----------- 4. DISPLAY SALES ------------

    public ObservableList<Zingredients> getAllRecords() throws SQLException
    {
        DB_handler.database_connection connection = new database_connection(); // making object of databse class
        Connection connectDB = connection.getConnection();             // returning connection from function of object of the class

        String sql = "SELECT* FROM ingredients";

        try
        {
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(sql);  // verifying login

            // getEmployeeObjects is a function
            ObservableList <Zingredients> empList = getEmployeeObjects(queryResult);
            return empList;


        }
        catch(Exception e)
        {
            System.out.println("Exception occurred");
            e.printStackTrace();
            throw e;
        }

    }

    private static ObservableList<Zingredients> getEmployeeObjects(ResultSet queryResult) throws SQLException {
        try
        {
            ObservableList<Zingredients> empList = FXCollections.observableArrayList();
            while (queryResult.next())
            {
                Zingredients emp = new Zingredients();
                emp.setId(queryResult.getInt("ID"));
                emp.setName(queryResult.getString("name"));
                emp.setQuantity(queryResult.getInt("quantity"));
                emp.setStatus(queryResult.getString("status"));
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


    // ---------- SEARCH SALES  ----------
    public ObservableList<Zingredients> searchsales(int id) throws SQLException
    {
        DB_handler.database_connection connection = new database_connection(); // making object of databse class
        Connection connectDB = connection.getConnection();             // returning connection from function of object of the class
        String sql = "SELECT * FROM ingredients WHERE ID = "+ id;

        try
        {
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(sql);  // verifying login


            // getEmployeeObjects is a function
            ObservableList <Zingredients> empList = getEmployeeObjects(queryResult);
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




