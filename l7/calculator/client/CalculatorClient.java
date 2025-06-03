package com.example.calculator.client;

import com.example.calculator.DoubleCalculator;
import com.example.calculator.exceptions.NullParameterException;
import com.example.calculator.exceptions.OverflowException;
import com.example.calculator.exceptions.UnderflowException;
import com.example.calculator.exceptions.MyArithmeticException;
import com.example.calculator.exceptions.FileReadException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CalculatorClient {

    public static Double[] readTwoNumbers(String filename) throws FileReadException {
        ArrayList<Double> list = new ArrayList<>(2);
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null && list.size() < 2) {
                line = line.trim();
                if (line.isEmpty()) {
                    continue;
                }
                String[] tokens = line.split("\\s+");
                for (String tok : tokens) {
                    if (list.size() >= 2) {
                        break;
                    }
                    try {
                        Double val = Double.valueOf(tok);
                        list.add(val);
                    } catch (NumberFormatException ex) {
                        throw new FileReadException("Nu se poate transforma in Double textul: '" + tok + "'", ex);
                    }
                }
            }
        } catch (IOException ioEx) {
            throw new FileReadException("Eroare I/O la citirea fisierului: " + filename, ioEx);
        }
        if (list.size() < 2) {
            throw new FileReadException("Fisierul " + filename + " nu contine doua numere Double.");
        }
        return new Double[]{list.get(0), list.get(1)};
    }

    public static Double[] readMultipleNumbers(String filename) throws FileReadException {
        ArrayList<Double> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) {
                    continue;
                }
                String[] tokens = line.split("\\s+");
                for (String tok : tokens) {
                    try {
                        Double val = Double.valueOf(tok);
                        list.add(val);
                    } catch (NumberFormatException ex) {
                        throw new FileReadException("Nu se poate transforma in Double textul: '" + tok + "'", ex);
                    }
                }
            }
        } catch (IOException ioEx) {
            throw new FileReadException("Eroare I/O la citirea fisierului: " + filename, ioEx);
        }
        if (list.isEmpty()) {
            throw new FileReadException("Fisierul " + filename + " nu contine nicio valoare Double.");
        }
        return list.toArray(new Double[0]);
    }

    public static void main(String[] args) {
        DoubleCalculator calc = new DoubleCalculator();

        System.out.println("=== Test 1: add() cu fisier valid ===");
        try {
            Double[] twoNums = readTwoNumbers("numbers_add.txt");
            double sum = calc.add(twoNums[0], twoNums[1]);
            System.out.println("Rezultat add(" + twoNums[0] + ", " + twoNums[1] + ") = " + sum);
        } catch (FileReadException fre) {
            System.err.println("FileReadException la add: " + fre.getMessage());
        } catch (NullParameterException | OverflowException | UnderflowException ex) {
            System.err.println("Eroare la add: " + ex.getMessage());
        }

        System.out.println("\n=== Test 2: add(null, 5.0) ===");
        try {
            calc.add(null, 5.0);
        } catch (NullParameterException ex) {
            System.err.println("Prins NullParameterException: " + ex.getMessage());
        } catch (OverflowException | UnderflowException ex) {
            System.err.println("Alta exceptie la add cu null: " + ex.getMessage());
        }

        System.out.println("\n=== Test 3: add(Double.MAX_VALUE, Double.MAX_VALUE) ===");
        try {
            calc.add(Double.MAX_VALUE, Double.MAX_VALUE);
        } catch (OverflowException ex) {
            System.err.println("Prins OverflowException: " + ex.getMessage());
        } catch (NullParameterException | UnderflowException ex) {
            System.err.println("Alta exceptie la add overflow: " + ex.getMessage());
        }

        System.out.println("\n=== Test 4: add(-Double.MAX_VALUE, -Double.MAX_VALUE) ===");
        try {
            calc.add(-Double.MAX_VALUE, -Double.MAX_VALUE);
        } catch (UnderflowException ex) {
            System.err.println("Prins UnderflowException: " + ex.getMessage());
        } catch (NullParameterException | OverflowException ex) {
            System.err.println("Alta exceptie la add underflow: " + ex.getMessage());
        }

        System.out.println("\n=== Test 5: divide() cu fisier valid ===");
        try {
            Double[] twoNumsDiv = readTwoNumbers("numbers_divide.txt");
            double quotient = calc.divide(twoNumsDiv[0], twoNumsDiv[1]);
            System.out.println("Rezultat divide(" + twoNumsDiv[0] + ", " + twoNumsDiv[1] + ") = " + quotient);
        } catch (FileReadException fre) {
            System.err.println("FileReadException la divide: " + fre.getMessage());
        } catch (NullParameterException | MyArithmeticException ex) {
            System.err.println("Eroare la divide: " + ex.getMessage());
        }

        System.out.println("\n=== Test 6: divide(null, 2.0) ===");
        try {
            calc.divide(null, 2.0);
        } catch (NullParameterException ex) {
            System.err.println("Prins NullParameterException la divide: " + ex.getMessage());
        } catch (MyArithmeticException ex) {
            System.err.println("Alta exceptie la divide cu null: " + ex.getMessage());
        }

        System.out.println("\n=== Test 7: divide(5.0, 0.0) ===");
        try {
            calc.divide(5.0, 0.0);
        } catch (MyArithmeticException ex) {
            System.err.println("Prins MyArithmeticException la impartire la zero: " + ex.getMessage());
        } catch (NullParameterException ex) {
            System.err.println("Alta exceptie la divide: " + ex.getMessage());
        }

        System.out.println("\n=== Test 8: average() cu fisier valid ===");
        try {
            Double[] manyNums = readMultipleNumbers("numbers_avg.txt");
            double medie = calc.average(manyNums);
            System.out.println("Rezultat average(...) = " + medie);
        } catch (FileReadException fre) {
            System.err.println("FileReadException la average: " + fre.getMessage());
        } catch (NullParameterException | OverflowException | UnderflowException | MyArithmeticException ex) {
            System.err.println("Eroare la average: " + ex.getMessage());
        }

        System.out.println("\n=== Test 9: average(null) ===");
        try {
            calc.average(null);
        } catch (NullParameterException ex) {
            System.err.println("Prins NullParameterException la average: " + ex.getMessage());
        } catch (OverflowException | UnderflowException | MyArithmeticException ex) {
            System.err.println("Alta exceptie la average cu array null: " + ex.getMessage());
        }

        System.out.println("\n=== Test 10: average(array gol) ===");
        try {
            Double[] empty = new Double[0];
            calc.average(empty);
        } catch (MyArithmeticException ex) {
            System.err.println("Prins MyArithmeticException la average (array gol): " + ex.getMessage());
        } catch (NullParameterException | OverflowException | UnderflowException ex) {
            System.err.println("Alta exceptie la average array gol: " + ex.getMessage());
        }

        System.out.println("\n=== Test 11: average(array cu element null) ===");
        try {
            Double[] arrWithNull = {2.0, null, 5.0};
            calc.average(arrWithNull);
        } catch (NullParameterException ex) {
            System.err.println("Prins NullParameterException la average (element null): " + ex.getMessage());
        } catch (OverflowException | UnderflowException | MyArithmeticException ex) {
            System.err.println("Alta exceptie la average array cu null: " + ex.getMessage());
        }

        System.out.println("\n=== Test 12: average([Double.MAX_VALUE, Double.MAX_VALUE]) ===");
        try {
            Double[] bigs = {Double.MAX_VALUE, Double.MAX_VALUE};
            calc.average(bigs);
        } catch (OverflowException ex) {
            System.err.println("Prins OverflowException la average (suma infinita): " + ex.getMessage());
        } catch (NullParameterException | UnderflowException | MyArithmeticException ex) {
            System.err.println("Alta exceptie la average bigs: " + ex.getMessage());
        }

        System.out.println("\n=== Test 13: readTwoNumbers(fisier_inexistent.txt) ===");
        try {
            Double[] dummy = readTwoNumbers("fisier_inexistent.txt");
            System.out.println("Am citit: " + dummy[0] + ", " + dummy[1]);
        } catch (FileReadException fre) {
            System.err.println("Prins FileReadException: " + fre.getMessage());
        }

        System.out.println("\n=== Test 14: readMultipleNumbers(fisier_invalid.txt) ===");
        try {
            Double[] dummy = readMultipleNumbers("fisier_invalid.txt");
            System.out.println("Am citit array de lungime: " + dummy.length);
        } catch (FileReadException fre) {
            System.err.println("Prins FileReadException: " + fre.getMessage());
        }
    }
}

