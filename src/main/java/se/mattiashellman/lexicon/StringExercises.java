package se.mattiashellman.lexicon;

import java.util.Arrays;

public class StringExercises {
    public static void main(String[] args) {
        System.out.println("Java".length());

        System.out.println("Even longer example sentence".charAt(6));

        String s = "Ok this is not as long!";
        String substring = s.substring(11);
        System.out.println(substring);

        s = "CAPS EQUALS SCREAMING".toLowerCase();
        System.out.println(s);
        s = s.toUpperCase();
        System.out.println(s);

        System.out.println("Java is the worst programming language!".replace("worst", "best"));

        System.out.println("\tJ\ta\tv\ta\t".trim());

        int i = 20;
        System.out.println(String.valueOf(i) + 20);

        s = "Oil and Water";
        String[] sArray = s.split(" and ");
        System.out.println(Arrays.toString(sArray));

        s = "Carl,Susie,Fredrick,Bob,Erik";
        sArray = s.split(",");
        for (String name : sArray) {
            System.out.println(name);
        }

        s = "ThisShouldBeConverted";
        char[] cArray = s.toCharArray();
        for (char c : cArray) {
            System.out.print(c);
        }

        System.out.println();

        cArray = new char[] {'J', 'a', 'v', 'a'};
        s = new String(cArray);
        System.out.println(s);
        s = String.valueOf(cArray);
        System.out.println(s);
    }
}