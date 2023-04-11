package com.teksystems.controller;

import com.teksystems.database.dao.UserDAO;
import com.teksystems.database.entity.User;
import com.teksystems.formbeans.UserFormBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/create")
    public ModelAndView create(){
        log.debug("In the User Create controller method!");

        ModelAndView response = new ModelAndView("user/create");
        List<User> users = userDAO.getAllUsers();
        response.addObject("usersList", users );

        return response;
    }

    @GetMapping("/createSubmit")
    public ModelAndView createSubmit(UserFormBean form){
        log.debug("In the User Create-Submit controller method!");
        log.debug(form.toString());

        ModelAndView response = new ModelAndView("user/create");

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

        List<User> users = userDAO.getAllUsers();
        response.addObject("usersList", users );

        return response;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable Integer id){

        log.debug("In User edit controller method");
        ModelAndView response = new ModelAndView("user/create");

        User user = userDAO.findById(id);
        UserFormBean form = new UserFormBean();

        //set the user form fields: to be added to the model and returned to the view
        form.setId(user.getId());
        form.setFirstName(user.getFirstName());
        form.setLastName(user.getLastName());
        form.setEmail(user.getEmail());
        form.setPassword(user.getPassword());
        response.addObject("form",form);

        List<User> users = userDAO.getAllUsers();
        response.addObject("usersList", users );

        return response;
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable Integer id){
        log.debug("In the User Detail controller method!");

        ModelAndView response = new ModelAndView("user/detail");
        User user = userDAO.findById(id);

        response.addObject("user",user);
        log.debug(user + "");
        return response;
    }

}
