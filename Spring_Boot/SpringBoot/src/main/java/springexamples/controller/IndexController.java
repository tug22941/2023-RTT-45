package springexamples.controller;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import springexamples.database.dao.UserDAO;
import springexamples.database.dao.UserRoleDAO;
import springexamples.database.entity.User;
import springexamples.database.entity.UserRole;
import springexamples.formbeans.CreateUserFormBean;

@Slf4j
@Controller
public class IndexController {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRoleDAO userRoleDAO;

    //make first message to handle incoming request
    @RequestMapping(value = {"/index","/", "/index.html"}, method = RequestMethod.GET)
    public ModelAndView index(HttpSession session) {
        log.debug("In the index controller method");
        ModelAndView response = new ModelAndView("index");

        log.trace("This is a trace log example");
        log.debug("This is a debug log example");
        log.info("This is an info log example");
        log.error("This is an error log example");
        log.warn("This is a warn log example");

        log.debug("Session Attribute Name: " + session.getAttribute("name"));

        return response;
    }

    //get mapping shortcut
    @GetMapping(value = "/signup")
    public ModelAndView signup(HttpSession session) {
        log.debug("In the signup GET controller method");
        ModelAndView response = new ModelAndView("signup");

        session.setAttribute("name", "Session set on Singup");
        return response;
    }
    @PostMapping("/signup")
    public ModelAndView signup(CreateUserFormBean form) {

        ModelAndView response = new ModelAndView("signup");
        log.debug("In the signup POST controller method");
        log.debug(form.toString());

        User user = new User();
        user.setEmail(form.getEmail());
        user.setFullName(form.getFullName());

        //This step is required by spring security to encrypt password on creation
        String encryptedPassword = passwordEncoder.encode(form.getPassword());
        user.setPassword(encryptedPassword);
        //save the user: when hibernate saves user it will auto generate the ID
        // -- AND it will populate the field in the entity
        userDAO.save(user); //SAVED IN DATABASE

        //create user role object
        UserRole userRole = new UserRole();
        userRole.setRoleName("USER");
        userRole.setUserId(user.getId());
        //user entity has an id from previous 'userDAO.save' database population
        userRoleDAO.save(userRole);

        return response;
    }

    @GetMapping(value = "/login")
    public ModelAndView login(HttpSession session) {
        log.debug("In the login GET controller method");
        ModelAndView response = new ModelAndView("login/login");

        session.setAttribute("name", "Session set on Login");
        return response;
    }


    @RequestMapping(value = "/bootstrap", method = RequestMethod.GET)
    public ModelAndView bootstrap(HttpSession session) {
        log.debug("In the bootstrap controller method");
        ModelAndView response = new ModelAndView("bootstrap");

        session.setAttribute("name", "Session set on Bootstrap");
        return response;
    }

}
