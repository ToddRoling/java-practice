package local.unit;

import com.github.toddroling.java.interview.preperation.string.StringReverse;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

final class StringReverseUnitTest {

    private static final Random random = new Random();
    private static final int RANDOM_INTEGER_RANGE = 10;
    private static final int RANDOM_ASCII_STRING_LENGTH = random.nextInt(RANDOM_INTEGER_RANGE);
    private static final String BLANK_STRING = " ".repeat(random.nextInt(RANDOM_INTEGER_RANGE));
    private static final String RANDOM_ASCII_STRING = RandomStringUtils.randomAscii(RANDOM_ASCII_STRING_LENGTH);
    private static final String DEFAULT_EXPECTED_RESULT = new StringBuilder(RANDOM_ASCII_STRING).reverse().toString();

    private static String actualResult;

    @Test
    void bySimpleFullTraversal_blankString() {
        actualResult = StringReverse.bySimpleFullTraversal(BLANK_STRING);
        assertEquals(BLANK_STRING, actualResult);
    }

    @Test
    void bySimpleFullTraversal_emptyString() {
        actualResult = StringReverse.bySimpleFullTraversal(StringUtils.EMPTY);
        assertEquals(StringUtils.EMPTY, actualResult);
    }

    @Test
    void bySimpleFullTraversal_null() {
        assertNull(StringReverse.bySimpleFullTraversal(null));
    }

    @Test
    void bySimpleFullTraversal_randomAsciiString() {
        actualResult = StringReverse.bySimpleFullTraversal(RANDOM_ASCII_STRING);
        assertEquals(DEFAULT_EXPECTED_RESULT, actualResult);
    }

    @Test
    void byStringBuilderReverse_blankString() {
        actualResult = StringReverse.byStringBuilderReverse(BLANK_STRING);
        assertEquals(BLANK_STRING, actualResult);
    }

    @Test
    void byStringBuilderReverse_emptyString() {
        actualResult = StringReverse.byStringBuilderReverse(StringUtils.EMPTY);
        assertEquals(StringUtils.EMPTY, actualResult);
    }

    @Test
    void byStringBuilderReverse_null() {
        assertNull(StringReverse.byStringBuilderReverse(null));
    }

    @Test
    void byStringBuilderReverse_randomAsciiString() {
        actualResult = StringReverse.byStringBuilderReverse(RANDOM_ASCII_STRING);
        assertEquals(DEFAULT_EXPECTED_RESULT, actualResult);
    }

    @Test
    void byTraverseFromBothEnds_blankString() {
        actualResult = StringReverse.byTraverseFromBothEnds(BLANK_STRING);
        assertEquals(BLANK_STRING, actualResult);
    }

    @Test
    void byTraverseFromBothEnds_emptyString() {
        actualResult = StringReverse.byTraverseFromBothEnds(StringUtils.EMPTY);
        assertEquals(StringUtils.EMPTY, actualResult);
    }

    @Test
    void byTraverseFromBothEnds_null() {
        assertNull(StringReverse.byTraverseFromBothEnds(null));
    }

    @Test
    void byTraverseFromBothEnds_randomAsciiString() {
        actualResult = StringReverse.byTraverseFromBothEnds(RANDOM_ASCII_STRING);
        assertEquals(DEFAULT_EXPECTED_RESULT, actualResult);
    }

    @Test
    void byTraverseToMidpoint_blankString() {
        actualResult = StringReverse.byTraverseToMidpoint(BLANK_STRING);
        assertEquals(BLANK_STRING, actualResult);
    }

    @Test
    void byTraverseToMidpoint_emptyString() {
        actualResult = StringReverse.byTraverseToMidpoint(StringUtils.EMPTY);
        assertEquals(StringUtils.EMPTY, actualResult);
    }

    @Test
    void byTraverseToMidpoint_null() {
        assertNull(StringReverse.byTraverseToMidpoint(null));
    }

    @Test
    void byTraverseToMidpoint_randomAsciiString() {
        actualResult = StringReverse.byTraverseToMidpoint(RANDOM_ASCII_STRING);
        assertEquals(DEFAULT_EXPECTED_RESULT, actualResult);
    }
}