package com.ravi;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
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

            Optional<Employee> employeeOptional = employees.stream().filter(e -> e.getId() > 3)
                    .min(Comparator.comparing(Employee::getId));
            System.out.println(employeeOptional);

            Optional<Employee> employeeOptional2 = employees.stream().max(Comparator.comparing(Employee::getId));
            System.out.println(employeeOptional2);

            Map<Integer, List<Employee>> collect1 = employees.stream()
                    .collect(Collectors.groupingBy(Employee::getId));
            System.out.println(collect1);

            Map<Integer, Long> collect2 = employees.stream()
                    .collect(Collectors.groupingBy(
                            Employee::getId,
                            Collectors.counting()
                        )
                    );
            System.out.println(collect2);

            Map<Integer, List<String>> collect3 = employees.stream()
                    .collect(Collectors.groupingBy(
                                    Employee::getId,
                                    Collectors.mapping(
                                            Employee::getName,
                                            Collectors.toList()
                                    )
                            )
                    );
            System.out.println(collect3);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
