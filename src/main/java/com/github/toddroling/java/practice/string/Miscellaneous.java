package com.github.toddroling.java.practice.string;

import java.util.Scanner;

public class Miscellaneous {

    // My solution to https://www.hackerrank.com/challenges/java-strings-introduction/problem
    public static void javaStringsIntroduction() { // main

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

    // My solution to https://www.hackerrank.com/challenges/java-substring/problem
    public static void javaSubstring() {

        Scanner in = new Scanner(System.in);
        String string = in.next();
        int beginIndex = in.nextInt();
        int endIndex = in.nextInt();

        System.out.println(string.substring(beginIndex, endIndex));
    }
}

