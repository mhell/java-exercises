package se.mattiashellman.lexicon.InheritanceExercise;

import java.util.Arrays;

public class SalesPerson extends Employee {
    private final double CLIENT_EXTRA = 500, ACQUIRED_EXTRA = 1000;
    private String[] clients = new String[0];
    private String[] acquiredClients = new String[0];

    public SalesPerson(String name, String[] clients, String[] acquiredClients) {
        super(name);
        addClients(clients);
        addAcquiredClients(acquiredClients);
    }

    public String[] getClients() {
        return clients;
    }

    public void addClients(String[] clientsToAdd) {
        String[] newClients = Arrays.copyOf(this.clients, this.clients.length + clientsToAdd.length);
        System.arraycopy(clientsToAdd, 0, newClients, this.clients.length, clientsToAdd.length);
        this.clients = newClients;
        calculateSalary();
    }

    public String[] getAcquiredClients() {
        return acquiredClients;
    }

    // TODO: should acquired clients be maintained by this SalesPerson?
    public void addAcquiredClients(String[] acquiredClientsToAdd) {
        String[] newAcquiredClients = Arrays.copyOf(this.acquiredClients, this.acquiredClients.length + acquiredClientsToAdd.length);
        System.arraycopy(acquiredClientsToAdd, 0, newAcquiredClients, this.acquiredClients.length, acquiredClientsToAdd.length);
        this.acquiredClients = newAcquiredClients;
        calculateSalary();
    }

    @Override
    public void calculateSalary() {
        setSalary(BASE_SALARY + (CLIENT_EXTRA * clients.length) + (ACQUIRED_EXTRA * acquiredClients.length));
    }

    @Override
    public String toString() {
        return String.format("ID: %d, name: %s, hired: %s, salary: %.1f, clients: %s, acquired clients: %s",
                getId(), getName(), getHired(), getSalary(), Arrays.toString(getClients()), Arrays.toString(getAcquiredClients()));
    }
}
