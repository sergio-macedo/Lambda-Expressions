package model;

import entities.MyComparator;
import entities.Product;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<Product> list = new ArrayList<>();

        list.add(new Product ("Tv", 900.0));
        list.add(new Product ("Tablet", 400.0));
        list.add(new Product ("zaoaNotebook", 1200.0));

      //  Comparator<Product> comparator = (p1,p2) ->
       //    p1.getName().toUpperCase(Locale.ROOT).compareTo(p2.getName().toUpperCase(Locale.ROOT));



        list.sort((p1,p2) ->p1.getName().toUpperCase(Locale.ROOT).compareTo(p2.getName().toUpperCase(Locale.ROOT)));

        for (Product product : list) {
            System.out.println(product);
        }

    }
}
