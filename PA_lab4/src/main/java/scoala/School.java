package scoala;

public class School implements Comparable<School> {
    private final String name;
    private int capacity;

    School(String nameS) {
        this.name = nameS;
    }

    public void setCapacity(int capacityS) {
        this.capacity = capacityS;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(School o) {
        return this.getName().compareTo(o.getName());
    }
}
