package com.kcprojects.mainsite.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WSChatController {
    private static Logger logger = LoggerFactory.getLogger(WSChatController.class);

    @RequestMapping("/wschattest")
    public String wsTest() {
        logger.debug("Request to /wschattest");
        return "wschattest";
    }

}