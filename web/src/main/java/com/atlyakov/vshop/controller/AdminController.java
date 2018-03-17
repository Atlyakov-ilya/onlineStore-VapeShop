package com.atlyakov.vshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @RequestMapping(value = "/main_admin", method = RequestMethod.GET)
    public String showRegisterPage() {
        return "admin/main_admin";
    }

}
