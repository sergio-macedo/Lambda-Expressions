package model;

import entities.Product;
import services.ProductService;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<Product> list = new ArrayList<>();

        list.add(new Product("Tv", 900.0));
        list.add(new Product("Tablet", 400.0));
        list.add(new Product("Mouse", 40.0));
        list.add(new Product("case", 80.0));

        ProductService productService = new ProductService();
        double price = 100;

        double sum = productService.filteredSum(list, product -> product.getPrice() < price);
        System.out.println("Sum =" + String.format("%.2f", sum));







    }
}
