package com.banktransaction.demo;
import java.util.List;
public interface InterfaceBankDAO {
	   public List<Bank> getAllAccounts();
	   public Bank getAccount(String accountnumber);
	   public void updateName(String accountnumber, String name);
	   public void updateEmail(String accountnumber, String email);
	   public void updatePhoneNumber(String accountnumber, String PhoneNumber);
	   public void deleteAccount(String accountnumber);
	   public void addNewAccount(Bank account);
	   public void deposit(String accountnumber, double amount);
	   public Bank getAccountByName(String name);
	   public String displayinfo(Bank account);
	   public String displaybalance(String accountnumber);
	   public void displayall();
	   public void addAlltoDatabase();
	}

