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
		
		
	}

}
