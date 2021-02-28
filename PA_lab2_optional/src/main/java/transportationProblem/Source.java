package transportationProblem;

public abstract class Source {
    Source() {
    }

    public abstract int getCapacity();

    public abstract void setCapacity(int n);

    public abstract void setName(String nume);

    public abstract String getName();
}

