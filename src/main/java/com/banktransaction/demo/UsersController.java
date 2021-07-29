package com.banktransaction.demo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/user")
public class UsersController {
	@GetMapping()
	public String getUsers() {
		Bank user1 = new Bank("123213114", 5000.50, "Four Pham", "nova4@gmail.com","5103334444");
		Bank user2 = new Bank("123241225", 75000.50, "Five Pham", "nova5@gmail.com","510333555");
		Bank user3 = new Bank("121223336", 90000.50, "Six Pham", "nova6@gmail.com","5103336666");
		ArrayListDAO ALLBANK = new ArrayListDAO();
		ALLBANK.addNewAccount(user1);
		ALLBANK.addNewAccount(user2);
		ALLBANK.addNewAccount(user3);
		//ALLBANK.addAlltoDatabase();
		//String displayAPI = ALLBANK.displayall();

		
		return "HTTP GET request was sent <br>" + ALLBANK.printAllBalancetoString();
	}
	@PostMapping()
	public String createUser() {
		return "HTTP POST request was sent";
	}
	@DeleteMapping()
	public String deleteUser() {
		return "HTTP DELETE request was sent";
	}
	@PutMapping()
	public String updateUser() {
		return "HTTP PUT request was sent";
	}
	
	public String hello() {
		Bank user1 = new Bank("123213114", 5000.50, "Four Pham", "nova4@gmail.com","5103334444");
		Bank user2 = new Bank("123241225", 75000.50, "Five Pham", "nova5@gmail.com","510333555");
		Bank user3 = new Bank("121223336", 90000.50, "Six Pham", "nova6@gmail.com","5103336666");
		ArrayListDAO ALLBANK = new ArrayListDAO();
		ALLBANK.addNewAccount(user1);
		ALLBANK.addNewAccount(user2);
		ALLBANK.addNewAccount(user3);
		//ALLBANK.addAlltoDatabase();
		//String displayAPI = ALLBANK.displayall();

		return ALLBANK.printAllBalancetoString();
	}
}
