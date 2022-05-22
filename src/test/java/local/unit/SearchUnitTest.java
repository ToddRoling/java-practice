package local.unit;

import com.github.toddroling.java.interview.preperation.common.Search;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

final class SearchUnitTest {

    final static int DEFAULT_ARRAY_SIZE = 30;
    final static int RANDOM_INTEGER_RANGE = 100;
    final static Random random = new Random();

    @Test
    void binarySearch_duplicateTarget() {
        int[] searchArray = {7, 9, 20, 42, 66, 83, 97, 97, 113, 135};
        int target = 97;
        int expectedResult = Arrays.binarySearch(searchArray, target);
        int actualResult = Search.binarySearch(searchArray, target);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void binarySearch_duplicateTargetAtFirstIndex() {
        int[] searchArray = {7, 7, 42, 66, 83, 97, 100, 113, 116, 135};
        int target = 7;
        int expectedResult = Arrays.binarySearch(searchArray, target);
        int actualResult = Search.binarySearch(searchArray, target);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void binarySearch_duplicateTargetAtLastIndex() {
        int[] searchArray = {7, 42, 66, 83, 97, 100, 113, 116, 135, 135};
        int target = 135;
        int expectedResult = Arrays.binarySearch(searchArray, target);
        int actualResult = Search.binarySearch(searchArray, target);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void binarySearch_emptySearchArray() {
        int[] searchArray = new int[0];
        int target = 67;
        int expectedResult = -1;
        int actualResult = Search.binarySearch(searchArray, target);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void binarySearch_negativeTargetFound() {
        int[] searchArray = {-99, -98, -81, -64, -58, -33, -30, -30, -15, -9, 2, 15, 20, 28, 31, 37, 54, 64, 77, 93};
        int target = -64;
        int actualResult = Search.binarySearch(searchArray, target);
        int expectedResult = Arrays.binarySearch(searchArray, target);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void binarySearch_nullSearchArray() {
        int[] searchArray = null;
        int target = 99;
        //noinspection ResultOfMethodCallIgnored,ConstantConditions
        Exception exception = assertThrows(NullPointerException.class, () -> Search.binarySearch(searchArray, target));
        String expectedMessage = "Cannot read the array length because \"searchArray\" is null";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void binarySearch_randomTargetFound() {
        int[] searchArray = random.ints(DEFAULT_ARRAY_SIZE, 0, RANDOM_INTEGER_RANGE).toArray();
        Arrays.sort(searchArray);
        int target = searchArray[random.nextInt(DEFAULT_ARRAY_SIZE)];
        int actualResult = Search.binarySearch(searchArray, target);
        int expectedResult = Arrays.binarySearch(searchArray, target);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void binarySearch_searchArrayHasAllEqualValues_targetFound() {
        int[] searchArray = {55, 55, 55, 55, 55, 55, 55};
        int target = 55;
        int expectedResult = Arrays.binarySearch(searchArray, target);
        int actualResult = Search.binarySearch(searchArray, target);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void binarySearch_searchArrayHasAllEqualValues_targetNotFound() {
        int[] searchArray = {55, 55, 55, 55, 55, 55, 55};
        int target = 67;
        int expectedResult = -1;
        int actualResult = Search.binarySearch(searchArray, target);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void binarySearch_searchInstance_targetNotFound() {
        int[] searchArray = {2, 9, 15, 15, 20, 23, 28, 30, 30, 31, 33, 37, 53, 54, 58, 61, 64, 77, 81, 93, 98, 99};
        int target = 65;
        //noinspection AccessStaticViaInstance,InstantiationOfUtilityClass
        int actualResult = new Search().binarySearch(searchArray, target);
        int expectedResult = -1;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void binarySearch_singletonSearchArray_targetFound() {
        int[] searchArray = {11};
        int target = 11;
        int expectedResult = 0;
        int actualResult = Search.binarySearch(searchArray, target);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void binarySearch_singletonSearchArray_targetNotFound() {
        int[] searchArray = {11};
        int target = 13;
        int expectedResult = -1;
        int actualResult = Search.binarySearch(searchArray, target);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void binarySearch_targetAtIndexZero() {
        int[] searchArray = {124, 215, 231, 247, 283, 354, 442, 743, 857, 947};
        int target = 124;
        int expectedResult = 0;
        int actualResult = Search.binarySearch(searchArray, target);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void binarySearch_targetAtLastIndex() {
        int[] searchArray = {124, 215, 231, 247, 283, 354, 442, 743, 857, 947};
        int target = 947;
        int expectedResult = searchArray.length - 1;
        int actualResult = Search.binarySearch(searchArray, target);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void binarySearch_targetFound() {
        int[] searchArray = {2, 9, 15, 15, 20, 23, 28, 30, 30, 31, 33, 37, 53, 54, 58, 61, 64, 77, 81, 93, 98, 99};
        int target = 64;
        int actualResult = Search.binarySearch(searchArray, target);
        int expectedResult = 16;
        assertEquals(expectedResult, actualResult);
    }
}