import java.util.*;

class User {
    private String name;
    private String password;
    private ArrayList<String> allergies = new ArrayList<>();
    private ArrayList<Medication> medications = new ArrayList<>();

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public boolean authenticate(String password) {
        return this.password.equals(password);
    }

    public void addAllergy(String allergy) {
        allergies.add(allergy);
    }

    public void addMedication(Medication medication) {
        medications.add(medication);
    }

    public void removeAllergy(String allergy) {
        allergies.remove(allergy);
    }

    public void removeMedication(String medName) {
        medications.removeIf(med -> med.getName().equalsIgnoreCase(medName));
    }

    public void displayAllergies() {
        if (allergies.isEmpty()) {
            System.out.println("No allergies recorded.");
        } else {
            System.out.println("Allergies: " + String.join(", ", allergies));
        }
    }

    public void displayMedications() {
        if (medications.isEmpty()) {
            System.out.println("No medications recorded.");
        } else {
            System.out.println("Medications:");
            for (Medication med : medications) {
                System.out.println(med);
            }
        }
    }
}