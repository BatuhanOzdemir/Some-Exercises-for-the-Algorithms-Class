package blatt01;

public class Eratosthenes {
	
	public static boolean[] sieb(int size) {
		boolean[] isPrime = new boolean[size];
		for(int i = 0; i < isPrime.length;i++) {
			isPrime[i] = true;
		}
		
		int grenzwert = (int) Math.sqrt(size);
		
		for(int i = 2; i < grenzwert; i++) {
			for(int j = i; j < isPrime.length;j++) {
				if(j != i) {
					if(j % i == 0) {
						isPrime[j] = false;
					}
				}
			}
		}
		return isPrime;
	}
	

	public static void main(String[] args) {
		
		int size = 0;
		try {
			 size = Integer.parseInt(args[0]);
			 if(size <= 1) {
				 System.out.println("1");
				 System.exit(0);
			 }
			
		}catch(NumberFormatException e) {
			System.err.println("FEHLER:Bitte geben Sie ein Zahl");
			System.exit(1);
		}catch(ArrayIndexOutOfBoundsException e) {
			System.err.println("FEHLER: Es muss mindestens ein Eingabe gegeben werden.");
			System.exit(1);
		}
		

		
		if(args.length == 1) {
			boolean [] isPrime = sieb(size);
			int count = 0;
			for(int i = 2; i < isPrime.length;i++) {
				if(isPrime[i]) {
					count++;
				}
			}
			
			System.out.println(count);
		}else if(args.length == 2 && args[1].equals("-o")) {
			boolean [] isPrime = sieb(size);
			
			for(int i = 2; i < isPrime.length;i++) {
				if(isPrime[i]) {
					System.out.print(i+", ");
				}
			}
		}else {
			throw new IllegalArgumentException();
		}
		
	}

}
