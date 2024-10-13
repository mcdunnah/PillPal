public class AllergyMedicationTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<User> users = new ArrayList<>();

        System.out.println("Allergy and Medication Tracker");

        // Creating a user
        System.out.print("Enter user name: ");
        String userName = scanner.nextLine();
        User user = new User(userName);

        // Adding allergies
        System.out.print("Do you want to add allergies? (yes/no): ");
        String addAllergies = scanner.nextLine();
        while (addAllergies.equalsIgnoreCase("yes")) {
            System.out.print("Enter allergy: ");
            String allergy = scanner.nextLine();
            user.addAllergy(allergy);

            System.out.print("Do you want to add another allergy? (yes/no): ");
            addAllergies = scanner.nextLine();
        }

        // Adding medications
        System.out.print("Do you want to add medications? (yes/no): ");
        String addMedications = scanner.nextLine();
        while (addMedications.equalsIgnoreCase("yes")) {
            System.out.print("Enter medication name: ");
            String medName = scanner.nextLine();
            System.out.print("Enter dosage (number of tablets/pills): ");
            int dosage = scanner.nextInt();
            scanner.nextLine(); 
            System.out.print("Enter frequency (e.g., 'twice a day'): ");
            String frequency = scanner.nextLine();

            Medication medication = new Medication(medName, dosage, frequency);
            user.addMedication(medication);

            System.out.print("Do you want to add another medication? (yes/no): ");
            addMedications = scanner.nextLine();
        }

        // Adding user to the system
        users.add(user);

        // Displaying user information
        System.out.println("\nUser Information:");
        user.displayUserInfo();

        scanner.close();
    }
}
