package se.mattiashellman.lexicon.exception_exercise;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercises {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        /*
        // Exercise 1: Basic Exception Handling
        try {
            exercise01();
        } catch (ArithmeticException e) {
            System.out.println(e);
        }

        // 2: Multiple Exception Types
        try {
            exercise02();
        } catch (OutOfRangeException | InputMismatchException e) {
            System.out.println(e);
        }

        // Exercise 3: Custom Exception
        BankAccount account = new BankAccount();
        account.deposit(100);
        try {
            account.withdraw(50);
            account.withdraw(51);
        } catch (InsufficientBalanceException e) {
            System.out.println("Insufficient balance: $" + e.getAmount() + " missing.");
        }

        // Exercise 4: Nested try-catch Blocks
        exercise04("src/main/java/se/mattiashellman/lexicon/exception_exercise/exercise04.txt");

        // Exercise 5: finally Block
        exercise04("src/main/java/se/mattiashellman/lexicon/exception_exercise/exercise04.txt");

        // Exercise 6:
        try {
            exercise06();
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }

        // Exercise 7:
        Names names = new Names();
        try {
            names.findName("TeST");
        } catch (NameNotFoundException e) {
            System.out.println(e);
        }
        try {
            names.addName("TEst");
            names.addName("test");
        } catch (DuplicateNameException e) {
            System.out.println(e);
        }

        */

        // Exercise 8:
        exercise08("Test", "src/main/java/se/mattiashellman/lexicon/exception_exercise/exercise08.txt");

    }

    private static void exercise08(String text, String filePath) {
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            fileWriter.write(text);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void exercise06() {
        String email = getStringInput("Enter you email address: ");
        if (!email.matches("^[^@]+@[^@]+\\.[^@]+$")) {
            throw new IllegalArgumentException("Invalid address: " + email);
        }
        System.out.println("Entered string is a valid email address.");
    }

    private static void exercise04(String file) {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
            System.out.println("File successfully opened");
            try {
                int charInt;
                while ((charInt = fileReader.read()) != -1) {
                    try {
                        int i = Integer.parseInt(String.valueOf((char) charInt));
                        System.out.println(i);
                    } catch (NumberFormatException e) {
                        System.out.println(e);
                    }
                }
            } catch (IOException e) {
                System.out.println(e);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } finally {
            try {
                if (fileReader != null) {
                    fileReader.close();
                    System.out.println("File successfully closed");
                }
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }

    private static void exercise02() {
        int number = getIntInput("Enter an integer within the range 1 to 100: ");
        if (!(number >= 1 && number <= 100)) {
            throw new OutOfRangeException(1, 100);
        }
        System.out.println("You entered: " + number);
    }

    static void exercise01() {
        double dividend = Double.parseDouble(getStringInput("Enter dividend: "));
        double divisor = Double.parseDouble(getStringInput("Enter divisor: "));
        if (divisor == 0) throw new ArithmeticException("Division by zero.");
        double quotient = dividend / divisor;
        System.out.println("Quotient: " + quotient);
    }

    private static String getStringInput(String msg) {
        System.out.print(msg);
        return scanner.nextLine();
    }

    private static int getIntInput(String msg) {
        System.out.print(msg);
        return scanner.nextInt();
    }
}

class OutOfRangeException extends RuntimeException {
    private final int min, max;

    public OutOfRangeException(int min, int max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public String getMessage() {
        return "Out of range: " + min + "-" + max;
    }
}

class InsufficientBalanceException extends Exception {
    private final double amount;

    public InsufficientBalanceException(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
}

class BankAccount {
    private double balance;

    public void deposit(double amount) {
        this.balance += amount;
    }

    public void withdraw(double amount) throws InsufficientBalanceException {
        if (balance < amount)
            throw new InsufficientBalanceException(amount-balance);
        this.balance -= amount;
    }

    public double getBalance() {
        return balance;
    }
}

class Names {
    List<String> nameList = new ArrayList<>();

    public String findName(String name) throws NameNotFoundException {
        name = capitalize(name);
        if (!nameList.contains(name)) {
            throw new NameNotFoundException("Name '" + name + "' not found.");
        }
        return name;
    }

    public void addName(String name) throws DuplicateNameException {
        name = capitalize(name);
        if (!nameList.contains(name)) {
            throw new DuplicateNameException("Duplicate entry '" + name + "'");
        }
        nameList.add(name);
    }

    private static String capitalize(String name) {
        return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
    }
}

class NameNotFoundException extends Exception {
    NameNotFoundException(String message) {
        super(message);
    }
}

class DuplicateNameException extends Exception {
    public DuplicateNameException(String message) {
        super(message);
    }
}
