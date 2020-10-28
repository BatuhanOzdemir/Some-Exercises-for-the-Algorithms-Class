package blatt04;

import java.util.ArrayList;
import java.util.Random;

public class PointsGenerator {
	
	
	double untereGrenze;
	double obereGrenze;
	
	public PointsGenerator(double untereGrenze, double obereGrenze) {
		this.obereGrenze = obereGrenze;
		this.untereGrenze = untereGrenze;
	}
	
	public ArrayList<Point> generate(int listSize) throws IllegalArgumentException{
		
		ArrayList<Point> points = new ArrayList<Point>();
		
		if(listSize < 0) {
			throw new IllegalArgumentException();
		}
		
		Random random = new Random();
		for(int i = 0; i < listSize; i++) {
			double xCoordinate = random.nextDouble();
			double yCoordinate = random.nextDouble();
			Point point = new Point(xCoordinate,yCoordinate);
			points.add(point);
		}
		
		return points;
	}

}
