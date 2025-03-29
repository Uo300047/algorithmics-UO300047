package labs.en._25.algstudent.s5;


public class MinimumPathTimes {
    private static final int INF = 10000000;
    
    public static void main(String[] args) {
        int n = 200; // Starting graph size
        long maxTime = 5 * 60 * 1000; // 5 minutes in milliseconds
        
        while (true) {
            System.out.println("Running Floyd-Warshall for n = " + n);
            long startTime = System.currentTimeMillis();
            
            int[][] weights = MinimumPaths.generateRandomGraph(n, 0.5, 10, 99);
            int[][] costs = new int[n][n];
            int[][] p = new int[n][n];
            
            MinimumPaths.floyd(weights, costs, p);
            
            long endTime = System.currentTimeMillis();
            long elapsedTime = endTime - startTime;
            System.out.println("Time taken for n = " + n + " is " + elapsedTime + " ms\n");
            
            if (elapsedTime > maxTime) break;
            
            n *= 2; // Double the graph size for the next iteration
        }
    }
}