package com.jknigh4.javacalculatorapp;

import lombok.Data;

import java.util.Scanner;

@Data
public class Calculator{
    Operator<Integer> addition = Integer::sum;
    Operator<Double> additionDouble = Double::sum;
    Operator<Integer> subtract = (x, y) -> x - y;
    Operator<Double> subtractDouble = (x, y) -> x - y;
    Operator<Integer> multiply = (x, y) -> x * y;
    Operator<Double> multiplyDouble = (x, y) -> x * y;
    Operator<Integer> divide = (x, y) -> x / y;
    Operator<Double> divideDouble = (x, y) -> x / y;

    InputValidator validator = new InputValidator();
    Scanner scanner = new Scanner(System.in);
    String operator = "";
    Double operandOne = 3.0;
    Double operandTwo = 3.0;
    Double sum = 0.0;

    public void getOperatorInput(){
        System.out.print("Enter the operator ( +, -, *, / ):  ");
        String input = scanner.nextLine();
        try{
            validator.validate(input);
            operator = input;
        } catch(Exception e){
            System.out.println("Invalid Operator");
            getOperatorInput();
        }
    }

    public void getOperandsInput(){
        setOperandOne();
        setOperandTwo();
    }

    public void setOperandOne() {
        System.out.print("Enter operand one: ");
        operandOne = scanner.nextDouble();
    }

    public void setOperandTwo() {
        System.out.print("Enter operand two: ");
        operandTwo = scanner.nextDouble();
    }

    public void calculate(){
        if(operator.equals("+")){
            sum = calculate(additionDouble, operandOne, operandTwo);

        }else if(operator.equals("-")){
            sum = calculate(subtractDouble, operandOne, operandTwo);

        }else if (operator.equals("*")){
            sum = calculate(multiplyDouble, operandOne, operandTwo);

        }else if (operator.equals("/")){
            sum = calculate(divideDouble, operandOne, operandTwo);
        }

    }


    private <T> T calculate(Operator<T> operator, T operand1, T operand2) {
        return operator.apply(operand1, operand2);
    }
}

@FunctionalInterface
interface Operator<T>{
    T apply(T operand1, T operand2);
}