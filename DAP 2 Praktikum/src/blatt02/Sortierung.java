package blatt02;


public class Sortierung {
	
	public static void randomSort(int[] array,String algorithm,String order) {
		if(order.equals("rand")) {
		InsertionSort.rand(array);
		}else if(order.equals("auf")) {
			InsertionSort.auf(array);
		}else if(order.equals("ab")) {
			InsertionSort.ab(array);
		}else {
			InsertionSort.rand(array);
		}
		
		
		if(array.length <= 100) {
			for(int i = 0; i < array.length;i++) {
				System.out.print(array[i]+", ");
			}
			System.out.println();
		}
			
			
			// selecting the algorithm
		    if(algorithm.equals("merge")) {
			long start = System.currentTimeMillis();
			mergeSort(array);
			long end = System.currentTimeMillis();
			
			if(array.length <= 100) {
				for(int i = 0; i < array.length;i++) {
					System.out.print(array[i]+", ");
				}
				System.out.println();
			}
			
			
			System.out.println("Feld ist Sortiert.");
			System.out.println("Das Sortieren des Feldes hat "+(end - start)+"ms gedauert.");
			
			}
			else if(algorithm.equals("insert")) {
				long start = System.currentTimeMillis();
				InsertionSort.insertionSort(array);
				long end = System.currentTimeMillis();
				
				assert isSorted(array): "FEHLER: Feld is nicht sortiert.";
			
			
			
				if(array.length <= 100) {
					for(int i = 0; i < array.length;i++) {
						System.out.print(array[i]+", ");
					}
					System.out.println();
				}
				
			
			System.out.println("Feld ist Sortiert.");
			System.out.println("Das Sortieren des Feldes hat "+(end - start)+"ms gedauert.");
			
			}
			
		
	
	else {
			
			long start = System.currentTimeMillis();
			mergeSort(array);
			long end = System.currentTimeMillis();
			
			
			
			System.out.println("Feld ist Sortiert.");
			System.out.println("Das Sortieren des Feldes hat "+(end - start)+"ms gedauert.");
		}
	
}
		
	public static void mergeSort(int[] array) {
		int[] tmpArray = new int[array.length];
		mergeSort(array, tmpArray, 0, array.length-1);
		assert isSorted(array):"FEHLER: Das Feld ist nicht sortiert!";
		
		}
	
	public static boolean isSorted(int[] array) {
		for(int i = 0; i <= array.length-1;i++) {
			if(array[i] < array[i+1]) {
				return false;
			}
		}
		return true;
	}

	public static void mergeSort(int[] array,int[] tmpArray,int left,int right) {
		
		if(left < right) {
		
		int middle = (left+right)/2;
		
		mergeSort(array,tmpArray,left,middle);
		mergeSort(array,tmpArray,middle+1,right);
		merge(array,tmpArray,left,middle,right);
		}
		
		
	}
	
	public static void merge(int[] array, int[] tmpArray,int left,int middle, int right) {
		       int k = left; // her sub-array'in baþlangýcý sürekli 0'a eþitlemiyoruz
		       int j = middle+1;
		       int start = left;
		while(start <= middle && j <= right) {
			
			if(array[start] > array[j]) {
				tmpArray[k] = array[start];
				start++;
				
			}else {
				tmpArray[k] = array[j];
				j++;
				
			}
			k++;
		}
		
		while(start <= middle) {
			tmpArray[k] = array[start];
			start++;
			k++;
		}
		
		while(j <= right) {
			tmpArray[k] = array[j];
			j++;
			k++;
		}
		
		 for (int i = left; i <= right; i++)
	      {
			 if(tmpArray[i] != 0) {
	    	  array[i] = tmpArray[i];
			 }
	      }
	}
	

	public static void main(String[] args) {
		
		int size = 0;
		int [] array = null;
		try {
			 size = Integer.parseInt(args[0]);
			 array = new int[size];
		}catch(NumberFormatException e ) {
			System.err.println("FEHLER:Bitte geben Sie ein Zahl ein.");
			System.exit(1);
		}catch(ArrayIndexOutOfBoundsException e) {
			System.err.println("FEHLER:Sie müssen mindestens ein Zahl eingeben.");
		}

		
		if(args.length == 1) {
	   randomSort(array,"merge","rand");
		}
		
		if(args.length == 2) {
			
		
			try {
				
				
				if( !(args[1].equals("insert") || args[1].equals("merge"))  ) {
					throw new IllegalArgumentException();
				}
				if(args[1].equals("insert")) {
					
					randomSort(array,"insert","rand");
					
				}else if(args[1].equals("merge")) {
					
					randomSort(array,"merge","rand");
			}
				
			}catch(IllegalArgumentException e) {
				System.err.println("FEHLER:Es gibt nur 2 Sortierungsalgotihmen.");
				System.exit(1);
			}
		}
		
		if(args.length == 3) {
			String algorithm = "";
			String order = "";
             try {
				
				algorithm = args[1];
				if( !(args[1].equals("insert") || args[1].equals("merge"))  ) {
					throw new IllegalArgumentException();
				}
				
				
			}catch(IllegalArgumentException e) {
				System.err.println("FEHLER:Es gibt nur 2 Sortierungsalgotihmen.");
				System.exit(1);
			}
             
             
             try {
            	 order = args[2];
            	 if( !(order.equals("auf") || order.equals("ab") || order.equals("auf") ) ) {
            		 throw new IllegalArgumentException();
            	 }else if(order.equals("auf")&&algorithm.equals("insert")) {
            		 randomSort(array,"insert","auf");
            	 }else if(order.equals("ab")&&algorithm.equals("insert")) {
            		 randomSort(array,"insert","ab");
            	 }else if(order.equals("rand")&&algorithm.equals("insert")) {
            		 randomSort(array,"insert","rand");
            	 }else if(order.equals("auf")&&algorithm.equals("merge")) {
            		 randomSort(array,"merge","auf");
            	 }else if(order.equals("ab")&&algorithm.equals("merge")) {
            		 randomSort(array,"merge","ab");
            	 }else if(order.equals("rand")&&algorithm.equals("merge")) {
            		 randomSort(array,"merge","rand");
            	 }
             }catch(IllegalArgumentException e) {
            	 System.err.println("FEHLER:Falsche Feldordnung gewählt.");
            	 System.exit(1);
             }
		}
		
	}// end main

}
