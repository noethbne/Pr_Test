import com.mysql.cj.jdbc.result.ResultSetImpl;
import com.mysql.cj.protocol.Resultset;

import java.sql.*;

public class SQLDatabaseConnection{
    Connection conn;
    Statement stmt;

    public boolean login(String user, String passwd){
        boolean login = false;
        String query = "Select * From euser where userName = '" + user + "'";
        try {
            ResultSet rs = stmt.executeQuery(query);
            System.out.println(rs.next());

            String dbPassword = rs.getString("password");
            if (!dbPassword.equals(passwd)) {
                System.out.println("Username or Password wrong. Please try again");

            } else {
                String sqlUsername = rs.getString("userName");
                if (rs.getInt("deleted") == 1) {
                    System.out.println("User " + sqlUsername + " is deleted!!!");

                } else {
                    login = true;
                }
            }
        }catch (SQLException e){
            System.err.println("Query Login failed");
        }
        return login;
    }

    public SQLDatabaseConnection(String dbUrl, String dbUsername, String dbPassword){
        dbUrl = "jdbc:mysql://localhost:3306/javafxfitness";
        dbUsername = "root";
        dbPassword = "";

        try{
            conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
            stmt = conn.createStatement();
            System.out.println("Connection successful");
        }catch (SQLException e){
            System.out.println("Connection not successful");
        }
    }

    public int getUserId(String userName){
        String query = "Select userId from euser where userName = '" + userName + "'";
        try{
            ResultSet rs = stmt.executeQuery(query);
            rs.next();

            return rs.getInt("userId");
        }catch (SQLException e){
            System.err.println("Query for userId failed");
        }
        return -69;
    }

    public int isAdmin(String userName){
        String query = "Select admin from euser where userName = '" + userName + "'";
        try{
            ResultSet rs = stmt.executeQuery(query);
            rs.next();

            return rs.getInt("admin");
        }catch (SQLException e){
            System.err.println("Query for admin failed");
        }
        return -69;
    }

    public ResultSet getDBCourses(){
        String query = "Select * from ecourse";
        try{
            return stmt.executeQuery(query);
        }catch (SQLException e) {
            System.err.println("Query for Courses failed");
        }
        return null;
    }


}