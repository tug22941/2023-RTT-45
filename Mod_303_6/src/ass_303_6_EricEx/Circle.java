package ass_303_6_EricEx;

public class Circle extends Shape{
	
	private static final double PI = 3.14159;
	private int radius;
	
	public int getRadius() {
		return radius;
	}
	public void setRadius(int radius) {
		this.radius = radius;
	}
	public static double getPi() {
		return PI;
	}
	@Override
	public double calculateArea() {	
		return PI * (radius* radius);
	}
	
}
