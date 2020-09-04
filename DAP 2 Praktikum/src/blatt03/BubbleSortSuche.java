package blatt03;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class BubbleSortSuche {
	
	
	public static double bubbleSort(int[] array) {
		
		double sec = 0.0;
		
        int n = array.length-1;
		
        long start = System.currentTimeMillis();
		for(int i = 0; i < array.length;i++) {
			for(int j = n; j >= i+1;j--) {
				if(array[j-1] > array[j]) {
		            int tmp = array[j];
		            array[j] = array[j-1];
		            array[j-1] = tmp;
				}
			}
		}
		
		long end = System.currentTimeMillis();
		
		sec = (end - start) / 1000.0;
		return sec;
		
	}

	
	public static void ternary(int l,int r,double key,LinkedHashMap<Integer,Double> list) {
		
		
		int mid1 = l+(r-l)/3;
		int mid2 = r-(r-l)/3;
		
		// to be continued
	
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		
		float sekunden = 0;
		
		try {
			 sekunden = Float.parseFloat(args[0]);
		}catch(NumberFormatException e) {
			System.err.println("FEHLER:Bitte geben Sie ein zahl ein");
			System.exit(1);
		}catch(ArrayIndexOutOfBoundsException e) {
			System.err.println("FEHLER:Sie müssen ein Zahl geben.");
			System.exit(1);
		}
		
		int  size = 1000;
		
		
		double sec = 0;
		
		while(sec <= sekunden) {
		
		int [] array = new int[size];
		
		BubbleSort.rand(array);

	    sec = bubbleSort(array);
		
	    System.out.println("Size:"+size+" Time:"+sec+"s.");
	    
		size = size *2;
		
		}
		
		
		//the last two array sizes
		
		int size1 = size / 2;
		int size2 = size1 / 2;
		
		System.out.println(size1+" "+size2);
		
		Map<Integer,Double> seconds = new LinkedHashMap<Integer,Double>();
		
		for(int i = size2; i <= size1; i = i+1000) {
			
			int[] arr = new int[i];
			BubbleSort.rand(arr);
			seconds.put(i,bubbleSort(arr));
			
		}
		
		
		//ternary search
		
		
		
		
		
	}// end main
	

}
