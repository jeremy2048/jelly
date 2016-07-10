package com.myjoshua.jelly.client;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by Jeremy on 7/3/2016.
 */
@Controller
@RequestMapping({"/register"})
public class RegistrationController {

    @RequestMapping(method=RequestMethod.POST)
    public String register(@Valid RegistrationData registration, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute(registration);
            return "register";
        } else {
            System.out.println("registration successful: " + registration.getEmail() + " [" + registration.getPassword() + "]");
            return "redirect:/home"; //plus user id
        }
    }

    @RequestMapping(method=RequestMethod.GET)
    public String register( Model model) {
        model.addAttribute(new RegistrationData());
        return "register";
    }

}
