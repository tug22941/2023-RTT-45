package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCHomework {
	
	// make this in a new Homework1 class
	// I want to see a list of all customers that have made a payment larger than <amount> in a particular <state>
	// Print the checkNumber, amount (formatted to $#.00 ), and the customer name ordered by the largest amount first
	// input variables for the scanner are 1) the amount and 2) 2 digit state code.

	public static void main(String[] args) {
		String dburl = "jdbc:mysql://localhost:3306/classicmodels";
		String user = "root";
		String password = "password";
		System.out.println("-------- MySQL JDBC Connection Demo ------------");
		
		
		try {
			// Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(dburl, user, password);
			
			Scanner scn = new Scanner(System.in);
			System.out.print("Enter an Integer Amount: ");
			Integer amount = scn.nextInt();
			scn.nextLine();
			System.out.print("Enter a State: ");
			String state = scn.nextLine();
			   
			String SelectSQL = "select *\r\n"
					+ "from customers c\r\n"
					+ "left join payments p\r\n"
					+ "using (customerNumber)\r\n"
					+ "where p.amount > ? and c.state = ?\r\n"
					+ "order by amount desc";
			
			// Create a SQL runnable prepared statement using the JDBC class
			PreparedStatement stmt = connection.prepareStatement(SelectSQL);
			stmt.setInt(1, amount);
			stmt.setString(2, state);

			
			// Use the statement object to execute a query; put the result into ResultSet obj
			ResultSet result = stmt.executeQuery();
			System.out.println("Check Number\tAmount\t\tCustomer Name");
			System.out.println("--------------------------------------------");
			while (result.next()) {
				String checkNumber = result.getString("CheckNumber");
				String outAmount = result.getString("amount");
				String customerName = result.getString("customerName");
				System.out.println(checkNumber + " | \t" + String.format(outAmount, "%2.f") + " | "  + customerName);
			}
			connection.close();
			scn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
