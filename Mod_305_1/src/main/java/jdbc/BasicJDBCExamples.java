package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class BasicJDBCExamples {
	public static void main(String[] args) {
		String dburl = "jdbc:mysql://localhost:3306/classicmodels";
		String user = "root";
		String password = "password";
		System.out.println("-------- MySQL JDBC Connection Demo ------------");
		
		
		try {
			// Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(dburl, user, password);
			
			Scanner scn = new Scanner(System.in);
			System.out.print("Enter the First Name or Last Name of Employee to search: ");
			String name = scn.nextLine();
			
			String SelectSQL = "Select * FROM employees where firstName = ? or lastName = ?";
			
			// Create a SQL runnable prepared statement using the JDBC class
			PreparedStatement stmt = connection.prepareStatement(SelectSQL);
			stmt.setString(1, name);
			stmt.setString(2, name);

			
			// Use the statement object to execute a query; put the result into ResultSet obj
			ResultSet result = stmt.executeQuery();
			while (result.next()) {
				String EmployeeID = result.getString("employeeNumber");
				String fname = result.getString("firstName");
				String lname = result.getString("lastName");
				String email = result.getString("email");
				System.out.println(EmployeeID + " | " + fname + " | " + lname + " | " + email);
			}
			connection.close();
			scn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
