package com.foodapp.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.foodapp.model.LoginBean;

public class LoginDao {

    public String validate(LoginBean loginBean) throws ClassNotFoundException {
       // String status = "";

        Class.forName("com.mysql.cj.jdbc.Driver");

        String username = loginBean.getUsername();
    	String password = loginBean.getPassword();
    	String role = loginBean.getRole();
    	
    	String usernameDB = "";
        String passwordDB = "";
        String roleDB = "";
        
        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/mysql_database?allowPublicKeyRetrieval=true&useSSL=false", "webstudent", "webstudent");

        	
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection
            .prepareStatement("select * from login where username = ? and password = ? and role = ? ")) {
            preparedStatement.setString(1, loginBean.getUsername());
            preparedStatement.setString(2, loginBean.getPassword());
            preparedStatement.setString(3, loginBean.getRole());
            
            
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            
            
            while(rs.next())
            {
            	usernameDB = rs.getString("username");
                passwordDB = rs.getString("password");
                roleDB = rs.getString("role");
     
                if(username.equals(usernameDB) && password.equals(passwordDB) && roleDB.equals("admin"))
                return "admin";
                
                else if(username.equals(usernameDB) && password.equals(passwordDB) && roleDB.equals("customer"))
                return "customer";
            }

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return "Invalid user credentials";
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}