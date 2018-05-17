package com.kcprojects.mainsite.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainRequestController {
    private static Logger logger = LoggerFactory.getLogger(MainRequestController.class);

    @Autowired
    HttpServletRequest request;

    @RequestMapping("/")
    public ModelAndView defaultRedirect() {
        logger.debug("Request to /");
        return new ModelAndView("redirect:/main");
    }

    @GetMapping("/main")
    public String main() {
        logger.debug("Request to /main");
        logger.debug(request.getHeader("referer"));
        return "main";
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request) {
        logger.debug("Request to /login");
        logger.debug("remote ip: " + request.getRemoteAddr());
        return "login";
    }

    @RequestMapping("/admin")
    public String adminPage() {
        logger.debug("Request to /admin");
        return "admin";
    }

    @RequestMapping("/about")
    public String about() {
        logger.debug("Request to /about");
        return "about";
    }
}
