package local.unit;

import com.github.toddroling.java.interview.preperation.BadgeLog;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import static com.github.toddroling.java.interview.preperation.BadgeLog.EMPLOYEE_ACTION_ENTER;
import static com.github.toddroling.java.interview.preperation.BadgeLog.EMPLOYEE_ACTION_EXIT;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BadgeLogTest {

    private static BadgeLog badgeLog;
    private static List<Set<String>> expectedResult;
    private static List<String[]> badgeRecords;

    @BeforeAll
    static void beforeAllBadgeLogTest() {
        badgeLog = new BadgeLog();
    }

    @BeforeEach
    void beforeEachBadgeLogTest() {
        badgeRecords = null;
        expectedResult = null;
    }

    @Test
    void getViolationsTest_nullBadgeRecords() {
        //noinspection ConstantConditions
        assertThrows(NullPointerException.class, () -> badgeLog.getViolations(null));
    }

    @Test
    void getViolationsTest_onlyBadgeRecordIsNull() {
        badgeRecords = new ArrayList<>() {{
            add(null);
        }};
        assertThrows(NullPointerException.class, () -> badgeLog.getViolations(badgeRecords));
    }

    @Test
    void getViolationsTest_firstBadgeRecordIsNull() {
        badgeRecords = new ArrayList<>() {{
            add(null);
            add(new String[]{"Agatha", EMPLOYEE_ACTION_ENTER});
        }};
        assertThrows(NullPointerException.class, () -> badgeLog.getViolations(badgeRecords));
    }

    @Test
    void getViolationsTest_secondBadgeRecordIsNull() {
        badgeRecords = new ArrayList<>() {{
            add(new String[]{"Hector", EMPLOYEE_ACTION_EXIT});
            add(null);
        }};
        assertThrows(NullPointerException.class, () -> badgeLog.getViolations(badgeRecords));
    }

    @Test
    void getViolationsTest_onlyBadgeRecordIsEmpty() {
        badgeRecords = new ArrayList<>() {{
            add(new String[]{});
        }};
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> badgeLog.getViolations(badgeRecords));
    }

    @Test
    void getViolationsTest_firstBadgeRecordIsEmpty() {
        badgeRecords = new ArrayList<>() {{
            add(new String[]{});
            add(new String[]{"Agatha", EMPLOYEE_ACTION_ENTER});
        }};
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> badgeLog.getViolations(badgeRecords));
    }

    @Test
    void getViolationsTest_secondBadgeRecordIsEmpty() {
        badgeRecords = new ArrayList<>() {{
            add(new String[]{"Hector", EMPLOYEE_ACTION_EXIT});
            add(new String[]{});
        }};
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> badgeLog.getViolations(badgeRecords));
    }

    @Test
    void getViolationsTest_emptyBadgeRecords() {
        expectedResult = List.of(
                Collections.emptySet(),
                Collections.emptySet()
        );
        List<Set<String>> actualResult = badgeLog.getViolations(Collections.emptyList());
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void getViolationsTest_singleEnterViolation_minimumLog() {
        badgeRecords = new ArrayList<>() {{
            add(new String[]{"Agatha", EMPLOYEE_ACTION_ENTER});
        }};
        List<Set<String>> expectedResult = List.of(
                Set.of("Agatha"),
                Set.of()
        );
        List<Set<String>> actualResult = badgeLog.getViolations(badgeRecords);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void getViolationsTest_singleEnterViolation_smallLog() {
        badgeRecords = List.of(
                new String[]{"Agatha", EMPLOYEE_ACTION_ENTER},
                new String[]{"Hector", EMPLOYEE_ACTION_ENTER},
                new String[]{"Agatha", EMPLOYEE_ACTION_ENTER},
                new String[]{"Agatha", EMPLOYEE_ACTION_EXIT},
                new String[]{"Hector", EMPLOYEE_ACTION_EXIT}
        );
        expectedResult = List.of(
                Set.of("Agatha"),
                Set.of()
        );
        List<Set<String>> actualResult = badgeLog.getViolations(badgeRecords);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void getViolationsTest_singleEnterViolation_mediumLog() {
        badgeRecords = List.of(
                new String[]{"Hector", EMPLOYEE_ACTION_ENTER},
                new String[]{"Agatha", EMPLOYEE_ACTION_ENTER},
                new String[]{"Greg", EMPLOYEE_ACTION_ENTER},
                new String[]{"Agatha", EMPLOYEE_ACTION_EXIT},
                new String[]{"Agatha", EMPLOYEE_ACTION_ENTER},
                new String[]{"Jenny", EMPLOYEE_ACTION_ENTER},
                new String[]{"Jenny", EMPLOYEE_ACTION_EXIT},
                new String[]{"Agatha", EMPLOYEE_ACTION_EXIT},
                new String[]{"Hector", EMPLOYEE_ACTION_EXIT},
                new String[]{"Greg", EMPLOYEE_ACTION_ENTER}
        );
        expectedResult = List.of(
                Set.of("Greg"),
                Set.of()
        );
        List<Set<String>> actualResult = badgeLog.getViolations(badgeRecords);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void getViolationsTest_manyEnterViolations_samePerson() {
        badgeRecords = List.of(
                new String[]{"Agatha", EMPLOYEE_ACTION_ENTER},
                new String[]{"Agatha", EMPLOYEE_ACTION_ENTER},
                new String[]{"Agatha", EMPLOYEE_ACTION_ENTER},
                new String[]{"Agatha", EMPLOYEE_ACTION_ENTER},
                new String[]{"Joe", EMPLOYEE_ACTION_ENTER},
                new String[]{"Agatha", EMPLOYEE_ACTION_ENTER},
                new String[]{"Agatha", EMPLOYEE_ACTION_ENTER},
                new String[]{"Joe", EMPLOYEE_ACTION_EXIT},
                new String[]{"Agatha", EMPLOYEE_ACTION_ENTER},
                new String[]{"Agatha", EMPLOYEE_ACTION_ENTER}
        );
        List<Set<String>> expectedResult = List.of(
                Set.of("Agatha"),
                Set.of()
        );
        List<Set<String>> actualResult = badgeLog.getViolations(badgeRecords);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void getViolationsTest_manyEnterViolations_differentPeople() {
        badgeRecords = List.of(
                new String[]{"Agatha", EMPLOYEE_ACTION_ENTER},
                new String[]{"Agatha", EMPLOYEE_ACTION_ENTER},
                new String[]{"Agatha", EMPLOYEE_ACTION_ENTER},
                new String[]{"Agatha", EMPLOYEE_ACTION_EXIT},
                new String[]{"Joe", EMPLOYEE_ACTION_ENTER},
                new String[]{"Agatha", EMPLOYEE_ACTION_ENTER},
                new String[]{"Agatha", EMPLOYEE_ACTION_ENTER},
                new String[]{"Joe", EMPLOYEE_ACTION_ENTER},
                new String[]{"Agatha", EMPLOYEE_ACTION_ENTER},
                new String[]{"Agatha", EMPLOYEE_ACTION_ENTER},
                new String[]{"Joe", EMPLOYEE_ACTION_EXIT}
        );
        List<Set<String>> expectedResult = List.of(
                Set.of("Joe", "Agatha"),
                Set.of()
        );
        List<Set<String>> actualResult = badgeLog.getViolations(badgeRecords);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void getViolationsTest_singleExitViolation_minimumLog() {
        badgeRecords = new ArrayList<>() {{
            add(new String[]{"Agatha", EMPLOYEE_ACTION_EXIT});
        }};
        List<Set<String>> expectedResult = List.of(
                Set.of(),
                Set.of("Agatha")
        );
        List<Set<String>> actualResult = badgeLog.getViolations(badgeRecords);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void getViolationsTest_singleExitViolation_smallLog() {
        badgeRecords = List.of(
                new String[]{"Agatha", EMPLOYEE_ACTION_EXIT},
                new String[]{"Hector", EMPLOYEE_ACTION_ENTER},
                new String[]{"Agatha", EMPLOYEE_ACTION_ENTER},
                new String[]{"Agatha", EMPLOYEE_ACTION_EXIT},
                new String[]{"Hector", EMPLOYEE_ACTION_EXIT}
        );
        expectedResult = List.of(
                Set.of(),
                Set.of("Agatha")
        );
        List<Set<String>> actualResult = badgeLog.getViolations(badgeRecords);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void getViolationsTest_singleExitViolation_mediumLog() {
        badgeRecords = List.of(
                new String[]{"Hector", EMPLOYEE_ACTION_ENTER},
                new String[]{"Agatha", EMPLOYEE_ACTION_ENTER},
                new String[]{"Greg", EMPLOYEE_ACTION_EXIT},
                new String[]{"Agatha", EMPLOYEE_ACTION_EXIT},
                new String[]{"Agatha", EMPLOYEE_ACTION_ENTER},
                new String[]{"Jenny", EMPLOYEE_ACTION_ENTER},
                new String[]{"Jenny", EMPLOYEE_ACTION_EXIT},
                new String[]{"Agatha", EMPLOYEE_ACTION_EXIT},
                new String[]{"Hector", EMPLOYEE_ACTION_EXIT},
                new String[]{"Greg", EMPLOYEE_ACTION_EXIT}
        );
        expectedResult = List.of(
                Set.of(),
                Set.of("Greg")
        );
        List<Set<String>> actualResult = badgeLog.getViolations(badgeRecords);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void getViolationsTest_manyExitViolations_samePerson() {
        badgeRecords = List.of(
                new String[]{"Agatha", EMPLOYEE_ACTION_ENTER},
                new String[]{"Agatha", EMPLOYEE_ACTION_EXIT},
                new String[]{"Agatha", EMPLOYEE_ACTION_EXIT},
                new String[]{"Agatha", EMPLOYEE_ACTION_EXIT},
                new String[]{"Joe", EMPLOYEE_ACTION_ENTER},
                new String[]{"Agatha", EMPLOYEE_ACTION_EXIT},
                new String[]{"Agatha", EMPLOYEE_ACTION_EXIT},
                new String[]{"Agatha", EMPLOYEE_ACTION_EXIT},
                new String[]{"Agatha", EMPLOYEE_ACTION_EXIT},
                new String[]{"Joe", EMPLOYEE_ACTION_EXIT},
                new String[]{"Agatha", EMPLOYEE_ACTION_EXIT},
                new String[]{"Agatha", EMPLOYEE_ACTION_EXIT}
        );
        List<Set<String>> expectedResult = List.of(
                Set.of(),
                Set.of("Agatha")
        );
        List<Set<String>> actualResult = badgeLog.getViolations(badgeRecords);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void getViolationsTest_manyExitViolations_differentPeople() {
        badgeRecords = List.of(
                new String[]{"Agatha", EMPLOYEE_ACTION_ENTER},
                new String[]{"Agatha", EMPLOYEE_ACTION_EXIT},
                new String[]{"Agatha", EMPLOYEE_ACTION_EXIT},
                new String[]{"Joe", EMPLOYEE_ACTION_EXIT},
                new String[]{"Joe", EMPLOYEE_ACTION_EXIT},
                new String[]{"Agatha", EMPLOYEE_ACTION_EXIT},
                new String[]{"Joe", EMPLOYEE_ACTION_ENTER},
                new String[]{"Agatha", EMPLOYEE_ACTION_EXIT},
                new String[]{"Agatha", EMPLOYEE_ACTION_EXIT},
                new String[]{"Joe", EMPLOYEE_ACTION_EXIT},
                new String[]{"Agatha", EMPLOYEE_ACTION_EXIT},
                new String[]{"Agatha", EMPLOYEE_ACTION_EXIT},
                new String[]{"Joe", EMPLOYEE_ACTION_EXIT}
        );
        List<Set<String>> expectedResult = List.of(
                Set.of(),
                Set.of("Joe", "Agatha")
        );
        List<Set<String>> actualResult = badgeLog.getViolations(badgeRecords);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void getViolationsTest_manyViolations_smallLog() {
        badgeRecords = List.of(
                new String[]{"Joe", EMPLOYEE_ACTION_ENTER},
                new String[]{"Agatha", EMPLOYEE_ACTION_EXIT},
                new String[]{"Agatha", EMPLOYEE_ACTION_EXIT},
                new String[]{"Greg", EMPLOYEE_ACTION_EXIT},
                new String[]{"Joe", EMPLOYEE_ACTION_ENTER},
                new String[]{"Jenny", EMPLOYEE_ACTION_ENTER},
                new String[]{"Agatha", EMPLOYEE_ACTION_EXIT},
                new String[]{"Joe", EMPLOYEE_ACTION_EXIT},
                new String[]{"Jenny", EMPLOYEE_ACTION_EXIT},
                new String[]{"Greg", EMPLOYEE_ACTION_ENTER}
        );
        List<Set<String>> expectedResult = List.of(
                Set.of("Joe", "Greg"),
                Set.of("Agatha", "Greg")
        );
        List<Set<String>> actualResult = badgeLog.getViolations(badgeRecords);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void getViolationsTest_manyViolations_mediumLog() {
        badgeRecords = List.of(
                new String[]{"Joe", EMPLOYEE_ACTION_ENTER},
                new String[]{"Isabel", EMPLOYEE_ACTION_ENTER},
                new String[]{"Isabel", EMPLOYEE_ACTION_EXIT},
                new String[]{"Agatha", EMPLOYEE_ACTION_EXIT},
                new String[]{"Agatha", EMPLOYEE_ACTION_EXIT},
                new String[]{"Greg", EMPLOYEE_ACTION_EXIT},
                new String[]{"Joe", EMPLOYEE_ACTION_ENTER},
                new String[]{"Jenny", EMPLOYEE_ACTION_ENTER},
                new String[]{"Mike", EMPLOYEE_ACTION_ENTER},
                new String[]{"Agatha", EMPLOYEE_ACTION_EXIT},
                new String[]{"Joe", EMPLOYEE_ACTION_EXIT},
                new String[]{"Jenny", EMPLOYEE_ACTION_EXIT},
                new String[]{"Jenny", EMPLOYEE_ACTION_ENTER},
                new String[]{"Isabel", EMPLOYEE_ACTION_ENTER},
                new String[]{"Jenny", EMPLOYEE_ACTION_EXIT},
                new String[]{"Isabel", EMPLOYEE_ACTION_EXIT},
                new String[]{"Jenny", EMPLOYEE_ACTION_EXIT},
                new String[]{"Greg", EMPLOYEE_ACTION_ENTER},
                new String[]{"Mike", EMPLOYEE_ACTION_ENTER}
        );
        List<Set<String>> expectedResult = List.of(
                Set.of("Joe", "Mike", "Greg"),
                Set.of("Agatha", "Greg", "Jenny")
        );
        List<Set<String>> actualResult = badgeLog.getViolations(badgeRecords);
        assertEquals(expectedResult, actualResult);
    }
}
