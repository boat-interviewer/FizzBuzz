package org.vanis;

import java.util.function.Predicate;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        Predicate<Object> fizz = i -> i instanceof Integer && (Integer)i % 3 == 0;
        Predicate<Object> buzz = i -> i instanceof Integer && (Integer)i % 5 == 0;
        Predicate<Object> fizzBuzz = fizz.and(buzz);

        Stream.iterate(1, i -> i + 1)
                .map(i -> fizzBuzz.test(i) ? "FizzBuzz" : i)
                .map(i -> fizz.test(i) ? "Fizz" : i)
                .map(i -> buzz.test(i) ? "Buzz" : i)
                .limit(20)
                .forEach(System.out::println);

    }



}
