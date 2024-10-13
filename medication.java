import java.util.*;

class Medication {
    private String name;
    private int dosage; // number of tablets/pills
    private String frequency; // formatted as "X times per unit"

    public Medication(String name, int dosage, String frequency) {
        this.name = name;
        this.dosage = dosage;
        this.frequency = frequency;
    }

    public String getName() {
        return name;
    }

    public int getDosage() {
        return dosage;
    }

    public String getFrequency() {
        return frequency;
    }

    public String toString() {
        return name + " - " + dosage + " tablets, " + frequency;
    }
}