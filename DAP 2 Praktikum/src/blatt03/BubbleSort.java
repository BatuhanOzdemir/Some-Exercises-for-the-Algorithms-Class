package blatt03;
import java.util.Arrays;
import java.util.Random;

public class BubbleSort {
	
	static int [] arr;
	
	public static void bubbleSort(int [] array) {
		int n = array.length-1;
		
		for(int i = 0; i < array.length;i++) {
			for(int j = n; j >= i+1;j--) {
				if(array[j-1] > array[j]) {
		            int tmp = array[j];
		            array[j] = array[j-1];
		            array[j-1] = tmp;
				}
			}
		}
	}
	
	public static void rand(int[] array) {
		
		
		Random random = new Random();
		for(int i = 0; i < array.length;i++) {
			array[i] = random.nextInt(Integer.MAX_VALUE);
		}
		
		//bubbleSort um das Array Absteigend zu sortieren
         int n = array.length-1;
		
		for(int i = 0; i < array.length;i++) {
			for(int j = n; j >= i+1;j--) {
				if(array[j-1] < array[j]) {
		            int tmp = array[j];
		            array[j] = array[j-1];
		            array[j-1] = tmp;
				}
			}
		}
		
	}
	
	public static boolean isSorted(int[] array) {
		
		for(int i = 1; i < array.length;i++) {
			if(array[i-1] > array[i]) {
				return false;
			}
		}
		
		return true;
		
	}

	public static void main(String[] args) {

         int [] arr = new int[50000];
         
         
         long st = System.currentTimeMillis();
         rand(arr);
         long en = System.currentTimeMillis();
         System.out.println((en-st)/1000+"s.");
		
         long start = System.currentTimeMillis();
         bubbleSort(arr);
        long end = System.currentTimeMillis();
        
        System.out.println((end-start)/1000+"s.");
		
        assert isSorted(arr):"FEHLER: Array ist nicht sortiert!";
	
	}

	
}
