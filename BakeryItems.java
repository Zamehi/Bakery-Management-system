package BL;

import DB_handler.database_connection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BakeryItems
{
    int number;
    int quantity;
    //String review;
    String name;

    int price;
    int discount;

    public BakeryItems()
    {
        this.number = 0;
        this.quantity = 0;
        this.name = "";
        this.price = 0;
        this.discount = 0;
    }
    public BakeryItems(int number, int quantity, String name, int price, int discount)
    {
        this.number = number;
        this.quantity = quantity;
        this.name = name;
        this.price = price * (discount/100);
        this.discount = discount;
    }


    // ------------- CRUD OPERATIONS ------------


    // ---------- 1. INSERT SALES ----------
    public void addSales(int id, int budget, int revenue, String month, int year) throws SQLException
    {
        // QUERY
        String sql = "INSERT into Bakery_Items (productID, price, quantity, productName, discount) values ('"+ id +"', '"+ budget +"', '"+ revenue +"', '"+ month +"', '"+ year +"' )";
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
    public void updateSales(int id, int budget) throws SQLException
    {
        String sql = "UPDATE Bakery_Items SET quantity = '" + budget + "' where productID = '"+ id +"' ";
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
        String sql = "DELETE from Bakery_Items where productID = '"+ id +"' ";
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

    public ObservableList<ZbakeryItem> getAllRecords() throws SQLException
    {
        DB_handler.database_connection connection = new database_connection(); // making object of databse class
        Connection connectDB = connection.getConnection();             // returning connection from function of object of the class

        String sql = "SELECT* FROM Bakery_Items";

        try
        {
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(sql);  // verifying login

            // getEmployeeObjects is a function
            ObservableList <ZbakeryItem> empList = getEmployeeObjects(queryResult);
            return empList;


        }
        catch(Exception e)
        {
            System.out.println("Exception occurred");
            e.printStackTrace();
            throw e;
        }

    }

    private static ObservableList<ZbakeryItem> getEmployeeObjects(ResultSet queryResult) throws SQLException {
        try
        {
            ObservableList<ZbakeryItem> empList = FXCollections.observableArrayList();
            while (queryResult.next())
            {
                ZbakeryItem emp = new ZbakeryItem();
                emp.setId(queryResult.getInt("productID"));
                emp.getDiscount(queryResult.getInt("discount"));
                emp.setName(queryResult.getString("productName"));
                emp.setPrice(queryResult.getInt("price"));
                emp.setQuantity(queryResult.getInt("quantity"));
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
    public ObservableList<ZbakeryItem> searchsales(int id) throws SQLException
    {
        DB_handler.database_connection connection = new database_connection(); // making object of databse class
        Connection connectDB = connection.getConnection();             // returning connection from function of object of the class
        String sql = "SELECT * FROM Bakery_Items WHERE productID = "+ id;

        try
        {
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(sql);  // verifying login


            // getEmployeeObjects is a function
            ObservableList <ZbakeryItem> empList = getEmployeeObjects(queryResult);
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


