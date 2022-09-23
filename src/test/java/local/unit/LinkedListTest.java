package local.unit;

import com.github.toddroling.java.interview.preperation.datastructures.linkedlist.LinkedList;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LinkedListTest {

    private static final Random random = new Random();
    private static final int RANDOM_INTEGER_RANGE = 10;
    private static final int RANDOM_ASCII_STRING_LENGTH = random.nextInt(RANDOM_INTEGER_RANGE);
    private static final String RANDOM_ASCII_STRING = RandomStringUtils.randomAscii(RANDOM_ASCII_STRING_LENGTH);
    private static final String[] orderedTestData = {"A", "B", "C", "D"};

    @Test
    public void constructor_withHead() {
        final LinkedList.Node head = new LinkedList.Node(RANDOM_ASCII_STRING);
        final LinkedList linkedList = new LinkedList(head);

        final int expectedSize = 1;
        final int actualSize = linkedList.getSize();
        assertEquals(expectedSize, actualSize);

        final String actualData = linkedList.getData(0);
        assertEquals(RANDOM_ASCII_STRING, actualData);
    }

    @Test
    public void constructor_withData() {
        final LinkedList linkedList = new LinkedList(orderedTestData);

        final int expectedSize = 4;
        final int actualSize = linkedList.getSize();
        assertEquals(expectedSize, actualSize);

        String expectedData = "A";
        String actualData = linkedList.getData(0);
        assertEquals(expectedData, actualData);

        expectedData = "D";
        actualData = linkedList.getData(3);
        assertEquals(expectedData, actualData);
    }
}
