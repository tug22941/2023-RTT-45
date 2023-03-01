package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ModerateJDBCExamples {

	public static void main(String[] args) {
		String dburl = "jdbc:mysql://localhost:3306/classicmodels";
		String user = "root";
		String password = "password";
		System.out.println("-------- MySQL JDBC Connection Demo ------------");
		
		
		try {
			// Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(dburl, user, password);
			
			Scanner scn = new Scanner(System.in);
			System.out.println("Enter an Integer Amount: ");
			Integer amount = scn.nextInt();
			
			String SelectSQL = "select c.customerNumber, c.customerName, avg((MSRP - buyPrice)*quantityOrdered) as avg_margin\r\n"
					+ "from orders o, orderdetails od, products p, customers c\r\n"
					+ "where o.orderNumber = od.orderNumber\r\n"
					+ "and od.productCode = p.productCode\r\n"
					+ "and o.customerNumber = c.customerNumber\r\n"
					+ "group by c.customerNumber\r\n"
					+ "having avg((MSRP - buyPrice)*quantityOrdered) >?\r\n"
					+ "order by avg_margin desc;";
			
			// Create a SQL runnable prepared statement using the JDBC class
			PreparedStatement stmt = connection.prepareStatement(SelectSQL);
			stmt.setInt(1, amount);

			
			// Use the statement object to execute a query; put the result into ResultSet obj
			ResultSet result = stmt.executeQuery();
			while (result.next()) {
				String customerNumber = result.getString("customerNumber");
				String customerName = result.getString("customerName");
				String avgMargin = result.getString("avg_margin");
				System.out.println(customerNumber + " | " + customerName + " | "  + avgMargin);
			}
			connection.close();
			scn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
