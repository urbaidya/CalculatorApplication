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
			}

			//Loop till the operators list is not empty
			while (!operatorsAndOperands.getOperatorsList().empty()) {
				calculate(operatorsAndOperands);
			}
			// Returning Final Result
			String finalResult= String.valueOf(DoubleRounder.round(operatorsAndOperands.getOperandsList().pop(),10));
			System.out.println(finalResult);
			if (finalResult.equals("Infinity") || 
					finalResult.equals("NaN")) {
				return finalResult;	
			}
			
			// Find if we need result in decimal or not
			String[] splittedFinalResult = finalResult.split("\\.");
			if (splittedFinalResult[1].equals("0")) {
				return splittedFinalResult[0];
			}
			return finalResult;		
		}
		catch (Exception e) {
			return "Illegal Expression";
		}
	}

	private void calculate(OperatorsAndOperands operatorsAndOperands) throws Exception {
		double result = 0;
		double operand1 = 0;
		double operand2 = operatorsAndOperands.getOperandsList().pop();
		String operator = operatorsAndOperands.getOperatorsList().pop();
		if (MyChecks.singleValOperator(operator)) {
			result = calculator.calculate(operand1, operand2, operator);
			System.out.println("Solving:"+operator+"("+operand2+")"+"="+result);
		}
		else {
			if (operatorsAndOperands.getOperandsList().isEmpty()) {
				result = calculator.calculate(operand1, operand2, operator);
				System.out.println("Solving:"+operand1+operator+operand2+"="+result);
			}
			else {
				operand1 = operatorsAndOperands.getOperandsList().pop();
				result = calculator.calculate(operand1, operand2, operator);
				System.out.println("Solving:"+operand1+operator+operand2+"="+result);
			}
		}
		operatorsAndOperands.getOperandsList().push(result);
	}
}
