package com.teksystems.controller;

import com.teksystems.database.dao.OrderDAO;
import com.teksystems.database.dao.ProductDAO;
import com.teksystems.database.dao.UserDAO;
import com.teksystems.database.entity.Order;
import com.teksystems.database.entity.Product;
import com.teksystems.database.entity.User;
import com.teksystems.formbeans.ProductFormBean;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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

        List<Product> products = productDAO.getAllProducts();
        response.addObject("productsList", products );

        Product product = new Product();

        if(form.getId() != null){
            product = productDAO.findById(form.getId());
        }
        product.setName(form.getName());
        product.setDescription(form.getDescription());
        //product.setImageUrl(form.ge);
        product.setPrice(form.getPrice());
        product.setProductType(form.getProductType());

        productDAO.save(product);
        response.addObject("form",form);

        //the target location of where the incoming file is to saved
        //File target = new File("./src/main/webapp/pub/images/" + fileUpload.getOriginalFilename());
        //log.debug(target.getAbsolutePath());

        //convenience method provided by commons-io library
        //the browser offer the file to be uploaded as an input stream to the server --
        // -- this method does all the work reading the  file upload input stream, and writing it to the target filesystem
        //FileUtils.copyInputStreamToFile(fileUpload.getInputStream(), target);

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

        Product product = productDAO.findById(id);
        response.addObject("product",product);

        log.debug(product + "");
        return response;
    }

    @GetMapping("/search")
    public ModelAndView search(@RequestParam(required = false) String search){
        log.info("In the Product Search controller method!");
        ModelAndView response = new ModelAndView("product/search");

        List<Product> products = new ArrayList<>();
        products = productDAO.findProductsBySearch(search);

        response.addObject("productsList",products);
        response.addObject("search",search);
        return response;
    }

    @GetMapping("/addToCart/{id}")
    public ModelAndView addToCart(@PathVariable Integer id,
                                  @RequestParam(required = false) String search,
                                  @RequestParam(required = false) Integer orderId,
                                  @RequestParam(required = false) Integer count){
        log.info("In the Product Add To Cart controller method!");
        ModelAndView response = new ModelAndView("product/search");

        response.addObject("search",search);

        List<Product> products = new ArrayList<>();
        products = productDAO.findProductsBySearch(search);
        response.addObject("productsList",products);

        //set user
        User user = userDAO.findById(1);
        Order order = new Order();

        //set orderId: current, open, or new
        if(orderId != null){
            order = orderDAO.findById(orderId);
            response.addObject("orderId", orderId);
        }else if(orderDAO.findOpenOrder(user.getId()) != null){
            order = orderDAO.findOpenOrder(user.getId());
            response.addObject("orderId", order.getId());
        }
        else {
            order.setUser(user);

            Date now = new Date();
            order.setOrderDate(now);

            order.setOrderStatus("Out for Delivery");
            order.setCardNumber("1110444055507770");
            order.setCity("Philadelphia");
            order.setState("PA");
            order.setZipcode("19121");
            order.setAddressLine1("1001 Broad St");
            orderDAO.save(order);
            response.addObject("orderId", order.getId());

        }
        response.addObject("count",count);

        log.debug("Order #: " + order.getId());
        log.debug("Product #: " + id);
        log.debug("Count #: " + count + "\n");

        //Product product = productDAO.findById(id);

        return response;
    }

}
