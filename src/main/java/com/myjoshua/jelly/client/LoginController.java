package com.myjoshua.jelly.client;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.validation.Valid;

/**
 * Created by Jeremy on 7/3/2016.
 */
@Controller
@RequestMapping({"/", "/login"})
public class LoginController {

    @RequestMapping(method=RequestMethod.GET)
    public String loginPage(Model model) {
        model.addAttribute(new LoginData());
        return "login";
    }

    @RequestMapping(method=RequestMethod.POST)
    public String login(@Valid LoginData login, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute(login);
            return "login";
        }
        //validate login
        System.out.println("Login Successful: " + login.getEmail() + " [" + login.getPassword() + "]");
        return "redirect:/home"; //plus user id
    }
}
