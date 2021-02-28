package transportationProblem;

public class Problem {
    public int[][] cost = new int[3][3];
    void setCost(int[][] cost){
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
    Problem () { }
    void printSolution(Source S1, Source S2, Source S3, Destination D1, Destination D2, Destination D3) {
        setCost(cost);
        Solution solution = new Solution(S1, S2, S3, D1, D2, D3, cost);
    }
}
