package com.github.toddroling.java.interview.preperation.common;

public final class Search {

    public static int binarySearch(final int[] searchArray, final int target) {

        int firstIndex = 0;
        int lastIndex = searchArray.length - 1;
        int targetIndex = -1;

        while (targetIndex == -1 && firstIndex <= lastIndex) {

            int midpointIndex = (firstIndex + lastIndex) / 2;
            int midpointValue = searchArray[midpointIndex];

            if (target == midpointValue)
                targetIndex = midpointIndex;
            else if (target < midpointValue)
                lastIndex = midpointIndex - 1;
            else
                firstIndex = midpointIndex + 1;

        }
        return targetIndex;
    }
}
