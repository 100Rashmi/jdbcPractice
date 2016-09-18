package connector;

//STEP 1. Import required packages
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

import beans.Actor;
import beans.Customer;

public class JDBCExample {
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/sakila";

	// Database credentials
	static final String USER = "root";
	static final String PASS = "abcd";

	public static void main3(){
		try {
			main2();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main2() throws ClassNotFoundException, SQLException{
		Connection conn = null;
		Statement stmt = null;
		Class.forName(JDBC_DRIVER);

		// STEP 3: Open a connection
		System.out.println("Connecting to a selected database...");
		conn = DriverManager.getConnection(DB_URL, USER, PASS);
		System.out.println("Connected database successfully...");

		// STEP 4: Execute a query
		System.out.println("Creating statement...");
		stmt = conn.createStatement();

		String sql = "SELECT actor_id,first_name,last_name,last_update From actor";

		ResultSet rs = stmt.executeQuery(sql);
		// STEP 5: Extract data from result set
		while (rs.next()) {
			// Retrieve by column name
			int id = rs.getInt("actor_id");
			String first_name = rs.getString("first_name");
			String last_name = rs.getString("last_name");

			// Display values
			System.out.print("ID: " + id);

			System.out.print(", First: " + first_name);
			System.out.println(", Last: " + last_name);
		}
		rs.close();
		stmt.close();
		conn.close();
	}
	/*
	 * This function executes a query on mysql and returns the result in the form of a list  of beans (actor class)
	 */
	public static List<Actor> getActorsDataFromDb(String firstName) {
		Connection conn = null;
		Statement stmt = null;
		try {
			// STEP 2: Register JDBC driver
			Class.forName(JDBC_DRIVER);

			// STEP 3: Open a connection
			System.out.println("Connecting to a selected database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connected database successfully...");

			// STEP 4: Execute a query
			System.out.println("Creating statement...");
			stmt = conn.createStatement();

			String sql = "SELECT actor_id,first_name,last_name,last_update From actor where first_name = '"+firstName+"'";
			System.out.println("eXECUTING : "+sql);
			
			ResultSet rs = stmt.executeQuery(sql);
			// STEP 5: Extract data from result set
			//String results = "";
			List<Actor> listofActors=new LinkedList();
			while (rs.next()) {
				// Retrieve by column name
				int id = rs.getInt("actor_id");
				String first_name = rs.getString("first_name");
				String last_name = rs.getString("last_name");
				
				Actor a= new Actor(id, first_name, last_name);
				listofActors.add(a);
				// Display values
				System.out.print("ID: " + id);
				
				System.out.print(", First: " + first_name);
				System.out.println(", Last: " + last_name);
				
				
			}
			rs.close();
			return listofActors ;
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					conn.close();
			} catch (SQLException se) {
			} // do nothing
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
		System.out.println("Goodbye!");
		return null;
	}// end main

	public static List<Customer> getCustomersDataFromDb(String name) {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement stmt = null;
		try {
			// STEP 2: Register JDBC driver
			Class.forName(JDBC_DRIVER);

			// STEP 3: Open a connection
			System.out.println("Connecting to a selected database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connected database successfully...");

			// STEP 4: Execute a query
			System.out.println("Creating statement...");
			stmt = conn.createStatement();

			//String sql = "SELECT customer_id,store_id,first_name,last_name,email,address_id,create_date From customer";
			String sql = "SELECT sac.customer_id as customer_id, sac.store_id as store_id, sac.first_name as first_name, sac.last_name as last_name, sac.email as email, sad.address as address,"
					+ " sac.create_date  as create_date  FROM sakila.customer sac left join sakila.address sad "
					+ "on sac.address_id=sad.address_id;";
			System.out.println("eXECUTING : "+sql);
			
			ResultSet rs = stmt.executeQuery(sql);
			// STEP 5: Extract data from result set
			//String results = "";
			List<Customer> listofCustomers=new LinkedList();
			while (rs.next()) {
				// Retrieve by column name
				int id = rs.getInt("customer_id");
				int store_id = rs.getInt("store_id");
				String address = rs.getString("address");
				String email = rs.getString("email");
				String first_name = rs.getString("first_name");
				String last_name = rs.getString("last_name");
				Date createdate=rs.getDate("create_date");
				
				Customer c= new Customer(id,store_id,address,email, first_name, last_name,createdate);
				listofCustomers.add(c);
				// Display values
				System.out.print("ID: " + id);
				
				System.out.print(", First: " + first_name);
				System.out.println(", Last: " + last_name);
				
				
			}
			rs.close();
			return listofCustomers ;
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					conn.close();
			} catch (SQLException se) {
			} // do nothing
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
		System.out.println("Goodbye!");

		return null;
	}

}// end JDBCExample
