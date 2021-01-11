package blatt04;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
public class ConvexHull {
	
	//sort the points by their x coordinate
	
	
	
	//Determine if the points are clockwise or counterclockwise
	
	 public static int ccw(Point a, Point b, Point c) {
	        // return a.x*b.y - a.y*b.x + a.y*c.x - a.x*c.y + b.x*c.y - b.y*c.x;
		    // 1 is counter clockwise -1 counterclockwise 0 is neither
	        double area2 = (b.get(0) - a.get(0)) * (c.get(1) - a.get(1)) - (c.get(0) - a.get(0)) * (b.get(1) - a.get(1));
	        if      (area2 < 0) return -1;
	        else if (area2 > 0) return +1;
	        else                return  0;
	    }

     //checks if the line cuts through the polygon
	 
	 public static int orientation(Point a, Point b, Point c) {
		  int res = (int) ((b.get(1)-a.get(1))*(c.get(0)-b.get(0)) - 
	              (c.get(1)-b.get(1))*(b.get(0)-a.get(0)));  
				 
				if(res == 0) {
					return 0;
				}
				if(res > 0) {
					return 1;
				}
				
				return -1;
	 }
	
	
	//cut the list in a specified point
	public static ArrayList<Point> cutList(ArrayList<Point>list,int cutStart,int cutEnd){
		if(cutEnd >= list.size()) {
			throw new IllegalArgumentException();
		}else {
			ArrayList<Point> liste = new ArrayList<Point>();
			for(int i = cutStart; i <= cutEnd;i++) {
				liste.add(list.get(i));
			}
			return liste;
		}
	}
	
	
	//compute Hull
	//Note: List may not change through the recursive calls maybe fill in another ArrayList?
	public static ArrayList<Point> computeHull(ArrayList<Point> list){
		Collections.sort(list);
		ArrayList<Point> hull = new ArrayList<Point>();
		
		
		if(list.size() == 3) {
			Line line = new Line(list.get(0),list.get(list.size()-1));
			if(line.side(list.get(1)) < 0 ) {
				hull.add(list.get(0));
				hull.add(list.get(1));
			}else {
				hull.add(list.get(0));
				hull.add(list.get(2));
			}
		}else if(list.size() <= 2) {
			return list;
		}
		
		else {
			int mid = (list.size()-1) / 2;
			ArrayList<Point> left = new ArrayList<Point>();
			ArrayList<Point> right = new ArrayList<Point>();
			left = cutList(list,0,mid);
			right = cutList(list,mid+1,list.size()-1);
			
			computeHull(left);
			computeHull(right);
			
			return merge(left,right);
		}
		return list;
	}
	
public static ArrayList<Point> merge(ArrayList<Point> left,ArrayList<Point> right){
		
	
		
		Collections.sort(left);
		Collections.sort(right);
		
		Point leftMost = right.get(0);
		Point rightMost = left.get(left.size()-1);
		
		//find the leftmost of the right and rightmost of the left
		
		for(int i = 0; i < left.size();i++){
			if(left.get(i).get(0) > rightMost.get(0)){
				rightMost = left.get(i);
			}
		}
		
		for(int i = 0; i < right.size();i++){
			
			if(right.get(i).get(0) < leftMost.get(0)){
				leftMost = right.get(i);
			}
		}
		
		//making two copies of leftMost and rightMost
		Point copyLeftMost = leftMost;
		Point copyRightMost = rightMost;
		Point copy2LeftMost = leftMost;
		Point copy2RightMost = rightMost;
		
		
		
		
		// finds the upper boundary
		
		int IndexCopyRightMost = 0;
		for(int i = 0; i < left.size();i++){
			
			Line line = new Line(copyRightMost,copyLeftMost);
			
			if(line.side(left.get(i)) == 1){
				
				copyRightMost = left.get(i);
				
				left.remove(IndexCopyRightMost);
				
	            IndexCopyRightMost = i;			
			}
			
		}
		int IndexCopyLeftMost = 0;
		
		for(int i = 0; i < right.size();i++){
			
			Line line = new Line(copyRightMost,copyLeftMost);
			if(line.side(right.get(i)) == 1){
				copyLeftMost = right.get(i);
				
				right.remove(IndexCopyLeftMost);
				
				IndexCopyLeftMost = i;
			}
		}
		
		// finds the lower boundary
		
		int IndexCopy2RightMost = 0;
		for(int i = 0; i < left.size();i++){
			
			Line line = new Line(copy2RightMost,copy2LeftMost);
			
			if(line.side(left.get(i)) == -1){
				
				copy2RightMost = left.get(i);
				
				left.remove(IndexCopy2RightMost);
				
	            IndexCopy2RightMost = i;			
			}
			
		}
		int IndexCopy2LeftMost = 0;
		
		for(int i = 0; i < right.size();i++){
			
			Line line = new Line(copy2RightMost,copy2LeftMost);
			if(line.side(right.get(i)) == -1){
				copyLeftMost = right.get(i);
				
				right.remove(IndexCopy2LeftMost);
				
				IndexCopy2LeftMost = i;
			}
		}
		
		
		left.addAll(right);
		ArrayList<Point> convexHull = left;
		
		return convexHull;
	}
	
	
	
	
	
	/*
    //merge Hull   
	public static ArrayList<Point> mergeHull(ArrayList<Point> left,ArrayList<Point> right) {
		
		
		
	}// end mergeHull
	
	*/
	
	
	
	
	class CoordinateOrder implements Comparator<Point>{

	@Override
	public int compare(Point arg0, Point arg1) {
	
		return arg0.get(0) > arg1.get(0) ? 1:arg0.get(0) < arg1.get(1) ? -1:0;
	}
	
  }
	

	
	
	
}
