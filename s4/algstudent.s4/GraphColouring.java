package algstudent.s4;

import java.util.*;

public class GraphColouring {

    static ArrayList<String> colors = new ArrayList<>(Arrays.asList("red", "blue", "green", "yellow", 
            "orange", "purple", "cyan", "magenta", "lime"));


    public static Map<String, String> greedy(Map<String, List<String>> graph) {
        Map<String, String> coloredGraph = new HashMap<>();
        
        for (String node : graph.keySet()) {
            Set<String> usedColors = new HashSet<>();
            List<String> neighbors = graph.get(node);
            
            // Collect colors used by neighbors
            for (int i = 0; i < neighbors.size(); i++) {
                if (coloredGraph.containsKey(String.valueOf(neighbors.get(i)))) {
                    usedColors.add(coloredGraph.get(String.valueOf(neighbors.get(i))));
                }
            }
            
            // Find the first available color
            for (int i = 0; i < colors.size(); i++) {
                if (!usedColors.contains(colors.get(i))) {
                    coloredGraph.put(node, colors.get(i));
                    break;
                }
            }
        }
        return coloredGraph;
    }
    
   
}