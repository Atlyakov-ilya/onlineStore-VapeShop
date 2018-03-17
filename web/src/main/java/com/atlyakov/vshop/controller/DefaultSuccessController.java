package com.atlyakov.vshop.controller;

import com.atlyakov.vshop.entity.enums.Role;
import com.atlyakov.vshop.service.model.AppUserPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DefaultSuccessController {
    @RequestMapping(value = "/filter", method = RequestMethod.GET)
    public String filterDirectedUrl() {
        AppUserPrincipal principal = (AppUserPrincipal) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        if (principal.getRole() == Role.ROLE_USER) {
            return "redirect:/user/main";
        } else if (principal.getRole() == Role.ROLE_ADMIN) {
            return "redirect:/admin/main_admin";
        } else {
            return "redirect:/login";
        }
    }
}
