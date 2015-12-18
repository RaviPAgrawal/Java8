package com.ravi;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Created by RaviA on 16-12-2015.
 */
public class IntermediaryAndFinal {


    public static void main(String[] args) {

        //An Operation on a stream that returns a stream is an intermediary operation

        Stream<String> stream1 = Stream.of("one", "two", "three", "four", "five");
        Predicate<String> p1 = Predicate.isEqual("two");
        stream1.filter(p1); //This is an intermediary operation and it does nothing!


        /*
            The below piece of code does nothing!
            peek() and filter() methods are intermediary operations as they return a stream.
            Hence, this code does not prints anything.
            It is just a simple declaration.
         */
        List<String> result1 = new ArrayList<>();
        Stream<String> stream2 = Stream.of("one", "two", "three", "four", "five");
        Predicate<String> p2 = Predicate.isEqual("two");
        stream2
                .peek(System.out::println)
                .filter(p2)
                .peek(result1 :: add);
        System.out.println("size -> "+result1.size());

        System.out.println("******************************************");
        /*
            Using Final method (forEach())
            Only the Final operation triggers the processing of the data the stream is connected to.
         */
        List<String> result2 = new ArrayList<>();
        Stream<String> stream3 = Stream.of("one", "two", "three", "four", "five");
        Predicate<String> p3 = Predicate.isEqual("two");
        Predicate<String> p4 = Predicate.isEqual("three");
        stream3
                .peek(System.out::println)
                .filter(p3.or(p4))
                .forEach(result2::add);
        System.out.println("size -> "+result2.size());


    }
}
