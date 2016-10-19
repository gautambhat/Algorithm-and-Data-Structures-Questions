//algorithm source: http://www.cs.wustl.edu/~kjg/CS101_SP97/Notes/SquareRoot/sqrt.html

import java.util.*;

import org.w3c.dom.Node;

public class test10_20 {
	


	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		double x = sc.nextDouble();
		
		if(x == 0) {
			System.out.println("Square root is : 0");
			System.exit(1);
		}
		double s = sqrtSearch(x,1.0);
		
		System.out.println("Closest round-off square root of "+ x + " is : " + s);
		System.out.println(s + " x " + s + " = " + s*s);

	}

	private static double sqrtSearch(double x, double g) {
		
		if(isClose(x/g,g))
			return g;
		else return sqrtSearch(x,findCloser(x,g));
	}

	private static boolean isClose(double x, double g) {
		return (Math.abs(x - g) < 0.0001);
	}

	private static double findCloser(double x, double g) {
		return ((g + x/g)/2);
	}

}
