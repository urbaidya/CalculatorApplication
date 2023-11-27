package com.sopra.scientific.calculator.entities;

public class MyChecks {
	public static boolean isNumeric(String myStr) {
		if (myStr == null) {
	        return false;
	    }
	    try {
	        Double.parseDouble(myStr);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}

	public static boolean isOperator(String c) {
		if ((c.equals("+"))||
			(c.equals("-"))||
			(c.equals("*"))||
			(c.equals("/"))||
			(c.equals("^"))) 
		{
			return true;
		}
		return false;
	}

	public static int precedence(String operator) {
		System.out.println(operator);
		if (operator.equals("+") || operator.equals("-")) {
            return 1;
        } else if (operator.equals("*") || operator.equals("/")) {
            return 2;
        } else if (operator.equals("^")) {
            return 3;
        } else if (operator.equals("sqrt")) {
        	return 4;
        } else if (operator.equals("ln") || operator.equals("log")) {
        	return 5;
        }
        return 0;
	}
}
