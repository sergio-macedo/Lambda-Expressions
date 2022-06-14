package entities;
import java.util.Comparator;
import java.util.Locale;

import entities.Product;

public class MyComparator implements Comparator<Product> {


    @Override
    public int compare(Product p1, Product p2) {
        return p1.getName().toUpperCase(Locale.ROOT).compareTo(p2.getName().toUpperCase(Locale.ROOT));
    }
}