package se.mattiashellman.lexicon;

import java.util.Scanner;

public class BasicExercises {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        showMenu();
    }

    private static void showMenu() {
        do {
            System.out.println("""
                    Hello! What do you want to do?\s
                    1. Say hello to me.\s
                    2. Check if a year is a leap year or not\s
                    3. Do arithmetics of two numbers\s
                    4. Calculate the average of three numbers\s
                    5. Be greeted!\s
                    6. Do arithmetics of ANY two numbers\s
                    7. Convert seconds to hours, minutes and seconds\s
                    8 Guess the number""");
            System.out.print("> ");
            executeMethod(scanner.nextLine());
            System.out.println("Continue? (y/n)");
        } while (!scanner.nextLine().equalsIgnoreCase("n"));
    }

    private static void executeMethod(String choice) {
        String result = null;

        switch (choice) {
            case "1":
                result = DoABunchOfThings.hello();
                break;
            case "2":
                System.out.print("Enter a year: ");
                try {
                    result = DoABunchOfThings.isLeapYear(Integer.parseInt(scanner.nextLine())) ?
                    "That year is a leap year" : "That year is not a leap year";
                } catch (NumberFormatException e) {
                    result = "Value is not a year.";
                }
                break;
            case "3":
                result = DoABunchOfThings.arithmetics();
                break;
            case "4":
                result = DoABunchOfThings.avarage();
                break;
            case "5":
                System.out.print("Enter your name: ");
                result = DoABunchOfThings.greet(scanner.nextLine());
                break;
            case "6":
                try {
                    System.out.print("Enter number one: ");
                    int a = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter number two: ");
                    int b = Integer.parseInt(scanner.nextLine());
                    result = DoABunchOfThings.arithmetics(a, b);
                } catch (NumberFormatException e) {
                    result = "Values are not numbers.";
                }
                break;
            case "7":
                System.out.print("Enter seconds: ");
                try {
                    result = DoABunchOfThings.convertSeconds(Integer.parseInt(scanner.nextLine()));
                } catch (NumberFormatException e) {
                    result = "Value is not seconds.";
                }
                break;
            case "8":
                System.out.print("Guess a number between 1 and 500: ");
                int guesses = 0;
                DoABunchOfThings.setGuessInput((int)(Math.random() * 500 + 1));
                try {
                    while (true) {
                        guesses++;
                        int lowOrHigh = DoABunchOfThings.guessNumber(Integer.parseInt(scanner.nextLine()));
                        result = switch (lowOrHigh) {
                            case 0 -> "You guessed right in " + guesses + " guesses.";
                            case 1 -> "Your guess was too high. Guess again.";
                            case -1 -> "Your guess was too low. Guess again.";
                            default -> result;
                        };
                        if (lowOrHigh == 0) break;
                        System.out.println(result);
                    }
                } catch (NumberFormatException e) {
                    result = "Value is not a number.";
                }
                break;
            default:
                result = "Select an option between 1 and 7.";
        }

        System.out.println(result);
    }
}
