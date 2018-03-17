package com.atlyakov.vshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String showMainPage() {
        return "user/main";
    }

}
