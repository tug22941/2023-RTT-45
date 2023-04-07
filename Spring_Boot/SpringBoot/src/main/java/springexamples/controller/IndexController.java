package springexamples.controller;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import springexamples.formbeans.CreateUserFormBean;

@Slf4j
@Controller
public class IndexController {

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

        session.setAttribute("name", "Session set on Signup");
        return response;
    }

    @PostMapping("/signup")
    public ModelAndView signup(CreateUserFormBean form) {

        ModelAndView response = new ModelAndView("signup");
        log.debug("In the signup POST controller method");

        log.debug(form.toString());

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
