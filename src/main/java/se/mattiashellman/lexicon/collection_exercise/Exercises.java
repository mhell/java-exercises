package se.mattiashellman.lexicon.collection_exercise;

import java.util.*;

public class Exercises {

    public static void main(String[] args) {
        // 1
        List<String> weekDays = new ArrayList<String>();
        weekDays.add("Monday");
        weekDays.add("Tuesday");
        weekDays.add("Wednesday");
        weekDays.add("Thursday");
        weekDays.add("Friday");
        weekDays.add("Saturday");
        weekDays.add("Sunday");
        System.out.println(weekDays);

        System.out.println();

        // 2
        //for (String weekDay : weekDays) {
        //    System.out.print(weekDay + " ");
        //}
        weekDays.forEach((day) -> System.out.print(day + " "));

        System.out.println("\n");

        // 3
        weekDays = new ArrayList<String>();
        weekDays.add("Monday");
        weekDays.add("Tuesday");
        weekDays.add("Wednesday");
        weekDays.add("Friday");
        weekDays.add("Saturday");
        weekDays.add("Sunday");
        weekDays.add(3, "Thursday");
        System.out.println(weekDays);

        System.out.println();

        // 4
        List<String> subList = weekDays.subList(0, 3);
        System.out.println(subList);

        System.out.println();

        // 5
        Set<String> weekDaysSet = new HashSet<String>();
        weekDaysSet.add("Monday");
        weekDaysSet.add("Tuesday");
        weekDaysSet.add("Wednesday");
        weekDaysSet.add("Friday");
        weekDaysSet.add("Saturday");
        weekDaysSet.add("Sunday");
        System.out.println(weekDaysSet);

        System.out.println();

        // 6
        weekDays = new ArrayList<String>(weekDaysSet);
        System.out.println(weekDays);

        System.out.println();

        // 7
        Set<String> names = new HashSet<String>();
        names.add("Erik");
        names.add("Nisse");
        names.add("Anders");
        names.add("Kajsa");
        List<String> namesList = new ArrayList<String>(names);
        System.out.println(names);
        namesList.addLast(namesList.get(1));
        namesList.addLast(namesList.get(3));
        namesList.addLast(namesList.get(2));
        namesList.addLast(namesList.get(0));
        namesList = namesList.subList(4, 8);
        System.out.println(namesList);

        System.out.println();

        // 8
        names.clear();
        names.add("Erik");
        names.add("Nisse");
        names.add("Anders");
        names.add("Kajsa");
        namesList = new ArrayList<String>(names);
        System.out.println(namesList);
        namesList.sort(String.CASE_INSENSITIVE_ORDER);
        System.out.println(namesList);
        //Collections.sort(namesList);
        //System.out.println(namesList);

        System.out.println();

        // 9
        HashMap<Integer, String> cars = new HashMap<Integer, String>();
        cars.put(1, "Volvo");
        cars.put(2, "Lancia");
        cars.put(3, "Toyota");
        cars.put(4, "Subaru");
        System.out.println(cars);

        System.out.println();

        // 10
        System.out.println(cars.keySet());

        System.out.println();

        // 11
        System.out.println(cars.values());

        System.out.println();

        // 12
        HashMap<Integer, Car> cars2 = new HashMap<Integer, Car>();
        cars2.put(1, new Car("Volvo", "940"));
        cars2.put(2, new Car("Lancia", "Stratos"));
        cars2.put(3, new Car("Toyota", "Celica"));
        cars2.put(4, new Car("Subaru", "impreza"));
        System.out.println(cars2.values());

    }
}

class Car {
    private static int sequencer;
    private final int id;
    private String brand;
    private String model;

    public Car(String brand, String model) {
        this.id = sequencer++;
        this.brand = brand;
        this.model = model;
    }

    public int getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return getBrand();
    }
}
