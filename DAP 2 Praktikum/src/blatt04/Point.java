package blatt04;

import java.util.Comparator;

public class Point implements Comparable<Point>{

	double[] arr;
	
	public Point(double ... a) {
		arr = a;
	}
	
	
public  boolean equals(Point p) {
		
		for(int i = 0; i < this.arr.length;i++) {
			
			if(this.arr[i] != p.arr[i]) {
				return false;
			}
		}
		
		return true;
	}

	
	public String toString() {
	     String a;
	     String b = "";
	     for(double p:this.arr) {
	    	 a = Double.toString(p);
	    	 b = b+a+"; ";
	     }
	     return b;
	}
	
	public double get(int i) {
		return this.arr[i];
	}
	





	@Override
	public int compareTo(Point arg0) {
	
		return this.get(0) > arg0.get(0) ? 1:this.get(0) < arg0.get(0) ? -1:0;
	}
	
  
}
