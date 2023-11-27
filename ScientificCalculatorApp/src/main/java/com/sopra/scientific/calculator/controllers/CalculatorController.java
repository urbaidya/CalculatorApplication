package com.sopra.scientific.calculator.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.sopra.scientific.calculator.pojos.CalculationResult;
import com.sopra.scientific.calculator.services.CalculatorService;

@Controller
public class CalculatorController {
	private final CalculatorService calculatorService;

	@Autowired
	public CalculatorController(CalculatorService calculatorService) {
		this.calculatorService = calculatorService;
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/calculator")
	public String calculator() {
		return "calculator";
	}

	@PostMapping("/calculate")
	public ResponseEntity<?> calculate(@RequestBody Map<String, String> MyBody) {
		String expression = MyBody.get("expression");
		System.out.println("Expression:"+expression);
		double result = calculatorService.calculateExpression(expression);
		System.out.println("Result:"+result);
		CalculationResult calculationResult = new CalculationResult(result);
		return ResponseEntity.ok(calculationResult);
	}
}
