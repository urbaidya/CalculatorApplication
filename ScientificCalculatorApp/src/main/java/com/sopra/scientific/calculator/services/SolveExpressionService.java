package com.sopra.scientific.calculator.services;


import org.decimal4j.util.DoubleRounder;
import org.springframework.stereotype.Service;

import com.sopra.scientific.calculator.logic.Calculator;
import com.sopra.scientific.calculator.pojos.OperatorsAndOperands;
import com.sopra.scientific.calculator.validations.MyChecks;

@Service
public class SolveExpressionService {

	private OperatorsAndOperands operatorsAndOperands;
	private Calculator calculator;

	public SolveExpressionService() {
		this.calculator = new Calculator();
	}

	public String logic(String[] expression) {
		
		operatorsAndOperands = new OperatorsAndOperands();
		
		try {
			for (String c: expression) {
				
				System.out.println("char:"+c);
				
				// Check for 'e' and 'pi'
				c = MyChecks.checkForEandPI(c);
				
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
					if (!operatorsAndOperands.getOperatorsList().empty()) {
						while (!operatorsAndOperands.getOperatorsList().peek().equals("(")) {
							calculate(operatorsAndOperands);
						}
					}
					operatorsAndOperands.getOperatorsList().pop();
				}
				// If it is LOG, LN, SIN, COS, TAN or SQRT Bracket
				/*
				 * else if (c.equals("log") || c.equals("ln") || c.equals("sqrt") ||
				 * c.equals("cos") || c.equals("sin") || c.equals("tan") || c.equals("fact")){
				 * operatorsAndOperands.getOperatorsList().push(c); }
				 */
			}
			
			//Loop till the operators list is not empty
			while (!operatorsAndOperands.getOperatorsList().empty()) {
				calculate(operatorsAndOperands);
			}
			// Returning Final Result
			return String.valueOf(DoubleRounder.round(operatorsAndOperands.getOperandsList().pop(),10));
		}
		catch (Exception e) {
			return "Illegal Expression";
		}

	}

	private void calculate(OperatorsAndOperands operatorsAndOperands) {
		double result = 0;
		String operator = operatorsAndOperands.getOperatorsList().pop();
		double operand2 = operatorsAndOperands.getOperandsList().pop();
		if (MyChecks.singleValOperator(operator)) {
			result = calculator.calculate(0, operand2, operator);
			System.out.println("Solving:"+operator+"("+operand2+")"+"="+result);
		}
		else {
			double operand1 = operatorsAndOperands.getOperandsList().pop();
			result = calculator.calculate(operand1, operand2, operator);
			System.out.println("Solving:"+operand1+operator+operand2+"="+result);
		}
		operatorsAndOperands.getOperandsList().push(result);
	}
}
