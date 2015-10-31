/*
 * Copyright (c) Einsights Pte. Ltd. - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited.
 * Proprietary and confidential.
 */

package com.anhvurz90.java8.tutorialspoint.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;


public class StreamExample {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        System.out.println("List: " + strings + "\n");

        // Count empty strings
        long count = getCountEmptyStringUsingJava7(strings);
        System.out.println("Empty Strings by Java 7: " + count);
        System.out.println("Empty Strings by Java 8: " + strings.stream().filter(s -> s.isEmpty()).count());
        System.out.println();

        // Count strings with length = 3
        count = getCountLength3UsingJava7(strings);
        System.out.println("Strings of length 3 using Java7: " + count);
        System.out.println("Strings of length 3 using Java8: " + strings.stream().filter(s -> s.length() == 3).count());
        System.out.println();

        // Eliminate empty string
        List<String> filtered = deleteEmptyStringUsingJava7(strings);
        System.out.println("Filtered list using Java 7 : " + filtered);
        System.out.println("Filtered list using Java 8 : "
                + strings.stream().filter(s -> !s.isEmpty()).collect(Collectors.toList()));
        System.out.println();

        // Eliminate empty string and join using comma.
        String mergedString = getMergedStringUsingJava7(strings, ", ");
        System.out.println("Merged String using Java 7 :" + mergedString);
        System.out.println("Merged String using Java 8 :"
                + strings.stream().filter(s -> !s.isEmpty()).collect(Collectors.joining(", ")));
        System.out.println();

        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        
        // Get list of square of distinct numbers
        List<Integer> squaresList = getSquare(numbers);
        System.out.println("Squares List using Java 7: " + squaresList);
        System.out.println("Squares List using Java 8: "
                + numbers.stream().distinct().map(number -> number * number).collect(Collectors.toList()));
        System.out.println();

        // Some maths calculations
        List<Integer> integers = Arrays.asList(1, 2, 13, 4, 15, 6, 17, 8, 19);
        System.out.println("List: " + integers);
        System.out.println("Highest number in List using Java 7: " + getMax(integers));
        System.out.println("Lowest number in List using Java 7: " + getMin(integers));
        System.out.println("Sum of all numbers using Java 7: " + getSum(integers));
        System.out.println("Average of all numbers using Java 7: " + getAverage(integers));
        System.out.println();

        IntSummaryStatistics stats = integers.stream().mapToInt(x -> x).summaryStatistics();
        System.out.println("Highest number in List using Java 8: " + stats.getMax());
        System.out.println("Lowest number in List using Java 8: " + stats.getMin());
        System.out.println("Sum of all numbers using Java 8: " + stats.getSum());
        System.out.println("Average of all numbers using Java 8: " + stats.getAverage());
        System.out.println();
        System.out.println();

        // Random numbers
        System.out.print("10 random numbers using Java 7: ");
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            System.out.print(random.nextInt() + " ");
        }
        System.out.print("\n10 random numbers using Java 8: ");
        random.ints().limit(10).sorted().forEach(System.out::println);
    }

    static long getCountEmptyStringUsingJava7(final List<String> strings) {
        int count = 0;
        for (String string : strings) {
            if (string.isEmpty())
                count++;
        }

        return count;
    }

    static long getCountLength3UsingJava7(final List<String> strings) {
        int count = 0;
        for (String string : strings) {
            if (string.length() == 3) {
                count++;
            }
        }

        return count;
    }

    static List<String> deleteEmptyStringUsingJava7(final List<String> strings) {
        List<String> ret = new ArrayList<>();
        for (String string : strings) {
            if (!string.isEmpty()) {
                ret.add(string);
            }
        }

        return ret;
    }

    static String getMergedStringUsingJava7(final List<String> strings, final String separator) {
        String ret = "";
        for (String string : strings) {
            if (!string.isEmpty()) {
                ret += string + separator;
            }
        }

        if (ret.length() > 2) {
            ret = ret.substring(0, ret.length() - 2);
        }

        return ret;
    }

    static List<Integer> getSquare(final List<Integer> numbers) {
        List<Integer> ret = new ArrayList<>(numbers.size());
        for (int num : numbers) {
            int square = num * num;
            if (!ret.contains(square)) {
                ret.add(square);
            }
        }

        return ret;
    }

    static int getMax(final List<Integer> integers) {
        int max = Integer.MIN_VALUE;
        for (int i : integers) {
            max = Math.max(max, i);
        }

        return max;
    }

    static int getMin(final List<Integer> integers) {
        int min = Integer.MAX_VALUE;
        for (int i : integers) {
            min = Math.min(min, i);
        }

        return min;
    }

    static int getSum(final List<Integer> integers) {
        int sum = 0;
        for (int i : integers) {
            sum += i;
        }

        return sum;
    }

    static double getAverage(final List<Integer> integers) {
        return getSum(integers) * 1.0 / integers.size();

    }
}