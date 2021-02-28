package transportationProblem;

public class Fabrica extends Source{
    protected String name;
    protected int capacity;
    String type;
    Fabrica(){
        type = "Fabrica";
    }
    public int getCapacity(){
        return this.capacity;
    }
    public void setCapacity(int n){
        this.capacity = n;
    }
    public void setName(String N) { this.name = N; }
    public String getName(){
        return this.name;
    }
    public String toString(){
        return name + " " + type + " " + capacity;
    }
    public boolean equals(Object s) {
        if (this == s){
            return true;
        }
        if (s == null || getClass() != s.getClass()) {
            return false;
        }
        Fabrica f = (Fabrica) s;
        return f.name.equals(name) && f.capacity == capacity && f.type.equals(type);
    }
}
