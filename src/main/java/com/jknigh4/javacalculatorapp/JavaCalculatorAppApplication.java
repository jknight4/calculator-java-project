package com.jknigh4.javacalculatorapp;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaCalculatorAppApplication {
	public static void main(String[] args){

		Calculator calculator = new Calculator();

		System.out.println("Welcome to the Basic Calculator App made by Jeremy");
		calculator.getOperatorInput();
		calculator.getOperandsInput();
		calculator.calculate();



		System.out.printf("the results are: %s", calculator.sum);

	}




}
