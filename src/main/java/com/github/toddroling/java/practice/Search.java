package com.github.toddroling.java.practice;

public final class Search {

    public static int binarySearch(final int[] searchArray, final int target) {
        int leftIndex = 0;
        int rightIndex = searchArray.length - 1;

        while (leftIndex <= rightIndex) {
            int midpointIndex = (leftIndex + rightIndex) / 2;
            int midpointValue = searchArray[midpointIndex];

            if (midpointValue == target)
                return midpointIndex;
            if (midpointValue < target)
                leftIndex = midpointIndex + 1;
            else
                rightIndex = midpointIndex - 1;
        }
        return -1;
    }
}
