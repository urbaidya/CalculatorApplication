package com.sopra.scientific.calculator.services;

import java.util.LinkedList;

import org.springframework.stereotype.Service;

@Service
public class SolveExpressionService {
	private Calculator calculator;
	private double result;
	private double nextOperand;
	
	public SolveExpressionService(){
		calculator = new Calculator();
		nextOperand = 0;
	}
	
	public double logic(LinkedList<Character> operatorsList, LinkedList<Double> operandsList) {
		result=operandsList.remove();
		
		for (char operator: operatorsList) { //looping over all operators list
			nextOperand = operandsList.remove();
			
			//call the function to resolve each operator
			result = calculator.calculate(result, nextOperand, operator);
		}
		return result;
	}
}
