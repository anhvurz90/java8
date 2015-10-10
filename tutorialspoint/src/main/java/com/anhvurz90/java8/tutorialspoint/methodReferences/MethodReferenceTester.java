/*
 * Copyright (c) Einsights Pte. Ltd. - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited.
 * Proprietary and confidential.
 */

package com.anhvurz90.java8.tutorialspoint.methodReferences;

import java.util.Arrays;
import java.util.List;

public class MethodReferenceTester {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Mahesh", "Suresh", "Ramesh", "Naresh", "Kalpesh");
        names.forEach(System.out::println);
    }
}
