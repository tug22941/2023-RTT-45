package hibernate;

public class HibernateExample {

	public static void main(String[] args) {
		CustomerDAO customerDAO = new CustomerDAO();
		
		Customer customer = new Customer();
		customer.setCustomerName("Hibernate Customer");
		customer.setContactFirstname("First Name");
		customer.setContactLastname("Last Name");
		customer.setPhone("215-555-1212");
		customer.setAddressLine1("1234 Broad St");
		customer.setCity("Philadelphia");
		customer.setState("PA");
		customer.setCountry("USA");
		//customerDAO.insert(customer);
		
		Customer first = customerDAO.findById(496);
		System.out.println(first.toString());
		
		/*
		first.setAddressLine2("This is an Update!");
		first.setPostalCode("80203");
		first.setCreditLimit(1000000.35);
		customerDAO.updateCustomer(first);
		*/
		
		
		/*
		List<Customer> firstName = he.findContactFirstName("Leslie");
		for( Customer c : firstName) {
			System.out.println(c);
		}
		*/
		
		//customerDAO.deleteByInteger(498); 
		
	}
}
