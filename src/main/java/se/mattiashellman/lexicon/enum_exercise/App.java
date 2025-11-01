package se.mattiashellman.lexicon.enum_exercise;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        do {
            for (Dice dice : Dice.values()) {
                System.out.println("Roll of " + dice + " is: " + dice.roll());
            }
            System.out.print("\nTry again? Y/N: ");
        } while (s.nextLine().equalsIgnoreCase("y"));
    }
}
