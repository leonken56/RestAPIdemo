package com.banktransaction.demo;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/UsersController")
public class UsersController {
	@Autowired
	ArrayListDAO ALLBANK = new ArrayListDAO();
	@GetMapping("/getAllUsers")
	public String getAllUsers() {
		return "HTTP GET request was sent <br>" + ALLBANK.printAllBalancetoString();
	}
	@GetMapping("/getAccountByName/{name}")
	public String getName(@PathVariable("name") String name) {
		Bank thisbank = ALLBANK.getAccountByName(name);		
		return thisbank.printinfo();
	}
	@GetMapping("/getUsers")
	public String getUsers() {
		ALLBANK.getAllAccounts();
		return "HTTP GET request was sent <br>" + ALLBANK.printAllBalancetoString();
	}
	@GetMapping("/accountbalance/{accountnumber}")
	public String getAccountBalance(@PathVariable("accountnumber") String accountnumber) {
		
		return ALLBANK.displaybalance(accountnumber);
	}
	@PostMapping("/createnewaccount")
	public String createUser(@RequestBody Bank newaccount) {
		ALLBANK.addNewAccount(newaccount);
		//ALLBANK.addAlltoDatabase();
		return newaccount.getCustomername() + " - " + "Added";
	}
	@DeleteMapping("/deleteaccount/{accountnumber}")
	public String deleteUser(@PathVariable("accountnumber") String accountnumber) {
		ALLBANK.deleteAccount(accountnumber);
		return "HTTP DELETE request was sent";
	}
	@PutMapping("/updateusername/{accountnumber}/{name}")
	public String updateUsername(@PathVariable("accountnumber") String accountnumber,@PathVariable("name") String name ) {
		ALLBANK.updateName(accountnumber, name);
		return "HTTP PUT request was sent";
	}
	@PutMapping("/updateemail/{accountnumber}/{email}")
	public String updateEmail(@PathVariable("accountnumber") String accountnumber,@PathVariable("email") String email ) {
		ALLBANK.updateEmail(accountnumber, email);
		return "HTTP PUT request was sent";
	}
	@PutMapping("/updatephonenumber/{accountnumber}/{phonenumber}")
	public String updatePhonenumber(@PathVariable("accountnumber") String accountnumber,@PathVariable("phonenumber") String phonenumber ) {
		ALLBANK.updatePhoneNumber(accountnumber, phonenumber);
		return "HTTP PUT request was sent";
	}
	@GetMapping("/deposit/{accountnumber}/{amount}")
	public String updatePhonenumber(@PathVariable("accountnumber") String accountnumber,@PathVariable("amount") double amount ) {
		ALLBANK.deposit(accountnumber, amount);
		return "HTTP PUT request was sent";
	}	
	
	@GetMapping("/hello")
	public ArrayListDAO hello() {
		
//		Bank user4 = new Bank("123213114", 5000.50, "Four Pham", "nova4@gmail.com","5103334444");
//		Bank user5 = new Bank("123241225", 75000.50, "Five Pham", "nova5@gmail.com","510333555");
//		Bank user6 = new Bank("121223336", 90000.50, "Six Pham", "nova6@gmail.com","5103336666");
//		
//		ALLBANK.addNewAccount(user4);
//		ALLBANK.addNewAccount(user5);
//		ALLBANK.addNewAccount(user6);
		//ALLBANK.addAlltoDatabase();
		//String displayAPI = ALLBANK.displayall();

		return ALLBANK;
	}
}
