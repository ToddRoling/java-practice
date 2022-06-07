package local.unit;

import com.github.toddroling.java.interview.preperation.string.Palindrome;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SuppressWarnings("SpellCheckingInspection")
class PalindromeTest {

    @Test
    void isPalindrome_null() {
        assertFalse(Palindrome.isPalindrome(null));
    }

    @Test
    void isPalindrome_empty() {
        assertTrue(Palindrome.isPalindrome(StringUtils.EMPTY));
    }

    @Test
    void isPalindrome_stringLengthOne() {
        assertTrue(Palindrome.isPalindrome("a"));
    }

    @Test
    void isPalindrome_stringLengthTwo_validPalindrome() {
        assertTrue(Palindrome.isPalindrome("aa"));
    }

    @Test
    void isPalindrome_stringLengthTwo_invalidPalindrome() {
        assertFalse(Palindrome.isPalindrome("ab"));
    }

    @Test
    void isPalindrome_stringLengthThree_validPalindrome() {
        assertTrue(Palindrome.isPalindrome("non"));
    }

    @Test
    void isPalindrome_stringLengthThree_invalidPalindrome() {
        assertFalse(Palindrome.isPalindrome("noz"));
    }

    @Test
    void isPalindrome_longString_validPalindrome() {
        assertTrue(Palindrome.isPalindrome("racecar"));
    }

    @Test
    void isPalindrome_longString_invalidPalindrome() {

        assertFalse(Palindrome.isPalindrome("acecar"));
    }

    @Test
    void isPalindrome_longString_sameCharacters_validPalindrome() {
        assertTrue(Palindrome.isPalindrome("zzzzzz"));
    }
}