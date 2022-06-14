package model;

import entities.Product;
import util.PriceUpdate;

import java.util.*;
import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) {
        List<Product> list = new ArrayList<>();

        list.add(new Product("Tv", 900.0));
        list.add(new Product("Tablet", 400.0));
        list.add(new Product("Mouse", 40.0));
        list.add(new Product("case", 80.0));

        double factor = 1.1;


        //list.forEach(consumer); // declaring the consumer at the main program.

        // list.forEach(new PriceUpdate()); // using a consumer class and passing it as an argument.
        //list.forEach(Product::staticPriceUpdate);// uses a static method at the Product class
        //list.forEach(Product::PriceUpdate); // uses a non-static method using the parameters from the class
        list.forEach(product -> product.setPrice(product.getPrice() * factor));

        list.forEach(System.out::println);

    }
}
