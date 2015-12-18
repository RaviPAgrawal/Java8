package com.ravi;

import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Created by RaviA on 16-12-2015.
 */
public class FirstPredicate {
    public static void main(String[] args) {
        Stream<String> stream1 = Stream.of("one", "two", "three", "four", "five");
        Predicate<String> p1 = s -> s.length() > 3;
        stream1
                .filter(p1)
                .forEach(System.out::println);

        System.out.println("*****************************");

        Stream<String> stream2 = Stream.of("one", "two", "three", "four", "five");
        Predicate<String> p2 = Predicate.isEqual("two");
        Predicate<String> p3 = Predicate.isEqual("three");
        stream2
                .filter(p2.or(p3))
                .forEach(System.out::println);
    }
}
