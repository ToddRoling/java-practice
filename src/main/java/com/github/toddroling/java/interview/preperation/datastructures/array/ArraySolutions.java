package com.github.toddroling.java.interview.preperation.datastructures.array;

import java.util.HashMap;
import java.util.List;

final class ArraySolutions {

    // My solution to https://www.hackerrank.com/challenges/simple-array-sum/problem
    public static int simpleArraySum(List<Integer> ar) {
        int result = 0;
        for (int element : ar) {
            result += element;
        }
        return result;
    }

    // My solution to https://practice.geeksforgeeks.org/problems/first-element-to-occur-k-times5150/1
    public int firstElementKTime(final int[] a, final int n, final int k) {
        final HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        for (int element : a) {
            int frequency = frequencyMap.getOrDefault(element, 0) + 1;
            if (frequency == k) {
                return element;
            }
            frequencyMap.put(element, frequency);
        }
        return -1;
    }
}