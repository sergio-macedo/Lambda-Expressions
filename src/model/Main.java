package model;


import entities.Product;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter full file path");
        String path = sc.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            List<Product> list = new ArrayList<>();
            String line = br.readLine();
            while (line != null) {
                String[] fields = line.split(",");
                list.add(new Product(fields[0], Double.parseDouble(fields[1])));
                line = br.readLine();
            }
            double avg = list.stream().map(product -> product.getPrice())
                    .reduce(0.0, (x, y) -> x + y / list.size());

            System.out.println("the average price is: " + avg);

            Comparator<String> comp = Comparator.comparing(s -> s.toUpperCase(Locale.ROOT));

            List<String> names = list.stream().filter(p -> p.getPrice() < avg).map(p -> p.getName())
                    .sorted(comp.reversed()).collect(Collectors.toList());

            names.forEach(System.out::println);


        } catch (IOException e) {
            System.out.println("error: " + e.getMessage());
        }
        sc.close();
    }
}
