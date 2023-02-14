package ass_303_4;

public class ShapeMain {

	public static void main(String[] args) {
		Shape s = new Shape();
		Square sq = new Square();
		
		s.printShape();
		sq.printShape();
		
		sq.setArea("10cm^2");
		
//		System.out.println(s.getArea());
//		System.out.println(sq.getArea());
		
		System.out.println(sq.type);
		System.out.println(s.type);
	}
}
