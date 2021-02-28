package transportationProblem;

public class Problem {
    public int[][] cost = new int[3][3];

    void setCost(int[][] cost) {
        cost[0][0] = 2;
        cost[0][1] = 3;
        cost[0][2] = 1;
        cost[1][0] = 5;
        cost[1][1] = 4;
        cost[1][2] = 8;
        cost[2][0] = 5;
        cost[2][1] = 6;
        cost[2][2] = 8;
    }

    Problem() {
    }

    void printSolution(Source s1, Source s2, Source s3, Destination d1, Destination d2, Destination d3) {
        setCost(cost);
        Solution solution = new Solution(s1, s2, s3, d1, d2, d3, cost);
    }
}
