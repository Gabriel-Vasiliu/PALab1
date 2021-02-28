package transportationProblem;

public class Destination {
    private String name;
    private int cerere;

    Destination() {
    }

    public int getCerere() {
        return this.cerere;
    }

    public void setCerere(int n) {
        this.cerere = n;
    }

    public void setName(String nume) {
        this.name = nume;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return name + " " + cerere;
    }
}
