package doc;

/**
 * @author Piyush
 * @version -0.1
 * @since 17-07-23
 * 
 * Calculating area of circle , rectangle , triangle
 * 
 */

public class creatingJavaDoc {
	/**,
	 * 
	 * @param r - taking radius of circle
	 * @return - area of circle
	 */
	public static double circleArea(double r) {
		return (3.14*r*r);
	}
	
	/**
	 * 
	 * @param l - length of rectangle
	 * @param b - breadth of rectangle
	 * @return area of rectangle
	 */
	public static int rectangleArea(int l,int b) {
		return l*b;
	}
	
	/**
	 * 
	 * @param base - taking base of the triangle
	 * @param height - taking height of  triangle
	 * @return area of triangle
	 */
	public static double triangleArea(double base , double height) {
		return (base*height)/2;
	}
	
	public static void main(String[] args) {
	    double r = 12;
	    int l = 14;
	    int b = 15;
	    double base = 12.3;
	    double height= 16.87;
	    
	    /**
	     * printing Area of circle 
	     * then, printing area of  rectangle
	     * printing area of triangle
	     */
	    
	    System.out.println("The area of circle is - " +  circleArea(r));
	    System.out.println("The area of circle is - " +  rectangleArea(l,b));
	    System.out.println("The area of circle is - " +  triangleArea(base,height));
	   
	   
	   
	}

}
