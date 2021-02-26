package transportation_problem;

public class Main {



    static public void main(String[] args){
        Source S1 = new Source(SourceType.Fabrica);
        S1.setCapacity(10);
        S1.setName("S1");
        Source S2 = new Source(SourceType.Depozit);
        S2.setCapacity(35);
        S2.setName("S2");
        Source S3 = new Source(SourceType.Depozit);
        S3.setCapacity(25);
        S3.setName("S3");

        Destination D1 = new Destination();
        D1.setCerere(20);
        D1.setName("D1");
        Destination D2 = new Destination();
        D2.setCerere(25);
        D2.setName("D2");
        Destination D3 = new Destination();
        D3.setCerere(25);
        D3.setName("D3");

        int[][] cost = new int[3][3];
        cost[0][0] = 2;
        cost[0][1] = 3;
        cost[0][2] = 1;
        cost[1][0] = 5;
        cost[1][1] = 4;
        cost[1][2] = 8;
        cost[2][0] = 5;
        cost[2][1] = 6;
        cost[2][2] = 8;
        Problem problem = new Problem();
        problem.printSolution(S1, S2, S3, D1, D2, D3, cost);
    }
}

class Source{
    private String name;
    SourceType type;
    private int capacity;
    Source(){ }
    Source(SourceType sType){
        this.type = sType;
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
}

class Destination{
    private String name;
    private int cerere;
    Destination(){ }
    public int getCerere() {
        return this.cerere;
    }
    public void setCerere(int n){
        this.cerere = n;
    }
    public void setName(String N) { this.name = N; }
    public String getName() {
        return this.name;
    }
    public String toString(){
        return name + " " + cerere;
    }
}

class Problem{
    int totalCost = 0;
    Problem(){ }
    void printSolution(Source S1, Source S2, Source S3, Destination D1, Destination D2, Destination D3, int[][] cost){
        int line = 0, column, indexSource = 0;
        while(line <= 2){
            Source source = new Source();
            switch (line) {
                case 0 -> {
                    source.setCapacity(S1.getCapacity());
                    source.setName(S1.getName());
                    indexSource = 1;
                }
                case 1 -> {
                    source.setCapacity(S2.getCapacity());
                    source.setName(S2.getName());
                    indexSource = 2;
                }
                case 2 -> {
                    source.setCapacity(S3.getCapacity());
                    source.setName(S3.getName());
                    indexSource = 3;
                }
            }
            int aux_source = source.getCapacity();
            while(aux_source > 0) { //cauta minimul pe linia line cat timp este "marfa" la sursa
                column = 0;
                int indexColumn = 0;
                int minim = Integer.MAX_VALUE;
                while (column <= 2) {
                    if (minim > cost[line][column]) {
                        minim = cost[line][column];
                        indexColumn = column;
                    }
                    column++;
                }
                int indexDestination = 0 ; // retinem indexul destinatiei pentru a modifica cererea
                Destination destination = new Destination();
                switch (indexColumn) {
                    case 0: destination.setCerere(D1.getCerere());
                            destination.setName(D1.getName());
                            indexDestination = 1;
                            break;
                    case 1: destination.setCerere(D2.getCerere());
                            destination.setName(D2.getName());
                            indexDestination = 2;
                            break;
                    case 2: destination.setCerere(D3.getCerere());
                            destination.setName(D3.getName());
                            indexDestination = 3;
                            break;
                    default: break;
                }
                int aux_destination = destination.getCerere();
                if (aux_destination > 0){
                    if(aux_destination - aux_source > 0){
                        aux_destination = aux_destination - aux_source;
                        aux_source = 0;
                        System.out.println(source.getName() + " -> " + destination.getName() + " : "
                                + source.getCapacity() + " units * cost " + cost[line][indexColumn]
                                + " = " + source.getCapacity() * cost[line][indexColumn]);
                        totalCost = totalCost + source.getCapacity() * cost[line][indexColumn];
                    }
                    else{
                        aux_source = aux_source - aux_destination;
                        aux_destination = 0;
                        System.out.println(source.getName() + " -> " + destination.getName() + " : "
                                + destination.getCerere() + " units * cost " + cost[line][indexColumn]
                                + " = " + destination.getCerere() * cost[line][indexColumn]);
                        totalCost = totalCost + destination.getCerere() * cost[line][indexColumn];
                    }
                    switch (indexDestination) {
                        case 1 -> D1.setCerere(aux_destination);
                        case 2 -> D2.setCerere(aux_destination);
                        case 3 -> D3.setCerere(aux_destination);
                    }
                    source.setCapacity(aux_source);
                    destination.setCerere(aux_destination);
                    switch (indexSource) {
                        case 1 -> S1.setCapacity(aux_source);
                        case 2 -> S2.setCapacity(aux_source);
                        case 3 -> S3.setCapacity(aux_source);
                    }
                }
                cost[line][indexColumn]=Integer.MAX_VALUE; //pentru a evita gasirea de 2 ori a aceluiasi minim
            }
            line++;
        }
        System.out.println(totalCost);
    }

}