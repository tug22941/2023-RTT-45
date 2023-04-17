package com.teksystems.controller;

import com.teksystems.database.dao.ProductDAO;
import com.teksystems.database.dao.UserDAO;
import com.teksystems.database.entity.Product;
import com.teksystems.database.entity.User;
import com.teksystems.formbeans.ProductFormBean;
import com.teksystems.formbeans.UserFormBean;
import com.teksystems.security.AuthenticatedUserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
public class SlashController {

    @Autowired
    ProductDAO productDAO;

    @Autowired
    UserDAO userDAO;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticatedUserService authenticatedUserService;

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

    @PostMapping("/signupSubmit")
    public ModelAndView createSubmit(HttpSession session, @Valid UserFormBean  form,
                                     BindingResult bindingResult){

        log.debug("Inside the signup submit controller");
        ModelAndView response = new ModelAndView("signup");

        //return the form input values to the page
        log.debug(form.toString());
        response.addObject("form", form);

        if (StringUtils.equals(form.getPassword(), form.getConfirmPassword()) == false){
            bindingResult.rejectValue("confirmPassword", "error.confirmPassword", "Passwords do not match");
        }

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
        //no errors found in the incoming data
        response.addObject("success", true);

        User user = new User();

        if(form.getId() != null){
            user = userDAO.findById(form.getId());
        }
        user.setFirstName(form.getFirstName());
        user.setLastName(form.getLastName());
        user.setEmail(form.getEmail());

        //This step is required by spring security to encrypt password on creation
        String encryptedPassword = passwordEncoder.encode(form.getPassword());
        user.setPassword(encryptedPassword);

        userDAO.save(user);
        response.addObject("form",form);

        //set the id of the employee of the form bean so that it triggers the page to be an edit
        //if the id is present on the form it is considered an edit
        form.setId(user.getId());


        //redirect to new page
        //response.setViewName("redirect:/index");

        //very important that this line of code is after both the user and the user role is saved to the database
        // authenticate the user that was just created
        authenticatedUserService.changeLoggedInUsername(session, form.getEmail(), form.getPassword());

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
