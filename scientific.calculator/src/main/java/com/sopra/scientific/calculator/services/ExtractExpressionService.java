package com.sopra.scientific.calculator.services;

import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.sopra.scientific.calculator.pojos.OperatorsAndOperands;

@Service
public class ExtractExpressionService {
	private LinkedList<Character> operatorsList;
	private LinkedList<Double> operandsList;
	private String number;
	private Pattern pattern;
	private Matcher matcher;
	OperatorsAndOperands operatorsAndOperands;
	
	public ExtractExpressionService() {
		operatorsList = new LinkedList<>();
		operandsList = new LinkedList<>();
		number = "";
		pattern = Pattern.compile("[0-9.]");
		operatorsAndOperands = new OperatorsAndOperands();
		
	}

	public OperatorsAndOperands extract(String input) {
		operatorsList.clear(); //clear the operators list
		operandsList.clear();  //clear the operands list
		number="";
		for (int i=0; i<input.length() ;i++) { //loop over input
			String c = String.valueOf(input.charAt(i)); //get each character of input
			matcher = pattern.matcher(c); 
			if (matcher.find()) { //check to see if its digits 
				number+=c; //add to numbers if its digit
			}
			else {
				operatorsList.add(c.charAt(0)); // store operator
				operandsList.add(Double.parseDouble(number)); //store the number
				number=""; //reset number
			}
		}
		operandsList.add(Double.parseDouble(number));
		
		operatorsAndOperands.setOperatorsList(operatorsList);
		operatorsAndOperands.setOperandsList(operandsList);
		return operatorsAndOperands;
	}
}
