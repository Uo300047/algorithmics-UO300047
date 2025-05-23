package session1;

/**
 * This program serves to measure times automatically increasing 
 * the size of the problem. In addition, we use a repetition value 
 * determined by nTimes, an argument of the program
 */

public class Vector4 {
	static int[]v;
	static int[]w;
	
	public static void main(String arg []) {
		int repetitions = Integer.parseInt(arg[0]);
		long t1,t2;
		int sum = 0;
		
		for (int n=10000; n<=Integer.MAX_VALUE; n*=2){ //n is increased *5   
			  v = new int[n];
			  w = new int[n];
			  Vector1.fillIn(v);
			  Vector1.fillIn(w);
			  
			  t1 = System.currentTimeMillis();
			  //We have to repeat the whole process to be measured
			  for (int repetition=1; repetition<=repetitions; repetition++){    	
			     Vector1.matches2(v, w);
			  }
			  t2 = System.currentTimeMillis();
			  System.out.printf("SIZE=%d TIME=%d milliseconds SUM=%d NTIMES=%d\n", n, t2-t1, sum, repetitions);	
		}//for 
		
	}//main

}
