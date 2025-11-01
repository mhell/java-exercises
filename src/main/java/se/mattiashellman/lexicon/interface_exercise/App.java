package se.mattiashellman.lexicon.interface_exercise;

public class App {

    public static void main(String[] args) {
        Calculator calculator = new ConcreteCalculator();

        System.out.println("Enter operator");
        Calculator.getOperator();

        System.out.println("Enter first operand");
        Calculator.getFirstOperand();

        System.out.println("Enter second operand");
        Calculator.getSecondOperand();

        double result = calculator.calculate();
        System.out.println("The result is: " + result);
    }
}
