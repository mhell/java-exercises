package se.mattiashellman.lexicon;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ArrayExercises {

    public static void main(String[] args) {

        // 1
        int[] intArray = {11, 23, 39, 45, 57};
        for (int i : intArray) {
            System.out.print(i + " ");
        }

        System.out.println("\n");

        // 2
        Integer[] integerArray = {21, 13, 39, 7, 5};
        Integer find = 13;
        int index = indexOf(integerArray, find);
        System.out.println((index >= 0) ? "Index position of " + find + " is: " + index : "Index not found");

        String[] stringArray = {"Paris", "London", "New York", "Stockholm"};
        String findString = "Stockholm";
        index = indexOf(stringArray, findString);
        System.out.println((index >= 0) ? "Index position of " + findString + " is: " + index : "Index not found");

        System.out.println();

        // 3
        System.out.println("String array: " + Arrays.toString(stringArray));
        Arrays.sort(stringArray);
        System.out.println("Sort string array: " + Arrays.toString(stringArray));

        System.out.println();

        // 4
        int[] intArrayCopy = Arrays.copyOf(intArray, intArray.length);
        System.out.println("Elements from first array: " + Arrays.toString(intArray));
        System.out.println("Elements from second array: " + Arrays.toString(intArrayCopy));

        System.out.println();

        // 5
        String[][] countries = {
                {"France", "Paris"},
                {"Sweden", "Stockholm"}
        };
        for (String[] country : countries)
            System.out.println(country[0] + " " + country[1]);

        System.out.println();

        // 6
        intArray = new int[]{43, 5, 23, 17, 2, 14};
        double average = (double)IntStream.of(intArray).sum() / intArray.length;
        System.out.printf("Average is: %.1f", average);

        System.out.println("\n");

        // 7
        intArray = new int[]{1, 2, 4, 7, 9, 12, 15, 20, 24, 29};
        StringBuilder wholeArray = new StringBuilder();
        StringBuilder oddArray = new StringBuilder();
        for (int i : intArray) {
            wholeArray.append(i).append(" ");
            if (i % 2 != 0) oddArray.append(i).append(" ");
        }
        System.out.printf("Array: %s \nOdd Array: %s\n", wholeArray, oddArray);

        System.out.println();

        // 8
        intArray = new int[]{20, 20, 40, 20, 30, 40, 50, 60, 50};
        System.out.printf("Array: %s\n", Arrays.toString(intArray));
        int[] set = removeDuplicates(intArray);
        System.out.printf("Array without duplicate values: : %s\n", Arrays.toString(set));

        stringArray = new String[]{"Paris", "London", "Paris", "New York", "Stockholm", "Paris", "Stockholm"};
        System.out.printf("Array: %s\n", Arrays.toString(stringArray));
        String[] stringSet = removeDuplicates(stringArray);
        System.out.printf("Array without duplicate values: : %s\n", Arrays.toString(stringSet));

        System.out.println();

        // 9
        stringArray = new String[]{"Erik"};
        String[] newStringArray = addElement(stringArray, new String[]{"Ulf", "Simon", "Kent"});
        System.out.printf("String array: %s \nLonger String array: %s\n", Arrays.toString(stringArray), Arrays.toString(newStringArray));
        integerArray = new Integer[]{1};
        Integer[] newIntegerArray = addElement(integerArray, new Integer[]{2, 3, 4});
        System.out.printf("Integer array: %s \nLonger Integer array: %s\n", Arrays.toString(integerArray), Arrays.toString(newIntegerArray));

        System.out.println();

        // 10
        int[][] multiTable = {
                {1,  2,  3,  4,  5,  6,  7,  8,  9,  10},
                {2,  4,  6,  8,  10, 12, 14, 16, 18, 20},
                {3,  6,  9,  12, 15, 18, 21, 24, 27, 30},
                {4,  8,  12, 16, 20, 24, 28, 32, 36, 40},
                {5,  10, 15, 20, 25, 30, 35, 40, 45, 50},
                {6,  12, 18, 24, 30, 36, 42, 48, 54, 60},
                {7,  14, 21, 28, 35, 42, 49, 56, 63, 70},
                {8,  16, 24, 32, 40, 48, 56, 64, 72, 80},
                {9,  18, 27, 36, 45, 54, 63, 72, 81, 90},
                {10, 20, 30, 40, 50, 60, 70, 80, 90, 100}
        };
        for (int[]i : multiTable)
                System.out.println(Arrays.toString(i));

        System.out.println();

        // 11
        intArray = createArray();
        System.out.printf("You created array: %s\n", Arrays.toString(intArray));
        reverse(intArray);
        System.out.printf("The reverse array: %s", Arrays.toString(intArray));

        System.out.println("\n");

        // 12
        Integer[][] twoDArray = {
            {1, 2, 3},
            {2, 4, 6},
            {3, 6, 9}
        };
        print2DArray(twoDArray);

        System.out.println("\n");

        // 13
        int size = (int)(Math.random() * 10);
        int[] random = new int[size];
        for (int i = 0; i < random.length; i++)
            random[i] = (int)(Math.random() * 10);
        int[] randomOrdered = arrangeOddEven(random);
        System.out.printf("Random: %s\n", Arrays.toString(random));
        System.out.printf("Random ordered by odd -> even: %s\n", Arrays.toString(randomOrdered));
    }

    /* non type safe
    private static <T> int indexOf(Comparable<T>[] a, T i) {
        Arrays.sort(a);
        return Arrays.binarySearch(a, i);
    }*/

    private static <T extends Comparable<? super T>> int indexOf(T[] a, T i) {
        int index = 0;
        for (T item : a) {
            if (item.compareTo(i) == 0)
                return index;
            index++;
        }
        return -1;
    }

    private static int[] removeDuplicates(int[] a) {
        Arrays.sort(a);
        int[] set = new int[a.length];
        int last = set[0] = a[0];
        int setLength = 1;
        for (int i = 1; i < a.length; i++) {
            if (a[i] != last) {
                last = set[setLength++] = a[i];
            }
        }
        return Arrays.copyOf(set, setLength);
    }

    // generic version of removeDuplicates
    private static <T> T[] removeDuplicates(T[] a) {
        Arrays.sort(a);
        T[] set = Arrays.copyOf(a, a.length); // generic array creation not allowed (with new)!
        T last = set[0] = a[0];
        int setLength = 1;
        for (int i = 1; i < a.length; i++) {
            if (a[i] != last) {
                last = set[setLength++] = a[i];
            }
        }
        return Arrays.copyOf(set, setLength);
    }

    private static <T> T[] addElement(T[] original, T[] elements) {
        T[] newArray = Arrays.copyOf(original, original.length + elements.length);
        for (int i=original.length, j=0; i < newArray.length; i++, j++) {
            newArray[i] = elements[j];
        }
        return newArray;
    }

    private static int[] createArray() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an integer to insert into the array, stop by entering 'q': ");
        int[] intArray = new int[0];
        String input;
        while (Character.isDigit((input = scanner.next()).charAt(0))) {
            intArray = Arrays.copyOf(intArray, intArray.length + 1);
            intArray[intArray.length-1] = Integer.parseInt(input);
        }
        return intArray;
    }

    private static void reverse (int[] a) {
        int[] tmpArray = Arrays.copyOf(a, a.length);
        for (int i = 0; i < a.length; i++) {
            a[i] = tmpArray[tmpArray.length-1-i];
        }
    }

    private static <T> void print2DArray(T[][] a) {
        for (int i=0; i<a.length; i++)
            System.out.print(a[i][i] + " ");
    }

    // okTODO: buggy - need to keep track of last inserts (front / back)
    private static int[] arrangeOddEven(int[] a) {
        int[] ordered = new int[a.length];
        int indexFront = 0, indexBack = ordered.length - 1;
        for (int i : a) {
            if (i % 2 != 0)
                ordered[indexFront++] = i;
            else
                ordered[indexBack--] = i;
        }
        return ordered;
    }
}
