import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest {

    private List<Bogie> getSampleBogies() {
        return Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 56),
                new Bogie("First Class", 24),
                new Bogie("General", 90)
        );
    }

    @Test
    void testFilter_CapacityGreaterThanThreshold() {
        List<Bogie> result = TrainConsistManagementApp.filterBogies(getSampleBogies(), 60);
        assertEquals(2, result.size());
    }

    @Test
    void testFilter_CapacityEqualToThreshold() {
        List<Bogie> result = TrainConsistManagementApp.filterBogies(getSampleBogies(), 72);
        assertEquals(1, result.size()); // only 90 passes (>72)
    }

    @Test
    void testFilter_CapacityLessThanThreshold() {
        List<Bogie> result = TrainConsistManagementApp.filterBogies(getSampleBogies(), 100);
        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_MultipleBogiesMatching() {
        List<Bogie> result = TrainConsistManagementApp.filterBogies(getSampleBogies(), 50);
        assertEquals(3, result.size());
    }

    @Test
    void testFilter_NoBogiesMatching() {
        List<Bogie> result = TrainConsistManagementApp.filterBogies(getSampleBogies(), 200);
        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_AllBogiesMatching() {
        List<Bogie> result = TrainConsistManagementApp.filterBogies(getSampleBogies(), 10);
        assertEquals(4, result.size());
    }

    @Test
    void testFilter_EmptyBogieList() {
        List<Bogie> result = TrainConsistManagementApp.filterBogies(new ArrayList<>(), 50);
        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_OriginalListUnchanged() {
        List<Bogie> original = new ArrayList<>(getSampleBogies());
        TrainConsistManagementApp.filterBogies(original, 60);

        assertEquals(4, original.size()); // original list should remain unchanged
    }
}