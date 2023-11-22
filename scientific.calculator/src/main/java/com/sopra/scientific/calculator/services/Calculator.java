package com.sopra.scientific.calculator.services;

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

	public double calculate(double x, double y, char z) {
		switch (z){
		case '+':
			return add(x,y);
		case '-':
			return sub(x,y);
		case '*':
			return mul(x,y);
		case '/':
			return div(x,y);
		case '^':
			return pow(x,y);
		}
		return 0;
	}

	
}
