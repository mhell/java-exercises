package se.mattiashellman.lexicon.InheritanceExercise;

import java.time.LocalDate;

public abstract class Employee {
    protected final double BASE_SALARY = 2500;
    private int sequencer;
    private int id;
    private String name;
    private double salary;
    private LocalDate hired;

    public Employee(String name) {
        setId();
        setName(name);
        setHired(LocalDate.now());
    }

    public int getId() {
        return id;
    }

    public void setId() {
        this.id = sequencer++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary){
        this.salary = salary;
    }

    public LocalDate getHired() {
        return hired;
    }

    private void setHired(LocalDate hired) {
        this.hired = hired;
    }

    public abstract void calculateSalary();
}
