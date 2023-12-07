package com.sopra.scientific.calculator.services;


import org.springframework.stereotype.Service;

import com.sopra.scientific.calculator.logic.Calculator;
import com.sopra.scientific.calculator.pojos.OperatorsAndOperands;
import com.sopra.scientific.calculator.validations.MyChecks;

@Service
public class SolveExpressionService {

	private OperatorsAndOperands operatorsAndOperands;
	private Calculator calculator;

	public String logic(String[] expression) {
		operatorsAndOperands = new OperatorsAndOperands();
		calculator = new Calculator();
		try {
			for (String c: expression) {
				System.out.println("Char: "+c);
				// If it is Number
				if (MyChecks.isNumeric(c)){
					operatorsAndOperands.getOperandsList().push(Double.parseDouble(c));
				} 
				// If it is an Operator
				else if (MyChecks.isOperator(c)) {
					if (!operatorsAndOperands.getOperatorsList().empty()) {
						while (MyChecks.precedence(operatorsAndOperands.getOperatorsList().peek()) 
								>= MyChecks.precedence(c)) {
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
					System.out.println("Close Bracket.");
					System.out.println(operatorsAndOperands.getOperandsList());
					System.out.println(operatorsAndOperands.getOperatorsList());
					if (!operatorsAndOperands.getOperatorsList().empty()) {
						System.out.println("Peek: "+operatorsAndOperands.getOperatorsList().peek());
						while (!operatorsAndOperands.getOperatorsList().peek().equals("(")) {
							calculate(operatorsAndOperands);
						}
					}
					operatorsAndOperands.getOperatorsList().pop();
				}
				// If it is LOG, LN, SIN, COS, TAN or SQRT Bracket
				else if (c.equals("log") || c.equals("ln") || c.equals("sqrt") ||
						 c.equals("cos") || c.equals("sin") || c.equals("tan") ||
						 c.equals("fact")){
					operatorsAndOperands.getOperatorsList().push(c);
				}
			}
			while (!operatorsAndOperands.getOperatorsList().empty()) {
				calculate(operatorsAndOperands);
			}
			return String.valueOf(operatorsAndOperands.getOperandsList().pop());
		}
		catch (Exception e) {
			return "Illegal Expression";
		}

	}

	private void calculate(OperatorsAndOperands operatorsAndOperands) {
		double result = 0;
		String operator = operatorsAndOperands.getOperatorsList().pop();
		double operand2 = operatorsAndOperands.getOperandsList().pop();
		if (operator.equals("ln") ||
			operator.equals("log") ||
			operator.equals("sqrt") ||
			operator.equals("cos") ||
			operator.equals("sin") ||
			operator.equals("tan") ||
			operator.equals("fact")) {
			result = calculator.calculate(0, operand2, operator);
		}
		else {
			double operand1 = operatorsAndOperands.getOperandsList().pop();
			System.out.println("Solving:"+operand1+operator+operand2);
			result = calculator.calculate(operand1, operand2, operator);
		}
		operatorsAndOperands.getOperandsList().push(result);
	}
}
