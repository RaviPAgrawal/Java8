package com.ravi;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Created by RaviA on 18-12-2015.
 */
public class ReductionExample {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        int res1 = list1.stream()
                .reduce(0, (i1, i2) -> i1 + i2); //.reduce(0, Integer::sum);
        System.out.println(res1);
        System.out.println("*****************************");

        List<Integer> list2 = Arrays.asList(1, 2, 3);
        Optional<Integer> res2 = list2.stream()
                .reduce(Integer::max); //.reduce(0, Integer::sum);
        System.out.println(res2);
        System.out.println("*****************************");

        List<Integer> list3 = Arrays.asList();
        Optional<Integer> res3 = list3.stream()
                .reduce(Integer::max); //.reduce(0, Integer::sum);
        System.out.println(res3);
        System.out.println("*****************************");

        List<Integer> list4 = Arrays.asList();
        Optional<Integer> res4 = list4.stream()
                .reduce(Integer::max); //.reduce(0, Integer::sum);
        System.out.println(res4.orElse(100));
        System.out.println("*****************************");

    }
}
