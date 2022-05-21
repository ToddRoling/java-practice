package com.github.toddroling.java.interview.preperation;

public final class StringReverse {

    public static String bySimpleFullTraversal(final String string) {

        if (string == null || string.isBlank() || string.isEmpty())
            return string;

        StringBuilder result = new StringBuilder();
        for(int i = (string.length() - 1); i >= 0; --i) {
            result.append(string.charAt(i));
        }
        return result.toString();
    }

    public static String byStringBuilderReverse(final String string) {
        return new StringBuilder(string).reverse().toString();
    }

    public static String byTraverseFromBothEnds(final String string) {

        if (string == null || string.isBlank() || string.isEmpty())
            return string;

        int firstIndex = 0;
        int lastIndex = string.length() - 1;
        char[] charArray = string.toCharArray();

        while (firstIndex < lastIndex) {
            char temp = charArray[firstIndex];
            charArray[firstIndex] = charArray[lastIndex];
            charArray[lastIndex] = temp;
            ++firstIndex;
            --lastIndex;
        }
        return new String(charArray);
    }

    public static String byTraverseToMidpoint(final String string) {

        if (string == null || string.isBlank() || string.isEmpty())
            return string;

        int stringLength = string.length();
        int initialLastIndex = stringLength - 1;
        char[] charArray = string.toCharArray();

        for (int i = 0; i < stringLength / 2; ++i) {
            char temp = charArray[i];
            int lastIndex = initialLastIndex - i;
            charArray[i] = charArray[lastIndex];
            charArray[lastIndex] = temp;
        }
        return new String(charArray);
    }

}