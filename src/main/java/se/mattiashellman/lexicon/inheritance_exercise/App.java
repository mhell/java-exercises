package se.mattiashellman.lexicon.inheritance_exercise;

public class App {

    public static void main(String[] args) {
        SystemDeveloper dev = new SystemDeveloper("Erik Olsson", new String[]{"AWS", "Docker"}, new String[]{"Java"});
        System.out.println(dev);
        dev.addLanguages(new String[]{"C++"});
        System.out.println(dev);

        System.out.println("-----");

        SalesPerson seller = new SalesPerson("Olle Eriksson", new String[]{"Volvo", "IKEA"}, new String[]{"ICA"});
        System.out.println(seller);
        seller.addAcquiredClients(new String[]{"Microsoft"});
        System.out.println(seller);

    }
}
