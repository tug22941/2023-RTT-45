package hibernate;

import java.util.Date;

public class OneToManyExample {
	public static void main(String[] args) {
		
		CustomerDAO customerDAO = new CustomerDAO();
		EmployeeDAO employeeDAO = new EmployeeDAO();
		PaymentDAO paymentDAO = new PaymentDAO();
		
		//display the customer info for all customers in list
		//associated with the specified employee id
		
		Employee e = employeeDAO.findById(1166);
		/*
		System.out.println(e);
		for(Customer customer: e.getCustomers()) {
			System.out.println(customer);
		}
		*/
		
		
		
		//create customer object
		Customer customer = new Customer();
		customer.setCustomerName("Hibernate Customer");
		customer.setContactFirstname("First Name");
		customer.setContactLastname("Last Name");
		customer.setPhone("215-555-1212");
		customer.setAddressLine1("1234 Broad St");
		customer.setCity("Philadelphia");
		customer.setState("PA");
		customer.setCountry("USA");
		customer.setEmployee(e);
		//customerDAO.insert(customer);
		
		
		//add created object to customer list and update employee
		e.getCustomers().add(customer);
		//employeeDAO.updateEmployee(e);
		
		
		Payment p = new Payment();
		p.setAmount(500.00);
		p.setPaymentDate(new Date());
		p.setCustomer(customer);
		p.setCheckNumber("12345");
		
		customer.getPayments().add(p);
		//customerDAO.updateCustomer(customer);
		
		
		
	}

}
