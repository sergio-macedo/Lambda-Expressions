package model;

import entities.Product;
import util.UppercaseName;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Product> list = new ArrayList<>();

        list.add(new Product("Tv", 900.0));
        list.add(new Product("Tablet", 400.0));
        list.add(new Product("Mouse", 40.0));
        list.add(new Product("case", 80.0));

        Function<Product,String > function = product -> {
           return product.getName().toUpperCase(Locale.ROOT);
        };


        //List<String> names = list.stream().map(new UppercaseName()).collect(Collectors.toList()); //use a new class to make the uppercase
        //List<String> names = list.stream().map(Product::staticUpperCaseName).collect(Collectors.toList()); //use a static method to define the Uppercase
        //List<String> names = list.stream().map(Product::nonStaticUpperCaseName).collect(Collectors.toList()); //use a non-static method to define the Uppercase
        //List<String> names = list.stream().map(function).collect(Collectors.toList()); //Using a declare function inside the main program.
        List<String> names = list.stream().map(product -> product.getName().toUpperCase(Locale.ROOT)).collect(Collectors.toList()); //the last one. the lambda function is written inside the map argument


        names.forEach(System.out::println);




    }
}
