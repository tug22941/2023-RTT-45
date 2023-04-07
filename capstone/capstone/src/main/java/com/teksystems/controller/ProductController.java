package com.teksystems.controller;

import com.teksystems.database.dao.ProductDAO;
import com.teksystems.database.entity.Product;
import com.teksystems.database.entity.User;
import com.teksystems.formbeans.ProductFormBean;
import com.teksystems.formbeans.UserFormBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductDAO productDAO;

    @GetMapping("/create")
    public ModelAndView create(){
        log.debug("In the Product Create controller method!");

        ModelAndView response = new ModelAndView("product/create");
        List<Product> products = productDAO.getAllProducts();
        response.addObject("productsList", products );

        return response;
    }

    @GetMapping("/createSubmit")
    public ModelAndView createSubmit(ProductFormBean form){
        log.debug("In the Product Create-Submit controller method!");
        log.debug(form.toString());

        ModelAndView response = new ModelAndView("product/create");

        Product product = new Product();

        if(form.getId() != null){
            product = productDAO.findById(form.getId());
        }
        product.setName(form.getName());
        product.setDescription(form.getDescription());
        product.setImageUrl(form.getImageUrl());
        product.setPrice(form.getPrice());
        product.setProductType(form.getProductType());


        productDAO.save(product);
        response.addObject("form",form);

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

}
