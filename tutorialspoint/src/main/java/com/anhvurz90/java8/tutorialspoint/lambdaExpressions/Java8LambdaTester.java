/*
 * Copyright (c) Einsights Pte. Ltd. - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited.
 * Proprietary and confidential.
 */

package com.anhvurz90.java8.tutorialspoint.lambdaExpressions;

public class Java8LambdaTester {

    public static void main(String[] args) {
        Java8LambdaTester tester = new Java8LambdaTester();
        
        //with type declaration
        MathOperation addition = (int a, int b) -> a + b;
        //without type declaration
        MathOperation substraction = (a, b) -> a - b;
        
        
        //with return statement along with curly braces
        MathOperation multiplication = (int a, int b) -> {
            return a * b;
        };
        //without return statement and without curly braces
        MathOperation division = (int a, int b) -> a / b;
        
        System.out.println("10 + 5 = " + tester.operate(10, 5, addition));
        System.out.println("10 - 5 = " + tester.operate(10, 5, substraction));
        System.out.println("10 * 5 = " + tester.operate(10, 5, multiplication));
        System.out.println("10 / 5 = " + tester.operate(10, 5, division));

        // with parenthesis
        GreetingService greetingService1 = (message) -> System.out.println("Hello " + message);

        // without parenthesis
        GreetingService greetingService2 = message -> System.out.println("Hello " + message);

        greetingService1.sayMessage("Mahesh");
        greetingService2.sayMessage("Suresh");
    }

    interface MathOperation {
        int operation(int a, int b);
    }

    interface GreetingService {
        void sayMessage(String message);
    }

    private int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }
}
