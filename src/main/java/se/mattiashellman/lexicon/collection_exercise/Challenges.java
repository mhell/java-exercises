package se.mattiashellman.lexicon.collection_exercise;

import java.util.*;

public class Challenges {

    public static void main(String[] args) {
        // 1
        Set<String> allDays = new HashSet<>(Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"));
        System.out.println(allDays);

        Set<String> weekend = new HashSet<>(Arrays.asList("Saturday", "Sunday"));

        allDays.retainAll(weekend);
        System.out.println(allDays);

        System.out.println();

        // 2
        Map<String, String> emails = new HashMap<>();
        emails.put("nisse@gmail.com", "Nisse");
        emails.put("erik@gmail.com", "Erik");
        emails.put("Kajsa@outlook.com", "Kajsa");

        Set<String> nameSet = new HashSet<>(emails.keySet());
        System.out.println(nameSet);

        System.out.println();

        // 3
        Superhero hero1 = new Superhero("Spiderman", 63);
        Superhero hero2 = new Superhero("Aquaman", 84);
        Superhero hero3 = new Superhero("Storm", 50);
        Superhero hero4 = new Superhero("Superman", 86);
        List<Superhero> superheroes = new ArrayList<>(Arrays.asList(hero1, hero2, hero3, hero4));
        System.out.println(superheroes);
        Collections.sort(superheroes);
        System.out.println(superheroes);

        System.out.println();

        // 4
        Integer[] numbers = new Integer[]{1,4,4,2,6,7};
        System.out.println(Arrays.toString(numbers));
        Set<Integer> numbersSet = new HashSet<>(Arrays.asList(numbers));
        System.out.println(numbersSet);

        int[] numbers2 = new int[]{1,4,4,2,6,7};
        Set<Integer> numbersSet2 = new HashSet<>();
        for (int n : numbers2){
            numbersSet2.add(n);
        }
        System.out.println(numbersSet2);

    }
}

class Superhero implements Comparable<Superhero> {
    private static int sequencer;
    private final int id;
    private String name;
    private int age;

    public Superhero(String name, int age) {
        this.id = sequencer++;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Superhero o) {
        return Integer.compare(this.age, o.age);
    }

    @Override
    public String toString() {
        return "Superhero{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", age=" + getAge() +
                '}';
    }
}
