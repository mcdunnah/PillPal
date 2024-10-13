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
        if (!allergies.contains(allergy.toLowerCase())) {
            allergies.add(allergy.toLowerCase());
            System.out.println("Allergy added.");
        } else {
            System.out.println("Allergy already exists.");
        }
    }

    public void addMedication(Medication medication) {
        boolean exists = false;
        for (Medication med : medications) {
            if (med.getName().equalsIgnoreCase(medication.getName())) {
                exists = true;
                break;
            }
        }

        if (!exists) {
            medications.add(medication);
            System.out.println("Medication added.");
        } else {
            System.out.println("Medication already exists.");
        }
    }

    public void removeAllergy(String allergy) {
        if (allergies.remove(allergy.toLowerCase())) {
            System.out.println("Allergy removed.");
        } else {
            System.out.println("Allergy not found.");
        }
    }

    public void removeMedication(String medName) {
        boolean removed = medications.removeIf(med -> med.getName().equalsIgnoreCase(medName));
        if (removed) {
            System.out.println("Medication removed.");
        } else {
            System.out.println("Medication not found.");
        }
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