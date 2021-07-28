package com.banktransaction.demo;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
@RestController
public class testController {
	@GetMapping("/helloAPI")
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
