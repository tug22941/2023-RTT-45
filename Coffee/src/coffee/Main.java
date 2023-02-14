package coffee;

public class Main {

	public static void main(String[] args) {
		CoffeeShop cs = new CoffeeShop();
		cs.initialize();

		while (true) {
			int selection = cs.menuPrompt();

			if (selection == CoffeeShop.PRINT_MENU) {
				cs.printMenuItems();
			} else if (selection == CoffeeShop.ORDER_ITEM) {
				cs.orderItem();
			}else if(selection == CoffeeShop.VIEW_CART) {
				cs.viewCart();
			}else if (selection == CoffeeShop.EXIT) {
				System.out.println("Thank you! Please, come again.");
				// tell the JVM to exit with a status code
				System.exit(0);
			}else {}
		}
	}
}
