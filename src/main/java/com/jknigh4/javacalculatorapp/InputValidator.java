package com.jknigh4.javacalculatorapp;

import java.util.Arrays;
import java.util.List;

public class InputValidator{

    public void validate(String operator) throws Exception {
        List<String> acceptableOperators = Arrays.asList("+", "-", "*", "/");
        if(!acceptableOperators.contains(operator)){
            throw new Exception("Invalid Operator");
        }

    }

}
