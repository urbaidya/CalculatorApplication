package com.sopra.scientific.calculator.logic;

public interface CalculatorOperations {
	//ADDITION 
	public double add(double x, double y);

	//SUBTRACTION
	public double sub(double x, double y);

	//MULTIPLICATION
	public double mul(double x, double y);

	//DIVIDE
	public double div(double x, double y);

	//POWER
	public double pow(double x, double y);

	//LOG BASE 10
	public double log(double x);

	//LOG BASE e
	public double ln(double x);

	//SQUARE ROOT
	public double sqrt(double x);

	//SIN
	public double sin(double x);

	//COS
	public double cos(double x);

	//TAN
	public double tan(double x);
	
	//FACTORIAL
	public double factorial(double x);
}
