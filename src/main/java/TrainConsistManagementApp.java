import java.util.*;
import java.util.stream.Collectors;

// Bogie class
class Bogie {
    String name;
    int capacity;

    Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    void display() {
        System.out.println(name + " -> " + capacity);
    }
}

// Main class
public class TrainConsistManagementApp {

    // ✅ Method for total capacity
    public static int getTotalCapacity(List<Bogie> bogies) {
        return bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);
    }

    // ✅ Method for grouping
    public static Map<String, List<Bogie>> groupBogies(List<Bogie> bogies) {
        return bogies.stream()
                .collect(Collectors.groupingBy(b -> b.name));
    }

    public static void main(String[] args) {

        System.out.println("================================");
        System.out.println("UC10 Count Total Seats in Train");
        System.out.println("================================\n");

        List<Bogie> bogies = new ArrayList<>();

        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("Sleeper", 70));
        bogies.add(new Bogie("AC Chair", 60));

        System.out.println("All Bogies:");
        bogies.forEach(Bogie::display);

        // ✅ Total capacity
        int totalCapacity = getTotalCapacity(bogies);
        System.out.println("\nTotal Seating Capacity: " + totalCapacity);

        // ✅ Grouping
        Map<String, List<Bogie>> groupedBogies = groupBogies(bogies);

        System.out.println("\nGrouped Bogies:");
        groupedBogies.forEach((type, list) -> {
            System.out.println("Bogie Type: " + type);
            list.forEach(b -> System.out.println("Capacity -> " + b.capacity));
        });

        System.out.println("\nUC10 aggregation completed...");
    }
}