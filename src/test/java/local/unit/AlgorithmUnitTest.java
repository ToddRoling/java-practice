package local.unit;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.example.StringManipulation;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

final class AlgorithmUnitTest {

    private static final Random random = new Random();
    private static final int RANDOM_ASCII_STRING_LENGTH = random.nextInt(10);
    private static final String RANDOM_ASCII_STRING = RandomStringUtils.randomAscii(RANDOM_ASCII_STRING_LENGTH);
    private static final String DEFAULT_EXPECTED_RESULT = new StringBuilder(RANDOM_ASCII_STRING).reverse().toString();

    private static String actualResult;

    @Test
    void reverseStringZero() {
        actualResult = StringManipulation.reverseStringZero(RANDOM_ASCII_STRING);
        assertEquals(DEFAULT_EXPECTED_RESULT, actualResult);
    }

    @Test
    void reverseStringOne_emptyString() {
        actualResult = StringManipulation.reverseStringOne(StringUtils.EMPTY);
        assertEquals(StringUtils.EMPTY, actualResult);
    }

    @Test
    void reverseStringOne_null() {
        assertNull(StringManipulation.reverseStringOne(null));
    }

    @Test
    void reverseStringOne_randomAsciiString() {
        actualResult = StringManipulation.reverseStringOne(RANDOM_ASCII_STRING);
        assertEquals(DEFAULT_EXPECTED_RESULT, actualResult);
    }

    @Test
    void reverseStringTwo() {
        actualResult = StringManipulation.reverseStringTwo(RANDOM_ASCII_STRING);
        assertEquals(DEFAULT_EXPECTED_RESULT, actualResult);
    }
}