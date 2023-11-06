package com.jknigh4.javacalculatorapp;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Scanner;

@Data
@AllArgsConstructor
public class Calculator{
    InputValidator validator;
    String operator;
    BigDecimal operandOne, operandTwo, sum;

    public void getOperatorInput(Scanner scanner) throws Exception{
        System.out.print("Enter the operator ( +, -, *, / ):  ");
        String input = scanner.next();
        validator.validateOperator(input);
        operator = input;
    }

    public void getOperandInput(String number, Scanner scanner){
        if(number.equals("one")){
            System.out.print("Enter operand one: ");
            operandOne = scanner.nextBigDecimal();
        }else{
            System.out.print("Enter operand two: ");
            operandTwo = scanner.nextBigDecimal();
        }
    }

    public void calculate() throws Exception {
        if(operator.equals("+")){
            sum = calculate(BigDecimal::add, operandOne, operandTwo);

        }else if(operator.equals("-")){
            sum = calculate(BigDecimal::subtract, operandOne, operandTwo);

        }else if (operator.equals("*")){
            sum = calculate(BigDecimal::multiply, operandOne, operandTwo);

        }else if (operator.equals("/")){
            validator.validateDivideByZero(operandTwo);
            sum = calculate(BigDecimal::divide, operandOne, operandTwo);
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