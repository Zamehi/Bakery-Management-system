package BL;
import DB_handler.database_connection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Discount
{
    int productId;
    int amount;
    String startTime;
    String endTime;


    // ------------ 1. FLAT DISCOUNT ------------
    public void setFlatDiscount(int discount, String startTime, String endTime) throws SQLException
    {
       // String sql = "SET SQL_SAFE_UPDATES = 0";
        String sql = " UPDATE itemdiscount SET amount = '" + discount + "', startTime = '"+ startTime+ "' , endTime = '"+ endTime+"' ";
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
            System.out.println("Exception while setting Flat Discount");
            e.printStackTrace();
            throw e;
        }

    }

    // ------------ 2. RESET DISOUNT ------------
    public void resetDiscount() throws SQLException
    {
        String sql = "UPDATE itemdiscount SET amount = CONCAT('', 0), startTime = '0000-00-00 00:00:00', endTime = '0000-00-00 00:00:00'";

       // String sql = "UPDATE itemdiscount SET amount = '" + 0 + "', startTime = '"+ '0000-00-00 00:00:00'+ "' , endTime = '"+ '0000-00-00 00:00:00';
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
            System.out.println("Exception while resetting Discount");
            e.printStackTrace();
            throw e;
        }

    }

    // ------------ 3.  SET DISOUNT ------------
    public void onSetDiscount (int discount, int itemID, String startTime, String endTime) throws SQLException
    {
        String sql = "UPDATE itemdiscount SET amount = '" + discount + "', startTime = '"+ startTime+ "' , endTime = '"+ endTime +"'where productID = '"+ itemID +"' ";
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
            System.out.println("Exception while setting Discount");
            e.printStackTrace();
            throw e;
        }
    }

    // ---------------- DISPLAY DISCOUNTS ------------------
    public ObservableList<Zdiscount> getAllRecords() throws SQLException
    {
        DB_handler.database_connection connection = new database_connection(); // making object of databse class
        Connection connectDB = connection.getConnection();             // returning connection from function of object of the class

        String sql = "SELECT* FROM itemdiscount";

        try
        {
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(sql);  // verifying login

            // getEmployeeObjects is a function
            ObservableList <Zdiscount> empList = getEmployeeObjects(queryResult);
            return empList;


        }
        catch(Exception e)
        {
            System.out.println("Exception occurred");
            e.printStackTrace();
            throw e;
        }

    }

    private static ObservableList<Zdiscount> getEmployeeObjects(ResultSet queryResult) throws SQLException
    {
        try
        {
            ObservableList<Zdiscount> empList = FXCollections.observableArrayList();
            while (queryResult.next())
            {
                Zdiscount emp = new Zdiscount();
                emp.setProductId(queryResult.getInt("productID"));
                emp.setAmount(queryResult.getInt("amount"));
                emp.setStartTime(queryResult.getString("startTime"));
                emp.setEndTime(queryResult.getString("endTime"));
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
