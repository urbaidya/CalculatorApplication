package com.sopra.scientific.calculator.pojos;

import java.util.Stack;

public class OperatorsAndOperands {
	private Stack<String> operatorsList;
	private Stack<Double> operandsList;
	
	//CONSTRUCTORS
	public OperatorsAndOperands() {
		operatorsList = new Stack<>();
		operandsList = new Stack<>();
	}
	public OperatorsAndOperands(Stack<String> operatorsList, Stack<Double> operandsList) {
		this.operatorsList = operatorsList;
		this.operandsList = operandsList;
	}
	//GETTERS
	public Stack<String> getOperatorsList() {
		return operatorsList;
	}
	public Stack<Double> getOperandsList() {
		return operandsList;
	}
	//SETTERS
	public void setOperatorsList(Stack<String> operatorsList) {
		this.operatorsList = operatorsList;
	}
	public void setOperandsList(Stack<Double> operandsList) {
		this.operandsList = operandsList;
	}
}
