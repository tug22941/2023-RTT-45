package coffee;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class CoffeeShop {

	// create class scanner
	// create private list to hold menu items
	// create private list to hold customer order
	Scanner scanner = new Scanner(System.in);
	private List<MenuItem> menuItems = new ArrayList<>();
	private List<MenuItem> cart = new ArrayList<>();

	// create menu item constant variables to track options
	public static final int PRINT_MENU = 1;
	public static final int ORDER_ITEM = 2;
	public static final int VIEW_CART = 3;
	public static final int EXIT = 4;

	// method instantiating menu items; set name and price; add item to list
	public void initialize() {
		MenuItem item1 = new MenuItem();
		item1.setName("Small Coffee");
		item1.setPrice(4.30);
		item1.setStock(4);
		menuItems.add(item1);

		MenuItem item2 = new MenuItem();
		item2.setName("Large Coffee");
		item2.setPrice(5.99);
		item2.setStock(3);
		menuItems.add(item2);

		MenuItem item3 = new MenuItem();
		item3.setName("Glazed Donut");
		item3.setPrice(9.99);
		item3.setStock(1);
		menuItems.add(item3);

		// directly adding item to the list through initialization
		menuItems.add(new MenuItem("Oatmeal Cookie", 7.25, 3));
		
		//create a new menu item using the constructor
		MenuItem item4 = new MenuItem("Medium Coffee", 5.00, 3);
		menuItems.add(item4);
		
		//implement the comparator INTERFACE as an anonymous code block
		menuItems.sort(
				//this is the ANONYMOUS BLOCK that creates a new comparator
				new Comparator<MenuItem>(){
					
				@Override //provide implementation for the Comparator interface
				public int compare(MenuItem o1, MenuItem o2) {
					//comparator logic
					Double p1 = o1.getPrice();
					Double p2 = o2.getPrice();
					
					return p1.compareTo(p2);
				}
			}
		);
	}

	// method printing the name, price, and quantity in stock of menu items
	public void printMenuItems() {
		System.out.println("Name\t\tPrice \tQuantity");
		System.out.println("-----------------------------------------");
		for (MenuItem item : menuItems) {
			System.out.println(item.getName() + "\t" + formatPrice(item.getPrice()) + "\t" + item.getStock());
		}
		System.out.println("-----------------------------------------");
	}

	// method for printing the user selection prompt
	public int menuPrompt() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Welcome to My Coffee Shop \n");
		System.out.println(PRINT_MENU + ") Print Menu");
		System.out.println(ORDER_ITEM + ") Order Item");
		System.out.println(VIEW_CART + ") View Cart");
		System.out.println(EXIT + ") Exit \n");
		System.out.print("Make Selection: ");

		int selection = scanner.nextInt();
		scanner.nextLine();

		System.out.println("user select menu number " + selection);
		System.out.println();
		return selection;
	}

	// method that accepts user menu order
	public void orderItem() {
		System.out.print("Enter item name: ");
		String itemName = scanner.nextLine();
		MenuItem selectedItem = findMenuItem(itemName);
		if (selectedItem != null) {
			cart.add(selectedItem);
			System.out.println(selectedItem.getName() + " added to your cart. \n");
		} else {
			System.out.println(itemName + " is not a valid selection \n");
		}
	}

	// method for validating user menu item input: returns item
	public MenuItem findMenuItem(String itemName) {
		// catch empty input
		if (itemName == null) {
			return null;
		}
		// trim empty spaces
		itemName = itemName.trim();
		for (MenuItem item : menuItems) {
			if (item.getName().equalsIgnoreCase(itemName)) {
				return item;
			}
		}
		return null;
	}
	
	//method for printing the user order and total
	public void viewCart() {
		//print cart quantity
		System.out.println("[" + cart.size() + "] " + " Item(s) In Your Cart:\n" );		
		double totalPrice = 0.0;
		for(MenuItem item : cart) {
			System.out.println(item.getName() + "\t" + formatPrice(item.getPrice()));
			totalPrice += item.getPrice();
		}
		System.out.println("Total Price:\t" + formatPrice(totalPrice));
		System.out.println("-----------------------------------------");
	}
	
	//method for formatting double values to currency string
	private String formatPrice(double price) {
		DecimalFormat df = new DecimalFormat("$###.00");
		return df.format(price);

	}

}
