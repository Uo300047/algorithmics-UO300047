
public class JavaA1v0 {
	 public static boolean isPrime(int m) {
	        if (m <= 1) return false;
	        for (int i = 2; i < m; i++) {
	            if (m % i == 0) return false;
	        }
	        return true;
	    }
}
