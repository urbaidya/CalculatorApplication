package com.sopra.scientific.calculator.controllers;

import java.util.Map;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sopra.scientific.calculator.entities.Users;
import com.sopra.scientific.calculator.pojos.CalculationResult;
import com.sopra.scientific.calculator.repositories.UsersRepository;
import com.sopra.scientific.calculator.services.CalculatorService;

@Controller
public class CalculatorController {
	private final CalculatorService calculatorService;
	private UsersRepository usersRepository;

	public CalculatorController(CalculatorService calculatorService, 
								UsersRepository usersRepository) {
		this.calculatorService = calculatorService;
		this.usersRepository = usersRepository;
	}

	// LOGIN PAGE 
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String goToLogin() {
		return "loginpage";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String goToCalculator(@RequestParam String username, @RequestParam String password, ModelMap map) {
		Users dbUser = usersRepository.findByUsername(username);
		if (dbUser!=null) {
			map.put("name", dbUser.getFullname());
			Boolean isPasswordMatch = BCrypt.checkpw(password, dbUser.getPassword());
			if (isPasswordMatch) {
				return "calculator";
			}
		}
		map.put("message", "Invalid Credential ! Try Again.");
		return "loginpage";
	}
	
	
	// REGISTER PAGE
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String goToNewRegister() {
		return "register";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String goBackToLogin(@RequestParam String fullname,
								@RequestParam String username, 
								@RequestParam String password, 
								ModelMap map) {
		Users user = new Users();
		user.setFullname(fullname);
		String hashedPassword = BCrypt.hashpw(password,BCrypt.gensalt());
		user.setPassword(hashedPassword);
		user.setUsername(username);
		usersRepository.save(user);
		map.put("message", "New User Registered.");
		return "register";
	}

	// BACKEND CALCULATOR LOGIC
	@PostMapping("/calculate")
	public ResponseEntity<?> calculate(@RequestBody Map<String, String> MyBody) {
		String expression = MyBody.get("expression");
		System.out.println("Expression:"+expression);
		String result = calculatorService.calculateExpression(expression);
		System.out.println("Result:"+result);
		CalculationResult calculationResult = new CalculationResult(result);
		return ResponseEntity.ok(calculationResult);
	}
}
