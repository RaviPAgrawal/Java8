package com.ravi;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Created by RaviA on 18-12-2015.
 */
public class CollectorsExample {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        File file = new File("D:\\Java8Tutorial\\Java8\\src\\main\\java\\com\\ravi\\Employee.txt");
        try (
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader=new BufferedReader(fileReader);
        Stream<String> stream = bufferedReader.lines();
        ) {
            stream.map(
                    line -> {
                        String[] strings = line.split(" ");
                        Employee e = new Employee(Integer.parseInt(strings[1]), strings[0].trim());
                        employees.add(e);
                        return e;
                    }
            ).forEach(System.out::println);

            Stream<Employee> stream1 = employees.stream();
            Optional<Employee> employeeOptional = stream1.filter(e -> e.getId() > 3)
                    .min(Comparator.comparing(Employee::getId));
            System.out.println(employeeOptional);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
