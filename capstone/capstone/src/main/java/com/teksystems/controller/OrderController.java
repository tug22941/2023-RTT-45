package com.teksystems.controller;

import com.teksystems.database.dao.OrderDAO;
import com.teksystems.database.dao.OrderProductDAO;
import com.teksystems.database.dao.ProductDAO;
import com.teksystems.database.dao.UserDAO;
import com.teksystems.database.entity.Order;
import com.teksystems.database.entity.OrderProduct;
import com.teksystems.database.entity.Product;
import com.teksystems.database.entity.User;
import com.teksystems.formbeans.OrderProductFormBean;
import com.teksystems.security.AuthenticatedUserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

//controller class responsible for handling user order(s)
@Slf4j
@Controller
@RequestMapping("/order")
public class OrderController {
    //----------Autowire Necessary DAOs--------------//
    @Autowired
    AuthenticatedUserService authenticatedUserService;

    @Autowired
    UserDAO userDAO;

    @Autowired
    private OrderDAO orderDAO;

    @Autowired
    private OrderProductDAO orderProductDAO;

    @Autowired
    private ProductDAO productDAO;
    //---

    //method responsible for displaying the cart page: with user info: and order details
    @GetMapping("/cart")
    public ModelAndView cart() {

        //1) DISPLAY THE CART PAGE as response view
        log.debug("In the CART PAGE controller method:");
        ModelAndView response = new ModelAndView("order/cart");

        //2) LOAD USER from authenticated user service: add the user object to the response object
        User user = authenticatedUserService.loadCurrentUser();
        log.debug("Current User:" + user.getEmail());
        response.addObject("user",user);

        log.debug("");
        return response;
    }

    //method responsible for saving quantity ordered of product to user cart: and re-displaying the product detail page with saved quantity value
    @GetMapping("/addToCart/{id}")
    public ModelAndView addToCart(@PathVariable Integer id,
                                  @RequestParam(required = false) Integer orderId,
                                  @RequestParam(required = false) Integer quantity,
                                  @Valid OrderProductFormBean form,
                                  BindingResult bindingResult){

        log.info("In the ADD TO CART controller method:");
        ModelAndView response = new ModelAndView("product/detail");
        log.info(form.toString());

        //add quantity integer value to return object
        response.addObject("quantity", quantity);

        //load product object with matching 'id': add product object to response object
        Product product = productDAO.findById(id);
        response.addObject("product",product);

        //check for error in the detail form - quantity - 'binding result'
        //if error found display debug notification, return to form without database upload
        if ( bindingResult.hasErrors() ) {
            for ( FieldError error : bindingResult.getFieldErrors()) {
                log.debug("Validation Error on field: " + error.getField());
                log.debug("Validation Error Message: " + error.getDefaultMessage());
            }
            response.addObject("form",form);
            response.addObject("bindingResult",bindingResult);
            return response;
        }

        // load user from authenticated user service
        User user = authenticatedUserService.loadCurrentUser();
        log.debug("Current User:" + user.getEmail());

        //create new order object: and set -(or)- load order
        Order order = new Order();

        //if order ID is already loaded in: return that order to the page
        if(orderId != null){
            order = orderDAO.findById(orderId);
            response.addObject("orderId", orderId);
            // if user has an open order: load that order and return it to the page
        }else if(orderDAO.findOpenOrder(user.getId()) != null){
            order = orderDAO.findOpenOrder(user.getId());
            response.addObject("orderId", order.getId());
        }
        //if user does not have a preloaded or open order: create a new order and return it to the page
        else {
            order.setUser(user);

            Date now = new Date();
            order.setOrderDate(now);

            order.setOrderStatus("Open");
            order.setCardNumber("1110444055507770");
            order.setCity("Philadelphia");
            order.setState("PA");
            order.setZipcode("19121");
            order.setAddressLine1("1001 Broad St");
            orderDAO.save(order);
            response.addObject("orderId", order.getId());

        }

        // set or load product in the order (order-products)

        // check for order-product record with matching product id and order id
        OrderProduct orderProduct = orderProductDAO.findOrderProductById(order.getId(), id);

        //if matching record found: update record's product-quantity field-value with form quantity value
        if(orderProduct != null){
            log.debug("Order Product found - ID: " + orderProduct.getId());
            orderProduct.setQuantity(form.getQuantity());
        }
        //if no matching record found: create a new record with product-quantity field-value set to form quantity value
        else{
            log.debug("no Order Product found");
            orderProduct.setOrder(order);
            orderProduct.setProduct(product);
            orderProduct.setQuantity(quantity);
        }

        //save created - (or)- modified order-product record into database
        orderProductDAO.save(orderProduct);

        log.debug("ORDER PRODUCT UPDATED!\n " +
                "Order #: " + order.getId() +
                " | Product #: " + id +
                " | Input Quantity #: " + quantity);
        log.debug("");

        return response;
    }
}
