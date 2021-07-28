package com.banktransaction.demo;
import java.util.List;
public interface InterfaceBankDAO {
	   public List<Bank> getAllAccounts();
	   public Bank getAccount(String accountnumber);
	   public void updateName(Bank user, String name);
	   public void updateEmail(Bank user, String email);
	   public void updatePhoneNumber(Bank user, String PhoneNumber);
	   public void deleteAccount(String accountnumber);
	   public void addNewAccount(Bank account);
	   public void deposit(Bank account, double amount);
	   public void displayinfo(String name);
	   public void displaybalance(String accountnumber);
	   public void displayall();
	   public void addAlltoDatabase();
	}

