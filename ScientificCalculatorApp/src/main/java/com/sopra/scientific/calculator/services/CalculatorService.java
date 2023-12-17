package com.sopra.scientific.calculator.services;

import org.springframework.stereotype.Service;


@Service
public class CalculatorService {
	private final ExtractExpressionService extractExpressionService;
	private final SolveExpressionService solveExpressionService;

	public CalculatorService(ExtractExpressionService extractExpressionService, 
			SolveExpressionService solveExpressionService) {
		this.extractExpressionService = extractExpressionService;
		this.solveExpressionService = solveExpressionService;
	}

	public String calculateExpression(String input) {
		
		// Extract Expression
		String[] expression = extractExpressionService.extract(input);
		
		// Solve Expression and Return Result
		return solveExpressionService.logic(expression);
	}
}
