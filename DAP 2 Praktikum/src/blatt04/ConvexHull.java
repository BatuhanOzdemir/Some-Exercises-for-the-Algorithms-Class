package blatt04;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
public class ConvexHull {
	

	public static ArrayList<Point> computeHull(ArrayList<Point> list){
		
		ConvexHull convex = new ConvexHull();
		if(list.size() <= 3) {
			Collections.sort(list,convex.new CoordinateOrder());
			return list;
		}else {
			Collections.sort(list,convex.new CoordinateOrder());
			
			return list;
		}
		
	}
	
	class CoordinateOrder implements Comparator<Point>{

	@Override
	public int compare(Point arg0, Point arg1) {
	
		return arg0.get(0) > arg1.get(0) ? 1:arg0.get(0) < arg1.get(0) ? -1:0;
	}
	
  }
	
	public static void main(String[] args) {
		PointsGenerator pg = new PointsGenerator(1,20);
		ArrayList<Point> list = new ArrayList<Point>();
	    list = pg.generate(4);
	    System.out.println(list.toString());
	    computeHull(list);
	    
	}
}
