package model;


import entities.Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class AvgSalary {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter full file path");
        String path = sc.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            List<Employee> list = new ArrayList<>();
            String line = br.readLine();
            while (line != null) {
                String[] fields = line.split(",");
                list.add(new Employee(fields[0], fields[1], Double.parseDouble(fields[2])));
                line = br.readLine();
            }

            System.out.println("Type the salary that you want to compare to");
            double salaryCompare = sc.nextDouble();

            List<String> emails = list.stream()
                    .filter(employee -> employee.getSalary() > salaryCompare)
                    .map(employee -> employee.getEmail())
                    .sorted().collect(Collectors.toList());

            System.out.println("Email of people whose salary is more than " + String.format("%.2f", salaryCompare) + ":");
            emails.forEach(System.out::println);

            double sum = list.stream()
                    .filter(employee -> employee.getName()
                            .charAt(0) == 'M')
                    .map(employee -> employee.getSalary())
                    .reduce(0.0, (x, y) -> x + y);

            System.out.println("Sum of the salary from people witch names starts with M: " + String.format("%.2f", sum));


        } catch (IOException e) {
            System.out.println("error: " + e.getMessage());
        }
        sc.close();
    }
}
