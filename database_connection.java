package DB_handler;

// Sql Libraries
import java.sql.DriverManager;
import java.sql.Connection;


public class database_connection
{
    public Connection databaseLink;

    public Connection getConnection()
    {
        String databaseName = "SDAproject23";
        String databaseUser = "root";
        String databasePassword = "Kimbrothers-12";
        String url = "jdbc:mysql://localhost:3306/" + databaseName;

        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
        }
        catch (Exception e)
        {
            System.out.println("not established!");
            e.printStackTrace();
        }

        return databaseLink;
    }
}
