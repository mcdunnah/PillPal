import java.util.*;

public class AllergyMedicationTracker {
    private static final String[] VALID_UNITS = {"hour", "day", "week", "month", "year"};
    private static HashMap<String, User> userDatabase = new HashMap<>(); // Simulates a database of users

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Welcome to the Allergy and Medication Tracker");
            System.out.println("1. Log In");
            System.out.println("2. Register");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1 -> logIn(scanner);
                case 2 -> register(scanner);
                case 3 -> {
                    System.out.println("Goodbye!");
                    running = false;
                }
                default -> System.out.println("Invalid option. Please choose again.");
            }
        }

        scanner.close();
    }

    // User login process
    private static void logIn(Scanner scanner) {
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        if (userDatabase.containsKey(name) && userDatabase.get(name).authenticate(password)) {
            System.out.println("Login successful!");
            User user = userDatabase.get(name);
            showUserMenu(scanner, user);
        } else {
            System.out.println("Invalid name or password.");
        }
    }

    // User registration process
    private static void register(Scanner scanner) {
        System.out.print("Enter a new name: ");
        String name = scanner.nextLine();
        System.out.print("Enter a new password: ");
        String password = scanner.nextLine();

        if (userDatabase.containsKey(name)) {
            System.out.println("This name is already registered.");
        } else {
            User newUser = new User(name, password);
            userDatabase.put(name, newUser);
            System.out.println("Registration successful!");
        }
    }

    // Menu options for managing a user's allergies and medications
    private static void showUserMenu(Scanner scanner, User user) {
        boolean loggedIn = true;
        while (loggedIn) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Allergy");
            System.out.println("2. Remove Allergy");
            System.out.println("3. View Allergies");
            System.out.println("4. Add Medication");
            System.out.println("5. Remove Medication");
            System.out.println("6. View Medications");
            System.out.println("7. Log Out");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (option) {
                case 1 -> addAllergy(scanner, user);
                case 2 -> removeAllergy(scanner, user);
                case 3 -> user.displayAllergies();
                case 4 -> addMedication(scanner, user);
                case 5 -> removeMedication(scanner, user);
                case 6 -> user.displayMedications();
                case 7 -> {
                    System.out.println("Logging out...");
                    loggedIn = false;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // Add an allergy for a user
    private static void addAllergy(Scanner scanner, User user) {
        System.out.print("Enter the allergy: ");
        String allergy = scanner.nextLine();
        user.addAllergy(allergy);
        System.out.println("Allergy added.");
    }

    // Remove an allergy for a user
    private static void removeAllergy(Scanner scanner, User user) {
        System.out.print("Enter the allergy to remove: ");
        String allergy = scanner.nextLine();
        if (user.removeAllergy(allergy)) {
            System.out.println("Allergy removed.");
        } else {
            System.out.println("Allergy not found.");
        }
    }

    // Add a medication for a user
    private static void addMedication(Scanner scanner, User user) {
        System.out.print("Enter medication name: ");
        String medName = scanner.nextLine();
        System.out.print("Enter dosage (number of tablets/pills): ");
        int dosage = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        String frequency = getValidatedFrequency(scanner);
        Medication medication = new Medication(medName, dosage, frequency);
        user.addMedication(medication);
        System.out.println("Medication added.");
    }

    // Remove a medication for a user
    private static void removeMedication(Scanner scanner, User user) {
        System.out.print("Enter the name of the medication to remove: ");
        String medName = scanner.nextLine();
        user.removeMedication(medName);
        System.out.println("Medication removed.");
    }

    // Get and validate the medication frequency
    private static String getValidatedFrequency(Scanner scanner) {
        System.out.println("Enter how often the medication is taken.");
        System.out.println("Options for units are: hour, day, week, month, or year.");

        String unit = "";
        boolean validUnit = false;

        // Validate unit input
        while (!validUnit) {
            System.out.print("Enter the unit (hour/day/week/month/year): ");
            unit = scanner.nextLine().toLowerCase();
            for (String valid : VALID_UNITS) {
                if (unit.equals(valid)) {
                    validUnit = true;
                    break;
                }
            }
            if (!validUnit) {
                System.out.println("Invalid unit! Please choose from hour, day, week, month, or year.");
            }
        }

        int timesPerUnit = 0;
        boolean validTimes = false;

        // Validate number of times input
        while (!validTimes) {
            System.out.print("Enter how many times per " + unit + ": ");
            if (scanner.hasNextInt()) {
                timesPerUnit = scanner.nextInt();
                scanner.nextLine(); // Consume the newline
                validTimes = true;
            } else {
                System.out.println("Please enter a valid number for how many times per " + unit + ".");
                scanner.nextLine(); // Consume the invalid input
            }
        }

        return timesPerUnit + " times per " + unit;
    }

    // Helper function to handle yes/no input with "y"/"n" options
    private static boolean getYesNoInput(Scanner scanner, String prompt) {
        System.out.print(prompt + " (y/n): ");
        String input = scanner.nextLine().trim().toLowerCase();
        return input.equals("y") || input.equals("yes");
    }
}