package transportationProblem;

public class Depozit extends Source {
    protected String name;
    protected int capacity;
    String type;

    Depozit() {
        type = "Depozit";
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void setCapacity(int n) {
        this.capacity = n;
    }

    public void setName(String nume) {
        this.name = nume;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return name + " " + type + " " + capacity;
    }

    public boolean equals(Object s) {
        if (this == s) {
            return true;
        }
        if (s == null || getClass() != s.getClass()) {
            return false;
        }
        Depozit d = (Depozit) s;
        return d.name.equals(name) && d.capacity == capacity && d.type.equals(type);
    }
}
