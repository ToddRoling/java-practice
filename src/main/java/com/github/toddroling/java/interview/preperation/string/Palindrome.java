package com.github.toddroling.java.interview.preperation.string;

public class Palindrome {

    // My solution (indirect) to https://www.hackerrank.com/challenges/java-string-reverse/problem
    public static boolean isPalindrome(final String input) {
        if (input == null)
            return false;
        int inputLength = input.length();
        if (inputLength < 2)
            return true;

        int leftIndex = 0;
        int rightIndex = inputLength - 1;

        while (leftIndex < rightIndex) {
            if (input.charAt(leftIndex) != input.charAt(rightIndex))
                return false;
            leftIndex++;
            rightIndex--;
        }
        return true;
    }
}
