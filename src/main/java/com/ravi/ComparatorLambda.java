package com.ravi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by RaviA on 15-12-2015.
 */
public class ComparatorLambda {
    public static void main(String[] args) {
        Comparator<Employee> employeeComparator = new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return Integer.compare(o1.getId(), o2.getId());
            }
        };

        List<Employee> employees1 = new ArrayList<>();
        Employee employee1 = new Employee(1, "A");
        Employee employee2 = new Employee(2, "B");
        employees1.add(employee1);
        employees1.add(employee2);

        Collections.sort(employees1, employeeComparator);
        System.out.println(employees1);

        Comparator<Employee> employeeComparatorLambda = (o1, o2) ->
                Integer.compare(o1.getId(), o2.getId());

        List<Employee> employees2 = new ArrayList<>();
        Employee employee3 = new Employee(3, "A");
        Employee employee4 = new Employee(4, "B");
        employees2.add(employee3);
        employees2.add(employee4);

        Collections.sort(employees2, employeeComparatorLambda);
        System.out.println(employees2);

    }
}
