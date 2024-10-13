import java.util.*;

class User {
    private String name;
    private ArrayList<String> allergies = new ArrayList<>();
    private ArrayList<Medication> medications = new ArrayList<>();

    public User(String name) {
        this.name = name;
    }

    public void addAllergy(String allergy) {
        allergies.add(allergy);
    }

    public void addMedication(Medication medication) {
        medications.add(medication);
    }

    public void displayUserInfo() {
        System.out.println("User: " + name);
        System.out.println("Allergies: " + (allergies.isEmpty() ? "None" : String.join(", ", allergies)));
        System.out.println("Medications:");
        if (medications.isEmpty()) {
            System.out.println("None");
        } else {
            for (Medication med : medications) {
                System.out.println(med);
            }
        }
    }
}
