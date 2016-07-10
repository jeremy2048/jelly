package com.myjoshua.jelly.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Jeremy on 7/4/2016.
 */
@Controller
@RequestMapping("/home")
public class HomeController {

    @RequestMapping(method= RequestMethod.GET)
    public String home() {
        return "home";
    }
}
