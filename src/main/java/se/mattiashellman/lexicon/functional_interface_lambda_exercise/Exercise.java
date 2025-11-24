package se.mattiashellman.lexicon.functional_interface_lambda_exercise;

import java.util.List;

class Product {
    private String productName;
    private double price;
    private int stock;

    public Product(String productName, double price, int stock) {
        this.productName = productName;
        this.price = price;
        this.stock = stock;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                '}';
    }
}

interface Conditional {
    boolean test(Product p);
}

interface Action {
    void execute(Product p);
}

public class Exercise {
    private  static final List<Product> products = List.of(
            new Product("Apple", 200, 0),
            new Product("Banana", 120, 8),
            new Product("Pineapple", 130, 12),
            new Product("Blueberry", 10, 0)
    );

    private static void doStuff(List<Product> products, Conditional conditional, Action action) {
        products.forEach(product -> {
            if (conditional.test(product)) action.execute(product);
        });
    }

    public static void main(String[] args) {
        // 1. Print out all Products that have stock value of 0
        doStuff(products,
                p -> p.getStock() == 0,
                System.out::println);

        System.out.println();

        // 2. Print out the productName of all the Products that starts with B.
        doStuff(products,
                p -> p.getProductName().startsWith("B"),
                p -> System.out.println(p.getProductName()));

        System.out.println();

        // 3. Print out all Products that have price above 100 AND lower than 150
        doStuff(products,
                p -> p.getPrice() > 100 && p.getPrice() < 150,
                System.out::println);

        System.out.println();

        // 4. Increase the price of all Products that have a stock value of less than 10 AND above 0 by 50%
        doStuff(products,
                p -> p.getStock() < 10 && p.getStock() > 0,
                p -> p.setPrice(p.getPrice() * 1.5));
        System.out.println(products);
    }
}
