package com.sopra.scientific.calculator.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CalculatorService {
	private final ExtractExpressionService extractExpressionService;
	private final SolveExpressionService solveExpressionService;

	@Autowired
	public CalculatorService(ExtractExpressionService extractExpressionService, 
			SolveExpressionService solveExpressionService) {
		this.extractExpressionService = extractExpressionService;
		this.solveExpressionService = solveExpressionService;
	}

	public double calculateExpression(String input) {
			String[] expression = extractExpressionService.extract(input);
			return solveExpressionService.logic(expression);
	}
}
