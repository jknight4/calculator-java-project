package com.jknigh4.javacalculatorapp;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class InputValidator{

    public void validateOperator(String operator) throws Exception {
        List<String> acceptableOperators = Arrays.asList("+", "-", "*", "/");
        if(!acceptableOperators.contains(operator)){
            throw new Exception("Invalid Operator");
        }
    }

    public void validateDivideByZero(BigDecimal operandTwo) throws Exception {
        if(operandTwo.equals(new BigDecimal(0))){
            throw new Exception("Cannot Divide by Zero");
        }
    }

}
