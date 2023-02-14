package ass_303_6_EricEx;
import java.text.DecimalFormat;

import java.util.ArrayList;
import java.util.List;

public class ImplementsMain {

	public static void main(String[] args) {
		
		Square sq1 = new Square();
		sq1.setShapeName("Square 1");
		sq1.setHeight(10);
		sq1.setLength(5);

		Square sq2 = new Square();
		sq2.setShapeName("Square 2");
		sq2.setHeight(7);
		sq2.setLength(7);
		
		Triangle t1 = new Triangle();
		t1.setShapeName("Triangle 1");
		t1.setBase(5);
		t1.setHeight(10);
		
		Triangle t2 = new Triangle();
		t2.setShapeName("Triangle 2");
		t2.setBase(7);
		t2.setHeight(4);
		
		Circle c1 = new Circle();
		c1.setShapeName("Circle 1");
		c1.setRadius(5);
		
		List<Shape> shapes = new ArrayList<>();
		shapes.add(sq1);
		shapes.add(sq2);
		shapes.add(t1);
		shapes.add(t2);
		shapes.add(c1);

		//loop through the shapes array list
		for (Shape shape : shapes) {
			//functionality inherited from the shape class
			String name = shape.getShapeName();
			if ( shape instanceof AreaCalculation ) {
				// mandatory implementation that demands an AreaCalculation
				//defined at abstracted Shape class
				double area = shape.calculateArea(); 
				System.out.println("The area of a " + name + " is " + area);
			}
		}
		System.out.println("-------------------");
		
		//will implicitly print the 'toString' method
		for(Shape shape: shapes) {
			System.out.println(shape);
		}
	}
}
