import java.util.ArrayList;

public class JavaA1v1 {
	 public static ArrayList<Integer> listPrimes(int n) {
	        ArrayList<Integer> primes = new ArrayList<>();
	        for (int i = 2; i <= n; i++) {
	            if (JavaA1v0.isPrime(i)) {
	                primes.add(i);
	            }
	        }
	        return primes;
	    }
}
