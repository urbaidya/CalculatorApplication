package com.sopra.scientific.calculator.pojos;

import java.util.LinkedList;

public class OperatorsAndOperands {
	private LinkedList<Character> operatorsList;
	private LinkedList<Double> operandsList;
	
	//CONSTRUCTORS
	public OperatorsAndOperands() {
		
	}
	public OperatorsAndOperands(LinkedList<Character> operatorsList, LinkedList<Double> operandsList) {
		this.operatorsList = operatorsList;
		this.operandsList = operandsList;
	}
	//GETTERS
	public LinkedList<Character> getOperatorsList() {
		return operatorsList;
	}
	public LinkedList<Double> getOperandsList() {
		return operandsList;
	}
	//SETTERS
	public void setOperatorsList(LinkedList<Character> operatorsList) {
		this.operatorsList = operatorsList;
	}
	public void setOperandsList(LinkedList<Double> operandsList) {
		this.operandsList = operandsList;
	}
}
