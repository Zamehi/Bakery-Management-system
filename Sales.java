package BL;

import DB_handler.database_connection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;

import java.sql.*;

public class Sales
{
    int sales_id;
    int budget;// expense ; profit = revenue - budget
    int revenue;
    String month;
    int year;
    public void displaySales()
    {

    }


    // --------------- 1. MAKE BARCHART --------------
    public void trackViaYear(int year, BarChart <String, Number> barChart) throws SQLException
    {
        String sql = "SELECT month , revenue FROM sales WHERE year = "+ year;
        DB_handler.database_connection connection = new database_connection(); // making object of database class
        Connection connectDB = connection.getConnection();                     // returning connection from function of object of the class
        Statement statement = connectDB.createStatement();
        try
        {

            ResultSet resultSet = statement.executeQuery(sql);


                XYChart.Series<String, Number> series = new XYChart.Series<>();

                while (resultSet.next())
                {
                    String month = resultSet.getString("month");
                    int revenue = resultSet.getInt("revenue");

                    // Adding data to the series
                    series.getData().add(new XYChart.Data<>(month, revenue));
                }

                // Adding series to the bar chart
                barChart.getData().add(series);

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

    }


    // ------------- CRUD OPERATIONS ------------


    // ---------- 1. INSERT SALES ----------
    public void addSales(int id, int budget, int revenue, String month, int year) throws SQLException
    {
        // QUERY
        String sql = "INSERT into sales (sales_id, budget, revenue, month, year) values ('"+ id +"', '"+ budget +"', '"+ revenue +"', '"+ month +"', '"+ year +"' )";
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
        String sql = "UPDATE sales SET budget = '" + budget + "' where sales_id = '"+ id +"' ";
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
        String sql = "DELETE from sales where sales_id = '"+ id +"' ";
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

    public ObservableList<Zsales> getAllRecords() throws SQLException
    {
        DB_handler.database_connection connection = new database_connection(); // making object of databse class
        Connection connectDB = connection.getConnection();             // returning connection from function of object of the class

        String sql = "SELECT* FROM sales";

        try
        {
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(sql);  // verifying login

            // getEmployeeObjects is a function
            ObservableList <Zsales> empList = getEmployeeObjects(queryResult);
            return empList;


        }
        catch(Exception e)
        {
            System.out.println("Exception occurred");
            e.printStackTrace();
            throw e;
        }

    }

    private static ObservableList<Zsales> getEmployeeObjects(ResultSet queryResult) throws SQLException {
        try
        {
            ObservableList<Zsales> empList = FXCollections.observableArrayList();
            while (queryResult.next())
            {
                Zsales emp = new Zsales();
                emp.setId(queryResult.getInt("sales_id"));
                emp.setBudget(queryResult.getInt("budget"));
                emp.setMonth(queryResult.getString("month"));
                emp.setYear(queryResult.getInt("year"));
                emp.setRevenue(queryResult.getInt("revenue"));
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
    public ObservableList<Zsales> searchsales(int id) throws SQLException
    {
        DB_handler.database_connection connection = new database_connection(); // making object of databse class
        Connection connectDB = connection.getConnection();             // returning connection from function of object of the class
        String sql = "SELECT * FROM sales WHERE sales_id = "+ id;

        try
        {
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(sql);  // verifying login


            // getEmployeeObjects is a function
            ObservableList <Zsales> empList = getEmployeeObjects(queryResult);
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
