package com.banktransaction.demo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCBank {
   //static final String DB_URL = "jdbc:mysql://localhost/TUTORIALSPOINT";
	static final String DB_URL = "jdbc:mysql://database-mysql.ck2jovupcm0u.us-east-2.rds.amazonaws.com/database1";
	static final String USER = "admin";
	static final String PASS = "testadmin";
	static final String QUERY = "SELECT accountnumber, customername, email, phonenumber, balance FROM user";
	
	public static void main(String[] args) {
	      System.out.println("Connecting to a selected database...");
	      // Open a connection
	      try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);) {		      
	         System.out.println("Connected database successfully...");  
	         Statement stmt = conn.createStatement();
	         ResultSet rs = stmt.executeQuery(QUERY);
	   	      
	         while(rs.next()){
	            //Display values
	            System.out.println("Account Number: " + rs.getString("accountnumber"));
	            System.out.println("Customer Name: " + rs.getString("customername"));
	            System.out.println("Email: " + rs.getString("email"));
	            System.out.println("Phone Number: " + rs.getString("phonenumber"));
	            System.out.println("Balance: $" + rs.getDouble("balance"));
	         }
	         
	         
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } 
   }
}