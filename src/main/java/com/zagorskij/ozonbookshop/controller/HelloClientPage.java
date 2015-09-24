//Created by andrey on 20.06.2015.
package com.zagorskij.ozonbookshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloClientPage {
    @RequestMapping("/hello")
    public ModelAndView helloClient() {
        String message = "Hello! We are welcome you in our shop!";
        return new ModelAndView("hello", "msg", message);
    }
}