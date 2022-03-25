package com.vega.springit.controler;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeControler {

    @RequestMapping("/")
    public String home()
    {
        return "hello";
    }
}
