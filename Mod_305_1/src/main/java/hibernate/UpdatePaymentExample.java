package hibernate;

public class UpdatePaymentExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//0) Create a new UpdatePaymentExample
		//1)Query the new payment we just created by its ID
		//2)Change the check number and the amount
		//3) update the payment
		
		PaymentDAO paymentDAO = new PaymentDAO();
		Payment p = paymentDAO.findById(274);
		p.setCheckNumber("JJ12345");
		p.setAmount(300.00);
		
		paymentDAO.updatePayment(p);
	
	}

}
