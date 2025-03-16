package algstudent.s3;

public class CalendarTimes {
    // Reusing the existing variables from Calendar.java
    static int numberParticipants;
    static String[] participants;
    static int numDays;
    static String[][] schedule;

    // Method to generate random participants (from Calendar.java)
    private static void generateParticipants(int n) {
        numberParticipants = n;
        participants = new String[n];
        for (int i = 0; i < n; i++) {
            participants[i] = "P" + (i + 1); // Create participants P1, P2, P3, etc.
        }
    }

    // Method to initialize schedule (from Calendar.java)
    private static void initializeSchedule() {
        numDays = numberParticipants - 1;
        schedule = new String[numDays][numberParticipants]; // Initialize schedule
        // Set Calendar's participants and schedule arrays
        Calendar.participants = participants; // Set participants in Calendar
        Calendar.schedule = schedule; // Set the schedule in Calendar
        Calendar.makeSchedule(0, numberParticipants - 1); // Call makeSchedule with the correct indices
    }

    // Main method to measure time and handle different sizes of n (from CalendarTimes.java)
    public static void main(String[] args) {
        System.out.println("n\tTime (ms)");

        int n = 2; // Start with 2 participants

        while (true) {
            try {
                generateParticipants(n); // Generate the participants

                long startTime = System.nanoTime();
                initializeSchedule(); // Initialize the schedule
                long endTime = System.nanoTime();

                long durationMs = (endTime - startTime) / 1_000_000;
                System.out.println(n + "\t" + durationMs); // Print the size of n and the time it took

                // Prepare for the next power of two
                n *= 2;
            } catch (OutOfMemoryError e) {
                System.out.println("OutOfMemoryError at n = " + n);
                break;
            } catch (Exception e) {
                System.err.println("Error at n = " + n + ": " + e.getMessage());
                break;
            }
        }
    }
}
