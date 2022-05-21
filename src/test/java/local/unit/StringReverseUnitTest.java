package local.unit;

import com.github.toddroling.java.interview.preperation.StringReverse;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

final class StringReverseUnitTest {

    private static final Random random = new Random();
    private static final int RANDOM_ASCII_STRING_LENGTH = random.nextInt(10);
    private static final String RANDOM_ASCII_STRING = RandomStringUtils.randomAscii(RANDOM_ASCII_STRING_LENGTH);
    private static final String DEFAULT_EXPECTED_RESULT = new StringBuilder(RANDOM_ASCII_STRING).reverse().toString();

    private static String actualResult;

    @Test
    void bySimpleFullTraversal() {
        actualResult = StringReverse.byStringBuilderReverse(RANDOM_ASCII_STRING);
        assertEquals(DEFAULT_EXPECTED_RESULT, actualResult);
    }

    @Test
    void byStringBuilderReverse() {
        actualResult = StringReverse.byStringBuilderReverse(RANDOM_ASCII_STRING);
        assertEquals(DEFAULT_EXPECTED_RESULT, actualResult);
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
    void byTraverseToMidpoint() {
        actualResult = StringReverse.byTraverseToMidpoint(RANDOM_ASCII_STRING);
        assertEquals(DEFAULT_EXPECTED_RESULT, actualResult);
    }
}