package blatt03;



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
	
	public static int[] generateArray(int size) {
		int[] arr = new int[size];
		BubbleSort.initArray(arr);
		return arr;
	}

	
	public static boolean between(double key,double min,double max) {
		return(key >= min && key <= max);
	}
	
	public static void ternary(int l,int r,double key) {
		
		
		int mid1 = l+(r-l)/3;
		int mid2 = r-(r-l)/3;
		double dif = 0.1;
		
		System.out.println("Sizes:"+l+", "+mid1+", "+mid2+", "+r);
		
		//calculation of the times
		
		int [] arrMid1 = generateArray(mid1);
		int [] arrMid2 = generateArray(mid2);
		int [] arrLeft = generateArray(l);
		int [] arrRight = generateArray(r);
		
		double secLeft = bubbleSort(arrLeft);
		double secRight = bubbleSort(arrRight);
		double secMid1 = bubbleSort(arrMid1);
		double secMid2 = bubbleSort(arrMid2);
		
		// now comes the ternary part
		if(between(key,secMid1-dif,secMid1+dif)) {
			System.out.println("Size:"+mid1+", Time:"+secMid1);
		}else if(between(key,secMid2-dif,secMid2+dif)) {
			System.out.println("Size:"+mid1+", Time:"+secMid1);
		}
		else if(between(key,secLeft-dif,secLeft+dif)) {
			System.out.println("Size:"+l+", Time:"+secLeft);
		}
		else if(between(key,secRight-dif,secRight+dif)) {
			System.out.println("Size:"+r+", Time:"+secRight);
		}
		
		else if(key < secMid1) {
			ternary(l,mid1,key);
		}else  if(key > secMid1 && key < secMid2) {
			ternary(mid1,mid2,key);
		}
		else if(key > secMid2) {
			ternary(mid2,r,key);
		}
		
	
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
		
		BubbleSort.initArray(array);

	    sec = bubbleSort(array);
		
	    System.out.println("Size:"+size+" Time:"+sec+"s.");
	    
		size = size *2;
		
		}
		
		
		//the last two array sizes
		
		int size1 = size / 2;
		int size2 = size1 / 2;
	
	    
		
	    
	   
	    
		//ternary search
		
	    ternary(size2,size1,sekunden);
		
		
	}// end main
	

}
