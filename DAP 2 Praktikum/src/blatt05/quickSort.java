package blatt05;

import java.util.Random;

public class quickSort {
	
	
	public static int med3(int[] arr, int left, int right) {
		return median(arr[left],arr[(left+right)/2],arr[right]);
	}
	
	public static int ninther(int[]arr,int left, int right) {
		int m1 = left+(right-left)*1/3;
		int m2 = left+(right-left)*2/3;
		return median(med3(arr,left,m1),med3(arr,m1,m2),med3(arr,m2,right));
	}
	
	public static int median(int a,int b,int c) {
		if(a <= b && b <= c) {
			return b;
		}else if(b <= a && a <= c) {
			return a;
		}else if(a <= c && c<= b) {
			return c;
		}else if(c <= b && b <= a) {
			return b;
		}else if(c <= a && a <= b) {
			return a;
		}else {
			return c;
		}
	}
	
	public static void quickSort(int[]arr,int left,int right) {
		if(left < right) {
			int i = left;
			int j = right;
			int pivot = ninther(arr,left,right);
			while(i <= j) {
				while(arr[i] < pivot) {
					i++;
				}while(arr[j] > pivot) {
					j--;
				}
				if(i <= j) {
					int tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
					i++;
					j--;
				}
			}
			quickSort(arr,left,j);
			quickSort(arr,i,right);
		}
	}

	public static boolean isSorted(int[]arr) {
		for(int i = 1; i < arr.length;i++) {
			if(arr[i]< arr[i-1]) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		int num = 0;
		try {
		if(args.length == 1) {
			num = Integer.parseInt(args[0]);
		}else if(num <= 0) {
			throw new IllegalArgumentException();
		}
 
		int[] arr = new int[num];
		
		Random random = new Random();
		
		for(int i = 0; i < arr.length;i++) {
			arr[i] = random.nextInt();
		}
		
		long start = System.currentTimeMillis();
		quickSort(arr,0,arr.length-1);
		long end = System.currentTimeMillis();
		long time = end - start;
		
		if(isSorted(arr)) {
			System.out.println("Die Array ist Sortiert");
			System.out.println("Es hat "+time+"ms gedauert");
		}else {
			System.out.println("FEHLER:Array ist nicht sortiert!");
		}
		}catch(NumberFormatException e) {
			System.err.println("FEHLER: Bitte geben Sie ein Zahl ein.");
		}catch(IllegalArgumentException e) {
			System.err.println("FEHLER:Bitte überprüfen Sie Ihre Eingabe.\nSie müssen genau ein positives Zahl eingeben.");
		}
	}

}
