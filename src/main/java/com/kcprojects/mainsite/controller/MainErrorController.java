package com.kcprojects.mainsite.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainErrorController implements ErrorController {
    private static Logger logger = LoggerFactory.getLogger(MainErrorController.class);

    @Autowired
    HttpServletRequest request;

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request, Model model) {
        logger.debug("Request to /error");

        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        if (status != null) {
            Integer statusCode = Integer.valueOf(status.toString());
            logger.debug("Error code: " + statusCode);
            model.addAttribute("statusCode", statusCode);
        }

        return "error";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}