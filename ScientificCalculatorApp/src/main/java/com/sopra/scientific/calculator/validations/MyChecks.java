package com.sopra.scientific.calculator.validations;

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
			(c.equals("^"))||
			(c.equals("log"))||
			(c.equals("ln"))||
			(c.equals("sin"))||
			(c.equals("cos"))||
			(c.equals("tan"))||
			(c.equals("sqrt"))||
			(c.equals("!"))) 
		{
			return true;
		}
		return false;
	}

	public static int precedence(String operator) {
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
        } else if (operator.equals("sin") || operator.equals("cos") || operator.equals("tan")) {
        	return 6;
        } else if (operator.equals("!")) {
        	return 7;
        }
        return 0;
	}
	
	public static boolean singleValOperator(String operator) {
		if (operator.equals("ln") ||
			operator.equals("log") ||
			operator.equals("sqrt") ||
			operator.equals("cos") ||
			operator.equals("sin") ||
			operator.equals("tan") ||
			operator.equals("!")) {
			return true;	
		}
		return false;
	}
	
	public static String checkForEandPI(String c) {
		if (c.equals("e")) {
			c = ""+Math.E;
		}
		else if (c.equals("pi")) {
			c = ""+Math.PI;
		}
		return c;
	}
}
