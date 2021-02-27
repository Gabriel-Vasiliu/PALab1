package transportation_problem;

public class Main {

    static public void main(String[] args){
        Source S1 = new Source(SourceType.Fabrica);
        S1.setCapacity(10);
        S1.setName("S1");
        System.out.println(S1);
        Source S2 = new Source(SourceType.Depozit);
        S2.setCapacity(35);
        S2.setName("S2");
        Source S3 = new Source(SourceType.Depozit);
        S3.setCapacity(25);
        S3.setName("S3");

        Destination D1 = new Destination();
        D1.setCerere(20);
        D1.setName("D1");
        System.out.println(D1);
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