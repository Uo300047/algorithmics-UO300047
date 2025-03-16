package algstudent.s3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Calendar {
	static int numberParticipants;
	static String[] participants;
	static int numDays;
	static String[][] schedule;
	
	Calendar(){
		
	}
	
	private static void readFile(String filename) {
		 BufferedReader reader = null;
	        try {
	            // Specify the file path
	            reader = new BufferedReader(new FileReader(filename));
	            
	            String line;
	            
	            numberParticipants = Integer.valueOf(reader.readLine());
	            participants = new String[numberParticipants];
	            int counter = 0;
	            while ((line = reader.readLine()) != null) {
	             participants[counter] = reader.readLine();
	             counter ++;
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	      
	            try {
	                if (reader != null) {
	                    reader.close(); 
	                }
	            } catch (IOException ex) {
	                ex.printStackTrace();
	            }
	        }
	}

	 private static void initializeSchedule() {
		 schedule = new String[numDays][participants.length];
	        numDays = numberParticipants - 1;
	        schedule = new String[numDays][numberParticipants];
	        makeSchedule(0, numberParticipants - 1);
	    }

	    // Divide and conquer method to build the schedule
	    static void makeSchedule(int left, int right) {
	        if (right - left <= 0) {
	            return;
	        }

	        int mid = (left + right) / 2;

	        // Divide the problem
	        makeSchedule(left, mid);
	        makeSchedule(mid + 1, right);

	        // Combine step: schedule matches between the two halves
	        int halfSize = (right - left + 1) / 2;
	        for (int day = 0; day < halfSize; day++) {
	            for (int i = 0; i < halfSize; i++) {
	                int first = left + i;
	                int second = mid + 1 + (i + day) % halfSize;

	                // Assign matches for each day
	                schedule[day + halfSize - 1][first] = participants[second];
	                schedule[day + halfSize - 1][second] = participants[first];
	            }
	        }
	    }



	public static void main(String arg[]) {
		
		//readFile(arg[0]);
		numberParticipants = 4;
		participants = new String[4];
		participants[0] = "Vanesa";
		participants[1] = "Victor";
		participants[2] = "Tomas";
		participants[3] = "Alba";
				
		numDays = participants.length - 1;
		
		initializeSchedule();
		 System.out.println(" PLAYER/OPPONENT\tDAY 1\tDAY 2\tDAY 3");
		    for (int i = 0; i < participants.length; i++) {
		        System.out.print(participants[i] + "\t");
		        for (int j = 0; j < numDays; j++) {
		            System.out.print(schedule[j][i] + "\t");
		        }
		        System.out.println();
		}
   
    }
}
