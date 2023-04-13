package springexamples.controller;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import springexamples.database.dao.UserDAO;
import springexamples.database.entity.User;
import springexamples.formbeans.CreateUserFormBean;
import springexamples.security.AuthenticatedUserService;


@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticatedUserService authenticatedUserService;

    @PostMapping("/signupSubmit")
    public ModelAndView setup(HttpSession session, @Valid CreateUserFormBean form,
                              BindingResult bindingResult) {
        log.debug("In the User Signup - Submit controller method!");
        log.debug(form.toString());

        ModelAndView response = new ModelAndView("signup");

        //if error found display debug notification, return to form without database upload
        if ( bindingResult.hasErrors() ) {
            for ( FieldError error : bindingResult.getFieldErrors()) {
                log.debug("Validation Error on field : " + error.getField() + " with message : " + error.getDefaultMessage());
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
        user.setFullName(form.getFullName());
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

}
