package com.sopra.scientific.calculator.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sopra.scientific.calculator.pojos.OperatorsAndOperands;

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

	public double calculateExpression(String expression) {
		if (Validations.myValidations(expression)) {
			OperatorsAndOperands operatorsAndOperands = extractExpressionService.extract(expression);
			return solveExpressionService.logic(operatorsAndOperands.getOperatorsList(), 
					operatorsAndOperands.getOperandsList());
		}
		else {
			return 0;
		}

	}
}
