package com.teksystems.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class SlashController {


    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView index() {
        log.info("In the index controller method");
        ModelAndView response = new ModelAndView("index");
        return response;
    }

    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public ModelAndView about() {
        log.info("In the about controller method");
        ModelAndView response = new ModelAndView("about");
        return response;
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public ModelAndView signup() {
        log.info("In the signup controller method");
        ModelAndView response = new ModelAndView("signup");

        //if(!StringUtils.isEmpty(signup)){
        //}

        return response;
    }

}
