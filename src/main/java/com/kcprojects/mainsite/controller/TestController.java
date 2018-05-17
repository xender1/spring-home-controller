package com.kcprojects.mainsite.controller;

import java.util.Arrays;

import com.kcprojects.mainsite.TestBeanObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestController {

    TestBeanObject myTestBean;

    @Autowired
    public void setTestBeanObject(TestBeanObject testBeanObject) {
        this.myTestBean = testBeanObject;
    }
    
    @GetMapping("/test")
    public String testbeantwo(Model model) {
        myTestBean.increaseCount();
        model.addAttribute("mycounter", myTestBean.getCount());
        return "test";
    }

    @Autowired
    ApplicationContext ctx;

    @GetMapping("/beans")
    public String beans(@RequestParam(required = false) String q, Model model) {
        //Map<String, String[]> retMap = new HashMap<>();
 
        String[] retArray = Arrays.stream(ctx.getBeanDefinitionNames())
            .filter(beanName ->
                (q == null || q.length() == 0) ||
                beanName.toLowerCase().contains(q.trim().toLowerCase())
            )
            .toArray(String[]::new);
 
        model.addAttribute("beanlist", retArray);
        return "test";
    }

}
