/*
 * Copyright (c) Einsights Pte. Ltd. - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited.
 * Proprietary and confidential.
 */

package com.anhvurz90.java8.tutorialspoint.functionalInterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class FunctionalInterfaceTester {

    public static void main(String[] args) {

        List<Integer> ints = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        // Predicate<Integer> predicate = n -> true;
        System.out.println("Print all numbers: ");
        eval(ints, n -> true);

        // Predicate<Integer> predicate1 = n -> n%2 -- 0
        System.out.println("Print even numbers:");
        eval(ints, n -> n % 2 == 0);

        // Predicate<Integer> predicate2 = n -> n > 3
        System.out.println("Print numbers greater than 3:");
        eval(ints, n -> n > 3);
    }

    static void eval(List<Integer> ints, Predicate<Integer> predicate) {
        ints.forEach(n -> {
            if (predicate.test(n)) {
                System.out.println(n);
            }
        });
    }
}
