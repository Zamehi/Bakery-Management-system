package BL;

import DB_handler.database_connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Admin
{
    public String b_password;
    public String b_username;
    public Admin()
    {
        this.b_password= "";
        this.b_username= "";
    }

    public int login(String userText, String passwordText)
    {
        DB_handler.database_connection connection = new database_connection(); // making object of databse class
        Connection connectDB = connection.getConnection();             // returning connection from function of object of the class

        String verifyLogin = "SELECT count(1) FROM login_accounts WHERE b_username = '" + userText + "' AND b_password = '" + passwordText + "'";
        try
        {
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);  // verifying login
            while (queryResult.next())
            {
                if (queryResult.getInt(1) == 1) // if valid user
                {
                    return 1;
                   // afterLoginText.setText("Logged in successfully");

                }
                else
                {
                    return 0;// the inout does not exist in data base
                    //afterLoginText.setText("Invalid Login");

                }

            }
        }
        catch(Exception e)
        {

        }
        return -1;
    }

    public void maintainSalary()
    {

    }
    public void displayEmployeeDetails()
    {

    }
}
