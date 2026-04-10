import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest {

    private List<Bogie> getSampleBogies() {
        return Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 56),
                new Bogie("First Class", 24),
                new Bogie("Sleeper", 70),
                new Bogie("AC Chair", 60)
        );
    }

    // ======================
    // 🔹 TOTAL CAPACITY TESTS
    // ======================

    @Test
    void testTotalCapacity_NormalCase() {
        int result = TrainConsistManagementApp.getTotalCapacity(getSampleBogies());
        assertEquals(282, result);
    }

    @Test
    void testTotalCapacity_EmptyList() {
        int result = TrainConsistManagementApp.getTotalCapacity(new ArrayList<>());
        assertEquals(0, result);
    }

    @Test
    void testTotalCapacity_SingleBogie() {
        List<Bogie> bogies = Collections.singletonList(new Bogie("Sleeper", 72));
        int result = TrainConsistManagementApp.getTotalCapacity(bogies);
        assertEquals(72, result);
    }

    @Test
    void testTotalCapacity_AllZero() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("A", 0),
                new Bogie("B", 0)
        );
        int result = TrainConsistManagementApp.getTotalCapacity(bogies);
        assertEquals(0, result);
    }

    @Test
    void testTotalCapacity_MultipleBogies() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("A", 10),
                new Bogie("B", 20),
                new Bogie("C", 30)
        );
        int result = TrainConsistManagementApp.getTotalCapacity(bogies);
        assertEquals(60, result);
    }

    @Test
    void testTotalCapacity_OriginalListUnchanged() {
        List<Bogie> original = new ArrayList<>(getSampleBogies());
        TrainConsistManagementApp.getTotalCapacity(original);
        assertEquals(5, original.size());
    }

    // ======================
    // 🔹 GROUPING TESTS
    // ======================

    @Test
    void testGrouping_NormalCase() {
        Map<String, List<Bogie>> result =
                TrainConsistManagementApp.groupBogies(getSampleBogies());

        assertEquals(3, result.size());
    }

    @Test
    void testGrouping_MultipleSameType() {
        Map<String, List<Bogie>> result =
                TrainConsistManagementApp.groupBogies(getSampleBogies());

        assertEquals(2, result.get("Sleeper").size());
        assertEquals(2, result.get("AC Chair").size());
    }

    @Test
    void testGrouping_EmptyList() {
        Map<String, List<Bogie>> result =
                TrainConsistManagementApp.groupBogies(new ArrayList<>());

        assertTrue(result.isEmpty());
    }

    @Test
    void testGrouping_OriginalListUnchanged() {
        List<Bogie> original = new ArrayList<>(getSampleBogies());
        TrainConsistManagementApp.groupBogies(original);
        assertEquals(5, original.size());
    }
}