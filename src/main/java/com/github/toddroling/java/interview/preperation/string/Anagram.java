package com.github.toddroling.java.interview.preperation.string;

public class Anagram {

    // My solution to https://www.hackerrank.com/challenges/java-anagrams/problem
    public boolean isAnagram(String stringOne, String stringTwo) {
        if ((stringOne == null || stringTwo == null)) {
            return false;
        }
        if (stringOne.length() != stringTwo.length()) {
            return false;
        }
        stringOne = stringOne.toLowerCase();
        stringTwo = stringTwo.toLowerCase();

        java.util.Map<Character, Integer> stringOneCharacterFrequencies = new java.util.HashMap<>();
        java.util.Map<Character, Integer> stringTwoCharacterFrequencies = new java.util.HashMap<>();

        for (char character : stringOne.toCharArray()) {
            int frequency = stringOneCharacterFrequencies.getOrDefault(character, 0) + 1;
            stringOneCharacterFrequencies.put(character, frequency);
        }
        for (char character : stringTwo.toCharArray()) {
            int frequency = stringTwoCharacterFrequencies.getOrDefault(character, 0) + 1;
            stringTwoCharacterFrequencies.put(character, frequency);
        }

        for (char character : stringOneCharacterFrequencies.keySet()) {
            if (!stringTwoCharacterFrequencies.containsKey(character)) {
                return false;
            }
            int stringOneCharacterFrequency = stringOneCharacterFrequencies.get(character);
            int stringTwoCharacterFrequency = stringTwoCharacterFrequencies.get(character);
            if (stringOneCharacterFrequency != stringTwoCharacterFrequency) {
                return false;
            }
        }
        return true;
    }
}
