package se.mattiashellman.lexicon.interface_exercise;

import java.util.Scanner;

public interface Calculator {
    Scanner scanner = new Scanner(System.in);
    Instructions instructions = new Instructions();

    double addition(double a, double b);
    double subtraction(double a, double b);
    double multiplication(double a, double b);
    double division(double a, double b);

    static void getOperator() {
        instructions.operator = scanner.next();
    }

    static void getFirstOperand() {
        instructions.firstOperand = Double.parseDouble(scanner.next());
    }

    static void getSecondOperand() {
        instructions.secondOperand = Double.parseDouble(scanner.next());
    }

    default double calculate() {
        return switch (instructions.operator) {
            case "+" -> addition(instructions.firstOperand, instructions.secondOperand);
            case "-" -> subtraction(instructions.firstOperand, instructions.secondOperand);
            case "*" -> multiplication(instructions.firstOperand, instructions.secondOperand);
            case "/" -> division(instructions.firstOperand, instructions.secondOperand);
            default -> throw new IllegalArgumentException("Unknown operator " + instructions.operator);
        };
    }

    class Instructions {
        private String operator;
        private double firstOperand;
        private double secondOperand;
    }
}
