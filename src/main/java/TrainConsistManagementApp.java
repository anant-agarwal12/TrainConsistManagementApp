import java.util.regex.Pattern;

public class TrainConsistManagementApp {


    private static final String TRAIN_ID_REGEX = "TRN-\\d{4}";
    private static final String CARGO_CODE_REGEX = "PET-[A-Z]{2}";


    public static boolean isValidTrainID(String trainId) {
        if (trainId == null) return false;
        return Pattern.matches(TRAIN_ID_REGEX, trainId);
    }


    public static boolean isValidCargoCode(String cargoCode) {
        if (cargoCode == null) return false;
        return Pattern.matches(CARGO_CODE_REGEX, cargoCode);
    }

    public static void main(String[] args) {

        System.out.println("================================");
        System.out.println("UC11 Validate Train ID & Cargo Code");
        System.out.println("================================\n");

        String trainId = "TRN-1234";
        String cargoCode = "PET-AB";

        System.out.println("Train ID: " + trainId);
        System.out.println("Cargo Code: " + cargoCode);


        boolean isTrainValid = isValidTrainID(trainId);
        boolean isCargoValid = isValidCargoCode(cargoCode);

        System.out.println("\nValidation Results:");
        System.out.println("Train ID Valid: " + isTrainValid);
        System.out.println("Cargo Code Valid: " + isCargoValid);

        System.out.println("\nUC11 validation completed...");
    }
}