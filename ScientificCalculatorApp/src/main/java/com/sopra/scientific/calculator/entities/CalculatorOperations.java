package com.sopra.scientific.calculator.entities;

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
}
