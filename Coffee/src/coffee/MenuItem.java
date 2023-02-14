package coffee;

//This is a POJO: Plain O'l Java Object
//This class can also be called a 'Bean' or 'Entity'
public class MenuItem {

	private String name;
	private double price;
	private int stock;
	
	//default constructor
	public MenuItem() {
		
	}
	//overloaded constructor that allows two parameters
	public MenuItem(String name, double price) {
		this.name = name;
		this.price = price;
	}
	
	//overloaded constructor that allows three parameters
	public MenuItem(String name, double price, int quantity) {
		this.name = name;
		this.price = price;
	}
	
	//properties - getters and setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int quantity) {
		this.stock = quantity;
	}
	

}
