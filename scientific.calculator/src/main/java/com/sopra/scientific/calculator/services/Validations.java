package com.sopra.scientific.calculator.services;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validations {
	public static boolean myValidations(String input) {
		Pattern pattern = Pattern.compile("[^0-9+\\-*/./^]");
		Matcher matcher = pattern.matcher(input);

		/*
		 * // The expression entered can't be empty or spaces if
		 * (input.trim().equals("")) {
		 * System.out.println("It is Spaces or Empty expression."); return false; }
		 * 
		 * // Only digits and +,-,*,/,. are allowed if (matcher.find()) {
		 * System.out.println("Illegal Character/s in the expression you have entered."
		 * ); return false; }
		 */

		// +,-,*,/ can't be start or end of the expression
		pattern = Pattern.compile("[^0-9]+$");
		matcher = pattern.matcher(input);
		if (matcher.find()) {
			System.out.println("Issue in the expression. \nLast character can't be an operator.");
			return false;
		}
		pattern = Pattern.compile("^[^0-9]+");
		matcher = pattern.matcher(input);
		if (matcher.find()) {
			System.out.println("Issue in the expression. \nFirst character can't be an operator.");
			return false;
		}

		// Multiple operators together in the input
		pattern = Pattern.compile("\\+{2,}");
		matcher = pattern.matcher(input);
		if (matcher.find()) {
			System.out.println("Multiple '+' together in the expression.");
			return false;
		}
		pattern = Pattern.compile("\\-{2,}");
		matcher = pattern.matcher(input);
		if (matcher.find()) {
			System.out.println("Multiple '-' together in the expression.");
			return false;
		}
		pattern = Pattern.compile("\\*{2,}");
		matcher = pattern.matcher(input);
		if (matcher.find()) {
			System.out.println("Multiple '*' together in the expression.");
			return false;
		}
		pattern = Pattern.compile("\\/{2,}");
		matcher = pattern.matcher(input);
		if (matcher.find()) {
			System.out.println("Multiple '/' together in the expression.");
			return false;
		}
		pattern = Pattern.compile("\\.{2,}");
		matcher = pattern.matcher(input);
		if (matcher.find()) {
			System.out.println("Multiple '.' together in the expression.");
			return false;
		}
		return true;
	}
}
