package algstudent.s4;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class GreedyTimes {
    public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
    	String[] files = {"g4.json", "g8.json", "g16.json", "g32.json", "g64.json", "g128.json", "g256.json", "g512.json", "g1024.json", "g2048.json", "g4096.json", "g8192.json", "g16384.json", "g32768.json", "g65536.json", "g100.json", "s8.json", "s16.json", "s32.json", "s64.json"};
        JSONParser parser = new JSONParser();
        
        System.out.println("Graph | Time (ms)");
        System.out.println("----------------");
        
        for (String file : files) {
            try (FileReader reader = new FileReader("./sols/" + file)) {
                JSONObject jsonObject = (JSONObject) parser.parse(reader);
                @SuppressWarnings("unchecked")
                Map<String, List<String>> graph = (Map<String, List<String>>) jsonObject.get("graph");
                
                long startTime = System.nanoTime();
                Map<String, String> solution = GraphColouring.greedy(graph);
                long endTime = System.nanoTime();
                
                long duration = (endTime - startTime) / 1_000_000; // Convert to milliseconds
                System.out.println(file + " | " + duration + " ms");
                
           
            }
        }
    }
}