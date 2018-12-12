package coreservlets;

import java.sql.*;
import java.util.Scanner;
//import javax.swing.JOptionPane;

public class SimpleJDBC {

private static PreparedStatement preparedStatement;
	
  public static void main(String[] args)
      throws SQLException, ClassNotFoundException {
    // Load the JDBC driver
    //Class.forName("com.mysql.jdbc.Driver");
    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    System.out.println("Driver loaded");

    // Connect to a database
    Connection connection = DriverManager.getConnection
    	      ("jdbc:sqlserver://s16988308.onlinehome-server.com:1433;databaseName=CUNY_DB;integratedSecurity=false;" , "cst3613", "password1");    
    System.out.println("Database connected");
    
    // Create a statement
    Statement statement = connection.createStatement();

    String queryString = "select firstName, mi, " +
            "lastName, title, grade from Students, Enrollment, Course " +
            "where Students.ssn = ? and Enrollment.courseId = ? " +
            "and Enrollment.courseId = Course.courseId";

          // Create a statement
    preparedStatement = connection.prepareStatement(queryString);    
    
    // Execute a statement
    //ResultSet resultSet = statement.executeQuery
     // ("select firstName, mi, lastName from Students where lastName " + " = 'Brown'");
    //System.out.println("select firstName, mi, lastName from Students where lastName " + " = 'Brown'");
    // Iterate through the result and print the student names
    //while (resultSet.next())
     // System.out.println(resultSet.getString(1) + "\t" + resultSet.getString(2) + "\t" + resultSet.getString(3));

    // Close the connection
    //resultSet.close();
    Scanner keyboard = new Scanner(System.in);
    
    System.out.println("Enter SSN: ");
    String ssn = keyboard.nextLine();
    System.out.println("Enter Course ID: ");
    String courseId = keyboard.nextLine();
    
    try {
        preparedStatement.setString(1, ssn);
        preparedStatement.setString(2, courseId);
        ResultSet rset = preparedStatement.executeQuery();

        if (rset.next()) {
          String lastName = rset.getString(1);
          String mi = rset.getString(2);
          String firstName = rset.getString(3);
          String title = rset.getString(4);
          String grade = rset.getString(5);

          System.out.println(firstName + " " + mi +
                  " " + lastName + "'s grade on course " + title + " is " +
                  grade);
        }
        else {
        	System.out.println("Not found");
        }
        rset.close();       
      }
      catch (SQLException ex) {
        ex.printStackTrace();
      }  
    
    connection.close();
    System.out.println("Database closed");
    keyboard.close();
  }
}