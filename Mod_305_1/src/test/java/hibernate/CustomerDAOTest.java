package hibernate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvSource;

public class CustomerDAOTest {
	
	private static CustomerDAO customerDAO;;
	
	@BeforeAll
	public static void setUp() {
		customerDAO = new CustomerDAO();
	}

	
	@Test
	public void findByIdTest() {
		CustomerDAO customerDAO = new CustomerDAO();
		
		//given - what we know to be true
		Customer expected = new Customer();
		expected.setCustomerName("Atelier graphique");
		expected.setContactLastname("Schmitt");
		expected.setContactFirstname("Carine");
		
		//when - an action happens
		Customer actual = customerDAO.findById(103);
		
		//given - test
		Assertions.assertEquals(expected.getCustomerName(), actual.getCustomerName());
		Assertions.assertEquals(expected.getContactFirstname(), actual.getContactFirstname());
		Assertions.assertEquals(expected.getContactLastname(), actual.getContactLastname());
	}
	
	@ParameterizedTest
	@CsvSource({
		"103,Atelier graphique,Schmitt,Carine",
		"112,signal Gift Store,King,Jean"
		})

	public void findByIdParameterizedTest(ArgumentsAccessor args) {
		
		//given - what we know to be true
		Customer expected = new Customer();
		expected.setCustomerName(args.getString(1));
		expected.setCustomerName(args.getString(2));
		expected.setCustomerName(args.getString(3));
		
		//FINISH LATER -- NOT COMPLETED
		
		//when - an action happens
		Customer actual = customerDAO.findById(103);
		
		//given - test
		Assertions.assertEquals(expected.getCustomerName(), actual.getCustomerName());
		Assertions.assertEquals(expected.getContactFirstname(), actual.getContactFirstname());
		Assertions.assertEquals(expected.getContactLastname(), actual.getContactLastname());
	}
}
