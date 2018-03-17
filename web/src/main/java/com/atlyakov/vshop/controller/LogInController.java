package com.atlyakov.vshop.controller;

import com.atlyakov.vshop.service.model.UserDTO;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
public class LogInController {
    private static final Logger LOGGER = Logger.getLogger(LogInController.class);

    @RequestMapping(value = {"/", "/login"}, method = RequestMethod.GET)
    public String showWelcomePage() { return "login"; }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegisterPage(@ModelAttribute("userDTO") UserDTO userDTO) {
        return "register";
    }

    @RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
    public ModelAndView accessDenied(Principal user) {

        ModelAndView model = new ModelAndView();

        if (user != null) {
            model.addObject("errorMsg", user.getName() + " у вас нет доступа к этой странице!");
        } else {
            model.addObject("errorMsg", "У вас нет доступа к этой странице!");
        }

        model.setViewName("/fragment/accessDenied");
        return model;
    }
}
