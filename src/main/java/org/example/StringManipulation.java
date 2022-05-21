package org.example;

public final class StringManipulation {

    public static String reverseStringZero(final String string) {
        return new StringBuilder(string).reverse().toString();
    }

    public static String reverseStringOne(final String string) {

        if(string == null)
            return null;

        char temp;
        char[] chars = string.toCharArray();
        int firstIndex = 0;
        int lastIndex = chars.length - 1;

        while (firstIndex < lastIndex) {
            temp = chars[firstIndex];
            chars[firstIndex] = chars[lastIndex];
            chars[lastIndex] = temp;
            ++firstIndex;
            --lastIndex;
        }
        return new String(chars);
    }

    public static String reverseStringTwo(final String string) {

        if(string == null)
            return null;

        int stringLength = string.length();
        int initialLastIndex = stringLength - 1;
        char[] chars = string.toCharArray();

        for(int i = 0; i < stringLength / 2; ++i) {
            char temp = chars[i];
            int lastIndex = initialLastIndex - i;
            chars[i] = chars[lastIndex];
            chars[lastIndex] = temp;
        }
        return new String(chars);
    }

}