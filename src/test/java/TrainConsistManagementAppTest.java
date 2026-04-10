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

    @Test
    void testGrouping_NormalCase() {
        Map<String, List<Bogie>> result =
                TrainConsistManagementApp.groupBogiesByType(getSampleBogies());

        assertEquals(3, result.size());
    }

    @Test
    void testGrouping_MultipleBogiesSameType() {
        Map<String, List<Bogie>> result =
                TrainConsistManagementApp.groupBogiesByType(getSampleBogies());

        assertEquals(2, result.get("Sleeper").size());
        assertEquals(2, result.get("AC Chair").size());
    }

    @Test
    void testGrouping_SingleBogieType() {
        Map<String, List<Bogie>> result =
                TrainConsistManagementApp.groupBogiesByType(getSampleBogies());

        assertEquals(1, result.get("First Class").size());
    }

    @Test
    void testGrouping_AllBogiesDifferentTypes() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("A", 10),
                new Bogie("B", 20),
                new Bogie("C", 30)
        );

        Map<String, List<Bogie>> result =
                TrainConsistManagementApp.groupBogiesByType(bogies);

        assertEquals(3, result.size());
    }

    @Test
    void testGrouping_EmptyList() {
        Map<String, List<Bogie>> result =
                TrainConsistManagementApp.groupBogiesByType(new ArrayList<>());

        assertTrue(result.isEmpty());
    }

    @Test
    void testGrouping_SingleElementList() {
        List<Bogie> bogies = Collections.singletonList(new Bogie("Sleeper", 72));

        Map<String, List<Bogie>> result =
                TrainConsistManagementApp.groupBogiesByType(bogies);

        assertEquals(1, result.size());
        assertEquals(1, result.get("Sleeper").size());
    }

    @Test
    void testGrouping_OriginalListUnchanged() {
        List<Bogie> original = new ArrayList<>(getSampleBogies());

        TrainConsistManagementApp.groupBogiesByType(original);

        assertEquals(5, original.size()); // original list unchanged
    }

    @Test
    void testGrouping_KeyPresence() {
        Map<String, List<Bogie>> result =
                TrainConsistManagementApp.groupBogiesByType(getSampleBogies());

        assertTrue(result.containsKey("Sleeper"));
        assertTrue(result.containsKey("AC Chair"));
        assertTrue(result.containsKey("First Class"));
    }
}