package se.mattiashellman.lexicon;

public class DoABunchOfThings {

    private static int guessInput = 0;

    public static String hello() {
        return "Hello\nMattias!";
    }

    public static Boolean isLeapYear(int year) {
        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
    }

    public static String arithmetics() {
        return  "45 + 11 = " + (45+11) + "\n" +
                "12 * 4 = " + (12*4) + "\n" +
                "24 / 6 = " + (24/6) + "\n" +
                "55 – 12 = " + (55-12) + "\n";
    }

    public static String avarage() {
        return "(23 + 11 + 77) / 3 = " + ((23 + 11 + 77) / 3);
    }

    public static String greet(String name) {
        return "Hello " + name + "!";
    }

    public static String arithmetics(int a, int b) {
        return  a + " + " + b + " = " + (a+b) + "\n" +
                a + " * " + b + " = " + (a*b) + "\n" +
                a + " / " + b + " = " + ((float)a/b) + "\n" +
                a + " - " + b + " = " + (a-b);
    }

    public static String convertSeconds(int seconds) {
        int hours = seconds / 3600;
        int minutes = seconds % 3600 / 60;
        return hours + ":" + minutes + ":" + seconds % 60;
    }

    public static void setGuessInput(int input) {
        guessInput = input;
    }

    public static int guessNumber(int input) {
        if (input > guessInput) {
            return 1;
        } else if (input < guessInput) {
            return -1;
        } else {
            return 0;
        }
    }
}
