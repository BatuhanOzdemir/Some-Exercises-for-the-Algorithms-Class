package blatt04;

import java.util.ArrayList;

public class ConvexTester {

	public static void main(String[] args) {
		
		
		int obereSchranke=0,untereSchranke=0,anzahlDerPunkte=0;
		
		//Überprüfung und zuweisung von Eingaben
		
		if(args.length > 3) {
			throw new IllegalArgumentException();
		}else {
			try {
			if(obereSchranke < untereSchranke) {
				System.out.println("FEHLER:Obereschranke muss grösser als die Untereschranke sein");
				throw new IllegalArgumentException();
			}
			
			obereSchranke = Integer.parseInt(args[0]);
			untereSchranke = Integer.parseInt(args[1]);
			anzahlDerPunkte = Integer.parseInt(args[2]);
			
		} catch(NumberFormatException e) {
			System.err.println("FEHLER:Die Werte muss numerisch sein!");
			System.exit(1);
		}catch(IllegalArgumentException e) {
			System.err.println("FEHLER:Falsches Argument!");
			System.exit(1);
		}
		
	PointsGenerator gen = new PointsGenerator(untereSchranke,obereSchranke);
	ArrayList<Point> arr = new ArrayList<Point>();
	arr = gen.generate(anzahlDerPunkte);
	ArrayList<Point> hull = ConvexHull.computeHull(arr);
	System.out.println(anzahlDerPunkte);
	for(int i = 0; i< arr.size();i++) {
		System.out.println(arr.get(i).toString());
		
	}
	System.out.print(hull.size()+"\n");
	for(int i = 0; i < hull.size();i++) {
		System.out.println(hull.get(i).toString());
	}
		
	if(hull.size() == arr.size()) {
		System.out.print("Alle Punkte sind in der Hülle!");
	}else {
		System.out.print(arr.size() - hull.size()+" Punkte sind nicht in der Hülle");
	}
	
	
	}// end else block
	
	
	
}
	
}
