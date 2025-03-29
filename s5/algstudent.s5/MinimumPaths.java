package labs.en._25.algstudent.s5;

import java.util.Random;

public class MinimumPaths {
    private static final int INF = 10000000;
    
    public static void main(String[] args) {
        int n = 5; // Number of nodes
        int[][] weights = generateRandomGraph(n, 0.5, 10, 99);
        int[][] costs = new int[n][n];
        int[][] p = new int[n][n];
        
        floyd(weights, costs, p);
        printResults(costs);
    }
    
    static int[][] generateRandomGraph(int n, double p1, int minWeight, int maxWeight) {
        Random rand = new Random();
        int[][] weights = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    weights[i][j] = 0; // No self-loops
                } else if (rand.nextDouble() < p1) {
                    weights[i][j] = rand.nextInt(maxWeight - minWeight + 1) + minWeight;
                } else {
                    weights[i][j] = INF; // No edge
                }
            }
        }
        return weights;
    }
    
     static void floyd(int[][] weights, int[][] costs, int[][] p) {
        int n = weights.length;
        
        // Initialize costs and path matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                costs[i][j] = weights[i][j];
                if (weights[i][j] != INF && i != j) {
                    p[i][j] = i; // Set predecessor
                } else {
                    p[i][j] = -1;
                }
            }
        }

        // Floyd-Warshall algorithm
        for (int pivot = 0; pivot < n; pivot++) {
            for (int source = 0; source < n; source++) {
                for (int target = 0; target < n; target++) {
                    if (costs[source][pivot] != INF && costs[pivot][target] != INF 
                            && costs[source][target] > costs[source][pivot] + costs[pivot][target]) {
                        costs[source][target] = costs[source][pivot] + costs[pivot][target];
                        p[source][target] = p[pivot][target]; // Update predecessor
                    }
                }
            }
        }
    }
    
     static void printResults(int[][] costs) {
        for (int[] row : costs) {
            for (int cost : row) {
                System.out.print((cost == INF ? "INF" : cost) + "\t");
            }
            System.out.println();
        }
    }
}