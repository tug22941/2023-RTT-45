package ass_303_4;

// the parent class of all shapes (circle, triangle, square, etc)
public class Shape {
	
	static String type = "Shape";
	private String area = "100cm^2";
	
	public void printShape() {
		System.out.println("This is a shape");
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
	
	public static String getType() {
		return type;
	}

	public static void setType(String type) {
		Shape.type = type;
	}

}
