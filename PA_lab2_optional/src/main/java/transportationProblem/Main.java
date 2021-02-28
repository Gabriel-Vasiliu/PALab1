package transportationProblem;

public class Main {
    public static void main(String[] args) {
        Source s1 = new Fabrica();
        s1.setCapacity(10);
        s1.setName("S1");
        System.out.println(s1);
        Source s2 = new Depozit();
        s2.setCapacity(35);
        s2.setName("S2");
        Source s3 = new Depozit();
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

        Problem problem = new Problem();
        problem.printSolution(s1, s2, s3, d1, d2, d3);
    }
}
