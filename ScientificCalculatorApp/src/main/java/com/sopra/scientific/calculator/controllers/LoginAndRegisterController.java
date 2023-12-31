package com.sopra.scientific.calculator.controllers;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sopra.scientific.calculator.entities.Users;
import com.sopra.scientific.calculator.repositories.UsersRepository;

@Controller
public class LoginAndRegisterController {

	@Autowired
	private UsersRepository usersRepository;

	// LOGIN PAGE ENDPOINTS
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String goToLogin() {
		return "loginpage";
	}

	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String goToCalculator(@RequestParam String username, @RequestParam String password, ModelMap map) {
		Users dbUser = usersRepository.findByUsername(username.toLowerCase());
		if (dbUser!=null) { //If username found in db
			map.put("name", dbUser.getFullname());
			Boolean isPasswordMatch = BCrypt.checkpw(password, dbUser.getPassword());
			if (isPasswordMatch) { // check if password matches
				return "calculator";
			}
		}
		map.put("message", "<br>Invalid Credential ! Try Again.");
		return "loginpage";
	}


	// REGISTER PAGE ENDPOINTS
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String goToNewRegister() {
		return "register";
	}

	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String goBackToLogin(
			@RequestParam String fullname,
			@RequestParam String username, 
			@RequestParam String password, 
			ModelMap map) {
		Users dbUser = usersRepository.findByUsername(username.toLowerCase());
		if (dbUser==null) { // check if this username already exists
			Users user = new Users();
			user.setFullname(fullname);
			String hashedPassword = BCrypt.hashpw(password,BCrypt.gensalt()); //hash password
			user.setPassword(hashedPassword);
			user.setUsername(username);
			usersRepository.save(user);
			map.put("message", "<br>New User Registered.");
			return "register";
		}
		map.put("message", "<br>Username already registered.<br>Try different username.");
		return "register";
	}
}
