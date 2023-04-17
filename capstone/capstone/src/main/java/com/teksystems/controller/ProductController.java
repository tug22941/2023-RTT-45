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
import com.teksystems.formbeans.ProductFormBean;
import com.teksystems.security.AuthenticatedUserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductDAO productDAO;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private OrderDAO orderDAO;

    @Autowired
    private OrderProductDAO orderProductDAO;

    @Autowired
    AuthenticatedUserService authenticatedUserService;

    @GetMapping("/create")
    public ModelAndView create(){
        log.debug("In the Product Create controller method!");

        ModelAndView response = new ModelAndView("product/create");
        List<Product> products = productDAO.getAllProducts();
        response.addObject("productsList", products );

        return response;
    }

    @PostMapping("/createSubmit")
    public ModelAndView createSubmit(ProductFormBean form) throws IOException {
        log.debug("In the Product Create-Submit controller method!");
        log.debug(form.toString());

        ModelAndView response = new ModelAndView("product/create");

        Product product = new Product();

        if(form.getId() != null){
            product = productDAO.findById(form.getId());
        }
        product.setName(form.getName());
        product.setDescription(form.getDescription());
        product.setImageUrl("/pub/images/" + form.getPicture().getOriginalFilename());
        product.setPrice(form.getPrice());
        product.setProductType(form.getProductType());

        productDAO.save(product);
        response.addObject("form",form);

        //the target location of where the incoming file is to saved
        File target = new File("./src/main/webapp/pub/images/" + form.getPicture().getOriginalFilename());
        log.debug(target.getAbsolutePath());

        //convenience method provided by commons-io library
        //the browser offer the file to be uploaded as an input stream to the server --
        // -- this method does all the work reading the  file upload input stream, and writing it to the target filesystem
        FileUtils.copyInputStreamToFile(form.getPicture().getInputStream(), target);

        List<Product> products = productDAO.getAllProducts();
        response.addObject("productsList", products );

        return response;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable Integer id){

        log.debug("In Product edit controller method");
        ModelAndView response = new ModelAndView("product/create");

        Product product = productDAO.findById(id);
        ProductFormBean form = new ProductFormBean();

        //set the product form fields: to be added to the model and returned to the view
        form.setId(product.getId());
        form.setName(product.getName());
        form.setDescription((product.getDescription()));
        form.setImageUrl(product.getImageUrl());
        form.setPrice(product.getPrice());
        form.setProductType(product.getProductType());
        response.addObject("form",form);

        List<Product> products = productDAO.getAllProducts();
        response.addObject("productsList", products );

        return response;
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable Integer id){
        log.debug("In the Product Detail controller method!");
        ModelAndView response = new ModelAndView("product/detail");

        //load product: return product to the page to load the product detail information
        Product product = productDAO.findById(id);
        response.addObject("product",product);

        //load user from authenticated user service
        User user = authenticatedUserService.loadCurrentUser();
        log.debug("Current User:" + user.getEmail());

        // if user has an open order: load that order and return it to the page
        Order order = new Order();
        if(orderDAO.findOpenOrder(user.getId()) != null){
            order = orderDAO.findOpenOrder(user.getId());
            response.addObject("orderId", order.getId());
        }

        // check if there is already a product matching our product ID in the order-product
        // that belongs to our current order ID
        OrderProduct orderProduct = orderProductDAO.findOrderProductById(order.getId(), id);

        //if there is a matching record found: return the quantity to the page
        if(orderProduct != null){
            log.debug("Order Product found - ID: " + orderProduct.getId());
            response.addObject("quantity", orderProduct.getQuantity());
        }



        log.debug(product + "");
        return response;
    }

    @GetMapping("/addToCart/{id}")
    public ModelAndView addToCart(@PathVariable Integer id,
                                  @RequestParam(required = false) Integer orderId,
                                  @RequestParam(required = false) Integer quantity,
                                  @Valid OrderProductFormBean form,
                                  BindingResult bindingResult){
        log.info("In the Product Add To Cart controller method!");
        ModelAndView response = new ModelAndView("product/detail");

        //return quantity input to page
        response.addObject("quantity", quantity);

        //return product to load the product detail information
        Product product = productDAO.findById(id);
        response.addObject("product",product);

        //error check that quantity value is within range
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

        //1) LOAD USER from authenticated user service
        User user = authenticatedUserService.loadCurrentUser();
        log.debug("Current User:" + user.getEmail());

        //2) SET OR LOAD ORDER
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

        //3) SET OR LOAD PRODUCT IN THE ORDER (ORDER-PRODUCTS)

        // check if there is already a product matching our product ID in the order-product
        // that belongs to our current order ID
        OrderProduct orderProduct = orderProductDAO.findOrderProductById(order.getId(), id);

        //if there is a matching record found: update record product quantity with form quantity
        if(orderProduct != null){
            log.debug("Order Product found - ID: " + orderProduct.getId());
            orderProduct.setQuantity(form.getQuantity());
        }
        //if there is not a matching record found: create a new record with product quantity set to form quantity
        else{
            log.debug("no Order Product found");
            orderProduct.setOrder(order);
            orderProduct.setProduct(product);
            orderProduct.setQuantity(quantity);
        }
        orderProductDAO.save(orderProduct);

        log.debug("Order #: " + order.getId());
        log.debug("Product #: " + id);
        log.debug(" Input Quantity #: " + quantity + "\n");

        return response;
    }

}
