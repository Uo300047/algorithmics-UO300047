import java.util.ArrayList;

public class JavaA1 {
	public static void main(String[] args) {
        int n = 10000;
        for (int cases = 0; cases < 7; cases++) {
            long startTime = System.currentTimeMillis();
            ArrayList<Integer> primes = JavaA1v1.listPrimes(n);
            long endTime = System.currentTimeMillis();

            System.out.println("n = " + n + " *** time = " + (endTime - startTime) + " milliseconds");
            // Uncomment to print primes
            // System.out.println(primes);

            n *= 2;
        }
    }
}