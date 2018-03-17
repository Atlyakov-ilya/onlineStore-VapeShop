package com.atlyakov.vshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/fragment")
public class FragmentController {

    @RequestMapping(value = "/navbar", method = RequestMethod.GET)
    public String showNavbarPage() {
        return "fragment/navbar";
    }

    @RequestMapping(value = "/header", method = RequestMethod.GET)
    public String showHeaderPage() {
        return "fragment/header";
    }

    @RequestMapping(value = "/footer", method = RequestMethod.GET)
    public String showFooterPage() {
        return "fragment/footer";
    }

    @RequestMapping(value = "/promo", method = RequestMethod.GET)
    public String showPromoPage() {
        return "fragment/promo";
    }

    @RequestMapping(value = "/categories", method = RequestMethod.GET)
    public String showCategoriesPage() {
        return "fragment/categories";
    }

    @RequestMapping(value = "/aboutUs", method = RequestMethod.GET)
    public String showAboutUsPage() {
        return "fragment/aboutUs";
    }

    @RequestMapping(value = "/blog", method = RequestMethod.GET)
    public String showBlogPage() {
        return "fragment/blog";
    }

    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public String showErrorPage() {
        return "fragment/error";
    }
}
