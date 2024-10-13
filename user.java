import java.util.*;

public class User {
    private String name;
    private String password;
    private ArrayList<String> allergies;
    private ArrayList<Medication> medications;
    private HashMap<String, String> symptomsLog; // Stores date as key and symptoms as value

    public User(String name, String password) {
        this.name = name;
        this.password = password;
        this.allergies = new ArrayList<>();
        this.medications = new ArrayList<>();
        this.symptomsLog = new HashMap<>();
    }

    // Authenticate user
    public boolean authenticate(String password) {
        return this.password.equals(password);
    }

    // Add allergy if not already present
    public void addAllergy(String allergy) {
        if (!allergies.contains(allergy)) {
            allergies.add(allergy);
            System.out.println("Allergy added successfully.");
        } else {
            System.out.println("This allergy is already logged.");
        }
    }

    // Remove allergy if present
    public void removeAllergy(String allergy) {
        if (allergies.contains(allergy)) {
            allergies.remove(allergy);
            System.out.println("Allergy removed successfully.");
        } else {
            System.out.println("Allergy not found.");
        }
    }

    // Display all allergies
    public void displayAllergies() {
        if (allergies.isEmpty()) {
            System.out.println("No allergies logged.");
        } else {
            System.out.println("Allergies:");
            for (String allergy : allergies) {
                System.out.println("- " + allergy);
            }
        }
    }

    // Add medication if not already present
    public void addMedication(Medication medication) {
        for (Medication med : medications) {
            if (med.getName().equalsIgnoreCase(medication.getName())) {
                System.out.println("This medication is already logged.");
                return;
            }
        }
        medications.add(medication);
        System.out.println("Medication added successfully.");
    }

    // Remove medication if present
    public void removeMedication(String medName) {
        for (Medication med : medications) {
            if (med.getName().equalsIgnoreCase(medName)) {
                medications.remove(med);
                System.out.println("Medication removed successfully.");
                return;
            }
        }
        System.out.println("Medication not found.");
    }

    // Display all medications
    public void displayMedications() {
        if (medications.isEmpty()) {
            System.out.println("No medications logged.");
        } else {
            System.out.println("Medications:");
            for (Medication med : medications) {
                System.out.println(med);
            }
        }
    }

    // Add symptoms to the log with a specific date
    public void addSymptoms(String date, String symptoms) {
        if (symptomsLog.containsKey(date)) {
            System.out.println("Symptoms for this date already exist. Overwriting...");
        }
        symptomsLog.put(date, symptoms);
        System.out.println("Symptoms logged for " + date);
    }

    // Display the symptoms log
    public void displaySymptomsLog() {
        if (symptomsLog.isEmpty()) {
            System.out.println("No symptoms logged.");
        } else {
            System.out.println("Symptoms Log:");
            for (String date : symptomsLog.keySet()) {
                System.out.println("Date: " + date);
                System.out.println("Symptoms: " + symptomsLog.get(date));
                System.out.println("------------");
            }
        }
    }
}