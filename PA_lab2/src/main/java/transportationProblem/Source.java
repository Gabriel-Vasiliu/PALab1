package transportationProblem;

public class Source {
    private String name;
    SourceType type;
    private int capacity;

    Source() {
    }

    Source(SourceType sType) {
        this.type = sType;
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
}
