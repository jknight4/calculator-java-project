package com.jknigh4.javacalculatorapp;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.InputMismatchException;
import java.util.Scanner;

@SpringBootApplication
public class JavaCalculatorAppApplication {
	public static void main(String[] args){

		Calculator calculator = new Calculator(new InputValidator(), null, null, null, null);
		Scanner scanner = new Scanner(System.in);

		System.out.println("Welcome to the Basic Calculator App made by Jeremy");

		boolean runApp = true;

		while(runApp) {
			try {
				calculator.getOperatorInput(scanner);
				calculator.getOperandInput("one", scanner);
				calculator.getOperandInput("two", scanner);
				calculator.calculate();
				System.out.printf("Solution: %s %s %s = %s\n", calculator.operandOne, calculator.operator,
						calculator.operandTwo, calculator.sum);
			} catch (InputMismatchException e) {
				System.out.println("Invalid Operand, Please Try Again");
			} catch(NumberFormatException e){
				System.out.println(e.getLocalizedMessage() + ", Please Try Again");
			}
			catch (Exception e) {
				System.out.println(e.getLocalizedMessage() + ", Please Try Again");
			}
			System.out.print("Press 1 to exit, Press anything else to continue: ");
			if(scanner.nextLine().equals("1")){
				runApp = false;
			}
		}


	}




}
