package blatt04;

public class Line {

	Point startPoint;
	Point endPoint;
	
	public Line(Point p1, Point p2) {
		startPoint = p1;
		endPoint = p2;
	}
	
	public  int side(Point p3) {
		
		//Wir werden die determinante finden und wir nehmen an, dass die startPunkt ist die Ursprung
		
		double determinante = (endPoint.arr[0] - startPoint.arr[0])*(p3.arr[1] - startPoint.arr[1]) - (p3.arr[0]-startPoint.arr[0] )*(endPoint.arr[1]-startPoint.arr[1]);
		//left
		if(determinante > 0) {
			return -1;
		}  //right
		else if(determinante < 0) {
			return 1;
		}else {
			return 0;
		}
	}
	
}
