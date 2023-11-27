package com.sopra.scientific.calculator.entities;

public class Calculator implements CalculatorOperations{
	@Override
	public double add(double x, double y) {
		return x+y;
	}

	@Override
	public double sub(double x, double y) {
		return x-y;
	}

	@Override
	public double mul(double x, double y) {
		return x*y;
	}

	@Override
	public double div(double x, double y) {
		return x/y;
	}
	
	@Override
	public double pow(double x, double y) {
		return Math.pow(x, y);
	}
	
	@Override
	public double log(double x) {
		return Math.log10(x);
	}

	@Override
	public double ln(double x) {
		return Math.log(x);
	}

	@Override
	public double sqrt(double x) {
		return Math.sqrt(x);
	}

	public double calculate(double x, double y, String z) {
		switch (z){
		case "+":
			return add(x,y);
		case "-":
			return sub(x,y);
		case "*":
			return mul(x,y);
		case "/":
			return div(x,y);
		case "^":
			return pow(x,y);
		case "log":
			return log(y);
		case "ln":
			return ln(y);
		case "sqrt":
			return sqrt(y);
		}
		return 0;
	}
}
