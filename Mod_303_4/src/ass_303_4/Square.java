package ass_303_4;

//the child class of Shape
public class Square extends Shape{

	//super.area = "5";
	
	@Override //override parent method of the same name
	public void printShape() {
		System.out.println("This is a square");
	}

}
