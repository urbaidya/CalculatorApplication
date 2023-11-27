package com.sopra.scientific.calculator.services;


import org.springframework.stereotype.Service;

import com.sopra.scientific.calculator.entities.Calculator;
import com.sopra.scientific.calculator.entities.MyChecks;
import com.sopra.scientific.calculator.pojos.OperatorsAndOperands;

@Service
public class SolveExpressionService {

	private OperatorsAndOperands operatorsAndOperands;
	private Calculator calculator;

	public double logic(String[] expression) {
		operatorsAndOperands = new OperatorsAndOperands();
		calculator = new Calculator();
		for (String c: expression) {
			// If it is Number
			if (MyChecks.isNumeric(c)){
				operatorsAndOperands.getOperandsList().push(Double.parseDouble(c));
			} 
			// If it is an Operator
			else if (MyChecks.isOperator(c)) {
				if (!operatorsAndOperands.getOperatorsList().empty()) {
					while (MyChecks.precedence(operatorsAndOperands.getOperatorsList().peek()) 
							>= MyChecks.precedence(c)) {
						System.out.println("Here1");
						calculate(operatorsAndOperands);
						if (operatorsAndOperands.getOperatorsList().empty()) {
							break;
						}
					}
				}
				operatorsAndOperands.getOperatorsList().push(String.valueOf(c));
			}
			// If it is Open Bracket
			else if (c.equals("(")) {
				operatorsAndOperands.getOperatorsList().push(String.valueOf(c));
			}
			// If it is Close Bracket
			else if (c.equals(")")) {
				if (!operatorsAndOperands.getOperatorsList().empty()) {

					while (!operatorsAndOperands.getOperatorsList().peek().equals("(")) {
						calculate(operatorsAndOperands);
					}
				}
				operatorsAndOperands.getOperatorsList().pop();
			}
			// If it is LOG, LN or SQRT Bracket
			else if (c.equals("log") || c.equals("ln") || c.equals("sqrt")) {
				operatorsAndOperands.getOperatorsList().push(c);
			}
		}
		while (!operatorsAndOperands.getOperatorsList().empty()) {
			calculate(operatorsAndOperands);
		}
		return operatorsAndOperands.getOperandsList().pop();
	}
	
	private void calculate(OperatorsAndOperands operatorsAndOperands) {
		double result = 0;
		String operator = operatorsAndOperands.getOperatorsList().pop();
		double operand2 = operatorsAndOperands.getOperandsList().pop();
		if (operator.equals("ln")) {
			result = calculator.calculate(0, operand2, operator);
		}
		else if (operator.equals("log")) {
			result = calculator.calculate(0, operand2, operator);
		}
		else if (operator.equals("sqrt")) {
			result = calculator.calculate(0, operand2, operator);
		}
		else {
			double operand1 = operatorsAndOperands.getOperandsList().pop();
			System.out.println("Solving:"+operand1+operator+operand2);
			result = calculator.calculate(operand1, operand2, operator);
		}
		operatorsAndOperands.getOperandsList().push(result);
		System.out.println(operatorsAndOperands.getOperandsList());
		System.out.println(operatorsAndOperands.getOperatorsList());
	}
}
