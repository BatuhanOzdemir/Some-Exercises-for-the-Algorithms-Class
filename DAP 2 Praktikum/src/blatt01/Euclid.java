package blatt01;

public class Euclid {
	
	public static int ggt(int a,int b) {
		if(b == 0) {
			return a;
		}else {
			return ggt(b,a%b);
		}
	}

	public static void main(String[] args) {

		try {
		if(args.length < 2 || args.length > 2) {
			throw new IllegalArgumentException();
		}else {
			
			int a = Integer.parseInt(args[0]);
			int b = Integer.parseInt(args[1]);
		    System.out.println(ggt(a,b));
		}
		
		}catch(NumberFormatException e) {
			System.err.println("FEHLER:Sie müssen Zahlen eingeben");
			System.exit(1);
		}catch(IllegalArgumentException e) {
			System.err.println("FEHLER:Bitte geben Sie genau 2 Zahlen ein.");
			System.exit(1);
		}
	}

}
