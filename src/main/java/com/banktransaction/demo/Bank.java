package com.banktransaction.demo;
public class Bank {
	private String accountnumber = "NULL";
	private double balance = 0.0;
	private String customername = "NULL";
	private String email = "NULL";
	private String phonenumber = "NULL";
	
	Bank(String accountnumber, double balance, String customername, String email, String phonenumber){
		this.accountnumber = accountnumber;
		this.balance = balance;
		this.customername = customername;
		this.email = email;
		this.phonenumber = phonenumber;
	}
	/**
	 * @return the accountnumber
	 */
	public String getAccountnumber() {
		return accountnumber;
	}


	/**
	 * @param accountnumber the accountnumber to set
	 */
	public void setAccountnumber(String accountnumber) {
		this.accountnumber = accountnumber;
	}
	public static Bank empty() {
		Bank emptyBank = new Bank("NULL",0.0,"NULL","NULL","NULL");
		return emptyBank;
	}

	/**
	 * @return the balance
	 */
	public double getBalance() {
		return balance;
	}


	/**
	 * @param balance the balance to set
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}


	/**
	 * @return the customername
	 */
	public String getCustomername() {
		return customername;
	}


	/**
	 * @param customername the customername to set
	 */
	public void setCustomername(String customername) {
		this.customername = customername;
	}


	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}


	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}


	/**
	 * @return the phonenumber
	 */
	public String getPhonenumber() {
		return phonenumber;
	}


	/**
	 * @param phonenumber the phonenumber to set
	 */
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public void deposit(double amount) {
		balance = this.getBalance();
		balance += amount;
		this.setBalance(balance);
	}
	
	public void withdraw(double amount) {
		balance = this.getBalance();
		if (balance >= amount)
		{
			balance -= amount;
			this.setBalance(balance);				
		}
		else System.out.println("There are insufficient fund in this account");
	}

	public String printinfo() {
		System.out.println(this.getCustomername());
		System.out.println(this.getAccountnumber());
		System.out.println(this.getBalance());
		System.out.println(this.getEmail());
		System.out.println(this.getPhonenumber());
		System.out.println();
		return this.getCustomername() + this.getAccountnumber() + this.getBalance() + this.getEmail() + this.getPhonenumber();
	}

}
