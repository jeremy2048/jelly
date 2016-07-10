package com.myjoshua.jelly;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Jeremy on 7/3/2016.
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String index() {
        return "Greeting from Spring Boot!";
    }

}
