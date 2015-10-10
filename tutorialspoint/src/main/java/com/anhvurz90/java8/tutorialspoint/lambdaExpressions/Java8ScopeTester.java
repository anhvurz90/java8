/*
 * Copyright (c) Einsights Pte. Ltd. - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited.
 * Proprietary and confidential.
 */

package com.anhvurz90.java8.tutorialspoint.lambdaExpressions;

public class Java8ScopeTester {

    final static String salutation = "Hello ";

    public static void main(String[] args) {
        GreetingService greetingService1 = message -> System.out.println(salutation + message + '!');
        greetingService1.sayMessage("Mahesh");
    }

    interface GreetingService {
        void sayMessage(String message);
    }

}
