package transportationProblem;

public class Main {

    static public void main(String[] args) {
        Source s1 = new Source(SourceType.Fabrica);
        s1.setCapacity(10);
        s1.setName("S1");
        System.out.println(s1);
        Source s2 = new Source(SourceType.Depozit);
        s2.setCapacity(35);
        s2.setName("S2");
        Source s3 = new Source(SourceType.Depozit);
        s3.setCapacity(25);
        s3.setName("S3");

        Destination d1 = new Destination();
        d1.setCerere(20);
        d1.setName("D1");
        System.out.println(d1);
        Destination d2 = new Destination();
        d2.setCerere(25);
        d2.setName("D2");
        Destination d3 = new Destination();
        d3.setCerere(25);
        d3.setName("D3");

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
        problem.printSolution(s1, s2, s3, d1, d2, d3, cost);
    }
}