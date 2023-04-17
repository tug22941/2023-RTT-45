package com.teksystems.controller;

import com.teksystems.database.dao.ProductDAO;
import com.teksystems.database.entity.Product;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
public class SlashController {

    @Autowired
    ProductDAO productDAO;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView index() {
        log.info("In the index controller method");
        ModelAndView response = new ModelAndView("index");
        return response;
    }

    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public ModelAndView about() {
        log.debug("In the about controller method");
        ModelAndView response = new ModelAndView("about");
        return response;
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public ModelAndView signup() {
        log.debug("In the signup controller method");
        ModelAndView response = new ModelAndView("signup");
        return response;
    }

    @GetMapping(value = "/login")
    public ModelAndView login(HttpSession session) {
        log.debug("In the login GET controller method");
        ModelAndView response = new ModelAndView("login/login");

        session.setAttribute("name", "Session set on Login");
        return response;
    }
    @GetMapping("/search")
    public ModelAndView search(@RequestParam(required = false) String search){
        log.info("In the Product Search controller method!");
        ModelAndView response = new ModelAndView("search");

        List<Product> products = new ArrayList<>();
        products = productDAO.findProductsBySearch(search);

        response.addObject("productsList",products);
        response.addObject("search",search);
        return response;
    }

}
