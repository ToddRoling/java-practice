package com.github.toddroling.java.interview.preperation.string;

import java.util.Scanner;

public class Basic {

    // My solution to https://www.hackerrank.com/challenges/java-strings-introduction/problem
    public static void basicStringOperations() { // main

        final Scanner sc = new Scanner(System.in);
        final String stringOne = sc.next();
        final String stringTwo = sc.next();

        System.out.println(stringOne.length() + stringTwo.length());
        System.out.println(stringOne.compareTo(stringTwo) > 0 ? "Yes" : "No");
        System.out.println(capitalize(stringOne) + " " + capitalize(stringTwo));
    }

    private static String capitalize(final String string) {
        return string.substring(0, 1).toUpperCase() + string.substring(1);
    }
}

