package com.ravi;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Created by RaviA on 18-12-2015.
 */
public class FlatMapExample {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        List<Integer> list2 = Arrays.asList(2, 4, 6);
        List<Integer> list3 = Arrays.asList(3, 5, 7);

        List<List<Integer>> res1 = Arrays.asList(list1, list2, list3);
        System.out.println(res1);

        System.out.println("******************************");

        Function<List<?>, Integer> size = List::size;
        res1.stream()
                .map(size)
                .forEach(System.out::println);

        System.out.println("******************************");

        /*
            FlatMap returns stream of streams.
            list1, list2 and list3 will all have separate streams.
            In the below code, .map() is used, hence it will map the actual streams of list1, list2, list3
            and those streams get printed in the forEach
         */
        List<List<Integer>> res2 = Arrays.asList(list1, list2, list3);
        Function<List<Integer>, Stream<Integer>> flatMapper1 = l -> l.stream();
        res2.stream()
                .map(flatMapper1)
                .forEach(System.out::println);

        System.out.println("******************************");

        /*
            The below code will take all the three streams of list1, list2, list3
            and then will convert them into a single stream.
            Thus we get a stream of just one list and hence the actual data gets printed in forEach
         */
        List<List<Integer>> res3 = Arrays.asList(list1, list2, list3);
        Function<List<Integer>, Stream<Integer>> flatMapper2 = l -> l.stream();
        res3.stream()
                .flatMap(flatMapper2)
                .forEach(System.out::println);

        System.out.println("******************************");

        List<List<Integer>> res4 = Arrays.asList(list1, list2, list3);
        Predicate<Integer> p1 = i -> i > 3;
        Function<List<Integer>, Stream<Integer>> flatMapper3 = l -> l.stream();
        res4.stream()
                .flatMap(flatMapper3)
                .filter(p1)
                .forEach(System.out::println);

    }

}
