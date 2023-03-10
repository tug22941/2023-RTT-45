package hibernate;

import java.util.Calendar;
import java.util.Date;

public class HibernateExercise {

	public static void main(String[] args) {
		
		OrderDAO orderDAO = new OrderDAO();
		Order order = new Order();
		
		
		// insert new order
		order.setCustomerId(515);
		order.setOrderDate(new Date());
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DATE, 5);
		Date fiveDays = cal.getTime();
		order.setRequiredDate(fiveDays);
		
		cal.setTime(new Date());
		cal.add(Calendar.DATE, -2);
		Date twoDays = cal.getTime();
		order.setShippedDate(twoDays);
		
		order.setStatus("Shipped");
		order.setComments("Shipping in progress");		
		
		orderDAO.insert(order);
		
		
		/*
		// update existing order
		order = orderDAO.findById(10426);
		order.setComments("Its on the way, chief");
		orderDAO.updateOrder(order);
		*/
		
		/*
		//delete existing order
		order = orderDAO.findById(10426);
		orderDAO.delete(order);
		*/
		
		/*----------------------------------------*/
		
		//ProductDAO productDAO = new ProductDAO();
		//Product product = new Product();
		
		/*
		//insert new product
		product.setProductCode("R2D2_3CPO");
		product.setProductName("Wacky Waving Inflatable Arm=Flailing TubeMan");
		product.setProductLineId(7);
		product.setProductScale("1:10");
		product.setProductVendor("Al Harrington's WWIA-FT E&W");
		product.setProductDescription("A tube man, also known as a skydancer, air dancer, "
				+ "inflatable man and originally called the Tall Boy, is an inflatable stick "
				+ "figure comprising sections of fabric tubing attached to a fan. As the fan blows "
				+ "air through it, the tubing moves in a dynamic dancing or flailing motion.");
		product.setQauntityInStock(10000);
		product.setBuy_price(59.99);
		product.setMsrp(90.57);
		
		productDAO.insert(product);
		*/
		
		/*
		// update existing product
		product = productDAO.findById(112);
		product.setQauntityInStock(267);
		productDAO.updateProduct(product);
		*/
		
		/*
		//delete existing order
		product = productDAO.findById(112);
		productDAO.delete(product);
		*/
		
		/*----------------------------------------*/

		//OrderDetailDAO orderDetailDAO = new OrderDetailDAO();
		//OrderDetail orderDetail = new OrderDetail();
		//OrderDAO orderDAO = new OrderDAO();
		
		/*
		//insert new order detail
		orderDetail.setOrderId(10427);
		orderDetail.setProductId(113);
		orderDetail.setQuantityOrdered(29);
		orderDetail.setPriceEach(38.99);
		orderDetail.setOrderLineNumber(3);
		orderDetail.setOrder(orderDAO.findById(10427));
		
		orderDetailDAO.insert(orderDetail);
		*/
		
		/*
		//update existing order detail
		orderDetail = orderDetailDAO.findById(2997);
		orderDetail.setQuantityOrdered(36);
		orderDetailDAO.updateOrder(orderDetail);
		*/
		
		/*
		//delete existing order detail
		orderDetail = orderDetailDAO.findById(2997);
		orderDetailDAO.delete(orderDetail);
		*/
		
	}

}
