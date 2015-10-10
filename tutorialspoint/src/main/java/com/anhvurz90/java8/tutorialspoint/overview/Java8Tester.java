/*
 * Copyright (c) Einsights Pte. Ltd. - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited.
 * Proprietary and confidential.
 */

package com.anhvurz90.java8.tutorialspoint.overview;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Java8Tester {

    public static void main(String[] args) {
        List<String> names1 = Arrays.asList("Mahesh", "Suresh", "Ramesh", "Naresh", "Kalpesh");
        List<String> names2 = Arrays.asList("Mahesh", "Suresh", "Ramesh", "Naresh", "Kalpesh");

        Java8Tester tester = new Java8Tester();

        System.out.println("Sort using Java 7 Syntax: ");
        tester.sortUsingJava7(names1);
        System.out.println(names1);

        System.out.println("Sort using Java 8 Syntax: ");
        tester.sortUsingJava8(names2);
        System.out.println(names2);
    }

    private void sortUsingJava7(final List<String> names) {
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        });
    }

    private void sortUsingJava8(final List<String> names) {
        Collections.sort(names, (s1, s2) -> s1.compareTo(s2));
    }

}
