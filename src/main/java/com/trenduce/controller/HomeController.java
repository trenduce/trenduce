package com.trenduce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by prafulmantale on 1/2/15.
 */
@Controller
public class HomeController {

    @RequestMapping(value = "/index")
    public String home(){

        return "index";
    }
}
