import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class SQLDatabaseConnection{

    public static void login(String user, String passwd){
        String url = "jdbc:mysql://localhost:3306/javafxfitness";
        String username = "root";
        String password = "";

        try(Connection conn = DriverManager.getConnection(url, username, password);Statement stmt = conn.createStatement();){
            System.out.println("Connection successful");

            String query = "Select * From test where user = '" + user + "'";
            ResultSet rs = stmt.executeQuery(query);
            rs.next();

            String dbPassword = rs.getString("password");
            if(!dbPassword.equals(passwd)){
                System.out.println("Username or Password wrong. Please try again");

            }else{
                System.out.println("Login successfully");
                System.out.println("Roll: " + rs.getString("roll"));
            }

        }catch (SQLException e){
            System.out.println("Username or Password wrong. Please try again");
        }
    }
}