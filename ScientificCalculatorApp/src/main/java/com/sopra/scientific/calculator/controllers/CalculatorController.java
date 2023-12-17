package com.sopra.scientific.calculator.controllers;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.sopra.scientific.calculator.pojos.CalculationResult;
import com.sopra.scientific.calculator.services.CalculatorService;

@Controller
public class CalculatorController {
	private final CalculatorService calculatorService;
	
	public CalculatorController(CalculatorService calculatorService) {
		this.calculatorService = calculatorService;
	}
	
	// BACKEND CALCULATOR LOGIC
	@PostMapping("/calculate")
	public ResponseEntity<?> calculate(@RequestBody Map<String, String> MyBody) {
		// Get expression from JSON
		String expression = MyBody.get("myexpression");
		System.out.println("Expression:"+expression);
		
		// Call method to extract and resolve 
		String result = calculatorService.calculateExpression(expression);
		
		// JSONify the Result
		System.out.println("Result:"+result);
		CalculationResult calculationResult = new CalculationResult(result);
		
		// Return result to jsp
		return ResponseEntity.ok(calculationResult);
	}
}
