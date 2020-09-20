package blatt02;

import java.util.Random;

public class InsertionSort {
	
	public static void rand(int[] array) {
		Random random = new Random();
		for(int i = 0; i < array.length;i++) {
			array[i] = random.nextInt();
		}
	}
	
	
	public static void auf(int []  array) {
		int num = 0;
		for(int i = 0; i < array.length;i++) {
			array[i] = num+1;
		}
	}
	
	public static void ab(int[] array) {
		int num = Integer.MAX_VALUE;
		for(int i = 0; i < array.length;i++) {
			array[i] = num - 1;
		}
	}

	public static boolean isSorted(int [] array) {
		for(int i = 0; i < array.length-1;i++) {
			if(array[i] < array[i+1]) {
				return false;
			}
		}
		
		return true;
		
	}
	
	public static void insertionSort(int [] array) {
		
		
		for(int j = 1; j < array.length;j++) {
			int key = array[j];
			int i = j-1;
			
			while(i >= 0 && array[i] < key) {
				array[i+1] = array[i];
				i = i - 1;
			}
			array[i+1] = key;
			
		}
		
	}
	
	
	public static void main(String[] args) {
		int size = 0;
		
		try {
	      size = Integer.parseInt(args[0]);
			
		}catch(NumberFormatException e) {
			System.err.println("Please Enter a Number!");
			System.exit(1);
		}catch(ArrayIndexOutOfBoundsException e) {
			System.err.println("You have to give at least one input");
			System.exit(1);
		}
		
		int[] array = new int[size];
		if(args.length < 2) {
			rand(array);
		}else if(args.length == 2) {
			String art = args[1];
			if(art.equals("auf")) {
				auf(array);
			}else if(art.equals("ab")) {
				ab(array);
			}else if(art.equals("rand")) {
				rand(array);
			}else {
				throw new IllegalArgumentException();
			}
		}else {
			throw new IllegalArgumentException();
		}
		
		if(array.length <= 100) {
			for(int i = 0; i < array.length;i++) {
				System.out.print(array[i]+" ");
			}
			System.out.println();
			long start = System.currentTimeMillis();
			insertionSort(array);
			long end = System.currentTimeMillis();
			assert isSorted(array):"FEHLER:Feld is nicht Sortiert!";
			for(int i = 0; i < array.length;i++) {
				System.out.print(array[i]+" ");
			}
			System.out.println();
			System.out.println("Feld is Sortiert");
			System.out.println("Das Sortieren des Arrays hat "+(end-start)+"ms gedauert.");
		}else {
			long start = System.currentTimeMillis();
			insertionSort(array);
			long end = System.currentTimeMillis();
			assert isSorted(array):"FEHLER:Feld ist nicht sortiert!";
			System.out.println("Feld ist sortiert!");
			System.out.println("Das Sortieren des Arrays hat "+(end-start)+"ms gedauert.");
		}
		
	}//end main
	
 }// end class
