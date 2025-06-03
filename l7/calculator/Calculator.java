package com.example.calculator;

import com.example.calculator.exceptions.NullParameterException;
import com.example.calculator.exceptions.OverflowException;
import com.example.calculator.exceptions.UnderflowException;
import com.example.calculator.exceptions.MyArithmeticException;

public interface Calculator {

    double add(Double a, Double b)
            throws NullParameterException, OverflowException, UnderflowException;

    double divide(Double a, Double b)
            throws NullParameterException, MyArithmeticException;

    double average(Double[] values)
            throws NullParameterException, OverflowException, UnderflowException, MyArithmeticException;
}
