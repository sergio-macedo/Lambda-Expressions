package model;

import entities.MyComparator;
import entities.Product;
import util.ProductPredicate;

import java.util.*;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
        List<Product> list = new ArrayList<>();

        list.add(new Product("Tv", 900.0));
        list.add(new Product("Tablet", 400.0));
        list.add(new Product("Mouse", 40.0));
        list.add(new Product("case", 80.0));

        //list.removeIf(new ProductPredicate()); a way using classes to do it.

        //list.removeIf(Product::staticProductPredicate); using a static method as an argument

        //list.removeIf(Product::nonStaticProductPredicate); using a non static as an argument

        //Predicate<Product> predicate = p -> p.getPrice() >= 100; declarating a predicate before using it.
        list.removeIf(p -> p.getPrice() >= 100);

        for (Product p : list) {
            System.out.println(p);
        }

    }
}
