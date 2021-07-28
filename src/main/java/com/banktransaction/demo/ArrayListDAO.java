package com.banktransaction.demo;
import java.util.ArrayList;

import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ArrayListDAO implements InterfaceBankDAO {
	ArrayList<Bank> ALLBANKUSER = new ArrayList();
	static final String DB_URL = "jdbc:mysql://database-mysql.ck2jovupcm0u.us-east-2.rds.amazonaws.com/database1";
	static final String USER = "admin";
	static final String PASS = "testadmin";
	static final String QUERY = "SELECT accountnumber, customername, email, phonenumber, balance FROM user";
	
	public ArrayList<Bank> getAllAccounts() {
		// TODO Auto-generated method stub
		return ALLBANKUSER;
	}


	public Bank getAccount(String accountnumber) {
		// TODO Auto-generated method stub
		
		return ALLBANKUSER.get(ALLBANKUSER.indexOf(accountnumber));
	}


	public void updateName(Bank user, String name) {
		// TODO Auto-generated method stub
		user.setCustomername(name);
	}


	public void updateEmail(Bank user, String email) {
		// TODO Auto-generated method stub
		user.setEmail(email);
	}


	public void updatePhoneNumber(Bank user, String PhoneNumber) {
		// TODO Auto-generated method stub
		user.setPhonenumber(PhoneNumber);
	}


	public void deleteAccount(String accountnumber) {
		// TODO Auto-generated method stub
		ALLBANKUSER.remove(ALLBANKUSER.indexOf(accountnumber));
	}

	public void addNewAccount(Bank account) {
		// TODO Auto-generated method stub
		ALLBANKUSER.add(account);
		
	}


	public void deposit(Bank account, double amount) {
		// TODO Auto-generated method stub
		
		if ((amount>=5) &&(amount<=10000))
			account.deposit(amount);
		else System.out.println("Deposit fund must be between $5 - $10000");
			
	}

	public String printAllBalancetoString() {
		String result = "";
		result += "ACCOUNT NUMBER / CUSTOMER NAME / BALANCE ($)<br>";
	    for (Bank x : ALLBANKUSER) {
	    	result += x.getAccountnumber() + " / " + x.getCustomername() + " / Balance: $" + x.getBalance() + "<br>"; 
	    	
	      }
	    return result;
	}

	public void displayinfo(String name) {
		// TODO Auto-generated method stub
	    for (Bank x : ALLBANKUSER) {
	    	String curName = x.getCustomername();
	        if (curName == name)
	        	x.printinfo();
	      }
		
	}


	public void displaybalance(String accountnumber) {
		// TODO Auto-generated method stub
		Bank curAccount = getAccount(accountnumber);
		double curBalance = curAccount.getBalance();
		System.out.println("This account [" + accountnumber + "] has a balance of: $" + curBalance);
	}

	public void displayall() {
	    for (Bank x : ALLBANKUSER) {
	    	x.printinfo();
	      }
		
	}
	public void addAlltoDatabase() {

		 try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
		         Statement stmt = conn.createStatement();
		      ) {		      
		         // Execute a query
			 	System.out.println("Connected database successfully...");             
		        String sql = "";
		        
		 		for (Bank x : ALLBANKUSER) {
		 			
		 			System.out.println("Inserting "+ x.getCustomername() +" into the table...");
		 			sql = "INSERT INTO user (accountnumber,customername,phonenumber,email,balance) VALUES "
		 					+ "('"+ x.getAccountnumber() +"','"+ x.getCustomername()+"','"+ x.getPhonenumber()+"','"+ x.getEmail() +"','"+x.getBalance()+"');";
		 			
		 			//System.out.println(sql);
		 			stmt.executeUpdate(sql);
		 			System.out.println("Inserted " + x.getAccountnumber() + " record into the table...");
		 		}
		 		
		            	  
		      } catch (SQLException e) {
		         e.printStackTrace();
		      } 
		 

	}
}
