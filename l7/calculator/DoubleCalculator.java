package com.example.calculator;

import com.example.calculator.exceptions.NullParameterException;
import com.example.calculator.exceptions.OverflowException;
import com.example.calculator.exceptions.UnderflowException;
import com.example.calculator.exceptions.MyArithmeticException;

public class DoubleCalculator implements Calculator {

    @Override
    public double add(Double a, Double b)
            throws NullParameterException, OverflowException, UnderflowException {
        if (a == null || b == null) {
            throw new NullParameterException("Parametru null la add(): a=" + a + ", b=" + b);
        }

        double result = a + b;

        if (Double.isInfinite(result)) {
            if (result == Double.POSITIVE_INFINITY) {
                throw new OverflowException("Rezultat add() este +Infinity");
            } else { 
                throw new UnderflowException("Rezultat add() este -Infinity");
            }
        }

        return result;
    }

    @Override
    public double divide(Double a, Double b)
            throws NullParameterException, MyArithmeticException {
        if (a == null || b == null) {
            throw new NullParameterException("Parametru null la divide(): a=" + a + ", b=" + b);
        }
        if (b.doubleValue() == 0.0) {
            throw new MyArithmeticException("Împărțire la zero în divide(): a=" + a + ", b=" + b);
        }
        return a / b;
    }

    @Override
    public double average(Double[] values)
            throws NullParameterException, OverflowException, UnderflowException, MyArithmeticException {
        if (values == null) {
            throw new NullParameterException("Array-ul de intrare este null la average()");
        }
        int n = values.length;
        if (n == 0) {
            throw new MyArithmeticException("Array-ul este gol la average(), nu se poate împărți la zero");
        }

        Double sum = 0.0;
        for (int i = 0; i < n; i++) {
            Double v = values[i];
            if (v == null) {
                throw new NullParameterException("Element null în array la index " + i + " la average()");
            }
            sum = add(sum, v); 
        }

        return divide(sum, (double) n); /
    }
}
