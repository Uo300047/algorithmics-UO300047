package  algstudent.s6;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NullPath {
double p1 = 0.5;
int[][] weights;
int minWeightPos = 10, maxWeightPos = 99, minWeightNeg = -99, maxWeightNeg = -10, tolerance = 99, objectiveCost = 0;
static int n;



 
 public NullPath(int n) {
     this.n = n;
     this.weights = new int[n][n];
     generateWeights();
 }

private void generateWeights() {
	 Random rand = new Random();

     for (int i = 0; i < n; i++) {
         for (int j = 0; j < n; j++) {
                 int weight = rand.nextBoolean() ? rand.nextInt(minWeightPos, maxWeightPos + 1)
                         : -rand.nextInt(minWeightPos, maxWeightPos + 1);
                 weights[i][j] = weight;
         }
     }
 }

public List<Integer> findNullPath() {
    List<Integer> path = new ArrayList<>();
    boolean[] visited = new boolean[n];
    path.add(0); 
    visited[0] = true;

    if (findPath(0, path, visited, 0)) {
        return path;
    } else {
        System.out.println("No valid path found.");
        return new ArrayList<>();
    }
}

private boolean findPath(int currentNode, List<Integer> path, boolean[] visited, int currentSum) {
    // If we've reached the destination node
    if (currentNode == n - 1) {
        if (Math.abs(currentSum) <= tolerance) {
            return true; 
        }
        return false;
    }

    for (int nextNode = 0; nextNode < n; nextNode++) {
        if (!visited[nextNode]) {
            
            visited[nextNode] = true;
            path.add(nextNode);

           
            int newSum = currentSum + weights[currentNode][nextNode];

            if (findPath(nextNode, path, visited, newSum)) {
                return true;
            }

            path.remove(path.size() - 1);
            visited[nextNode] = false;
        }
    }
    return false;
}

public void printGraph() {
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            System.out.print(weights[i][j] + " ");
        }
        System.out.println();
    }
}

public static void main(String[] args) throws NumberFormatException {
    n = Integer.valueOf(args[0]); 
    NullPath nullPath = new NullPath(n);
    nullPath.printGraph();

    List<Integer> path = nullPath.findNullPath();
    if (!path.isEmpty()) {
        System.out.println("Found path: " + path);
    }
}

 
}
