package com.ravi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by RaviA on 15-12-2015.
 */
public class IterateListLambda {
    public static void main(String[] args) {

        //Iterate over list of employees and print out each employee's details
        List<Employee> employees = new ArrayList<>();
        Employee employee1 = new Employee(1, "A");
        Employee employee2 = new Employee(2, "B");
        employees.add(employee1);
        employees.add(employee2);

        employees.forEach(e -> System.out.println(e));
        employees.forEach(System.out :: println);

        //Iterate over input list and add its data in result list
        List<String> input = Arrays.asList("one", "two", "three");
        List<String> result = new ArrayList<>();
        Consumer<String> printInputListConsumer = System.out::println;
        Consumer<String> addToResultListConsumer = result :: add; //Consumer<String> addToResultListConsumer = s -> result.add(s);
        input.forEach(printInputListConsumer.andThen(addToResultListConsumer));
        System.out.println(result);
    }
}
