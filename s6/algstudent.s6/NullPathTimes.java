package algstudent.s6;

import java.util.List;

public class NullPathTimes {
	
	public static void main(String[] args) throws NumberFormatException {
	
		long t1,t2,tAccumulated = 0;
		for(int n = 20; n <=100; n+=5) {
			
		for (int x=1;x<=100;x+=1)
		 {
			 t1 = System.currentTimeMillis ();
			
			 NullPath nullPath = new NullPath(n);
			 List<Integer> path = nullPath.findNullPath();
			 
			 t2 = System.currentTimeMillis ();
			 
			 if (!path.isEmpty()) {
			        System.out.println("Found path: " + path);
			    }
			
			 tAccumulated += t2-t1;
			 
		 } 
		System.out.println ("n="+n+ "**TIME="+(tAccumulated/100));
	    }
	}
	}


