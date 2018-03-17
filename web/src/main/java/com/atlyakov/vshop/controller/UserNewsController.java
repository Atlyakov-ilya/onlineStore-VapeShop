package com.atlyakov.vshop.controller;

import com.atlyakov.vshop.controller.exception.ExceptionController;
import com.atlyakov.vshop.service.INewsService;
import com.atlyakov.vshop.service.exception.ServiceException;
import com.atlyakov.vshop.service.model.NewsDTO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(value = "/user")
public class UserNewsController {
    private static final Logger LOGGER = Logger.getLogger(UserNewsController.class);

    private INewsService newsService;

    @Autowired
    public UserNewsController(INewsService newsService) {
        this.newsService = newsService;
    }


    @RequestMapping(value = "/show_news", method = RequestMethod.GET)
    public String getAllNews(Model model) {
        List<NewsDTO> news;
        try {
            news = newsService.getAll();
        } catch (ServiceException e) {
            LOGGER.error(e);
            throw new RuntimeException();
        }
        model.addAttribute("news", news);
        return "/user/show_news";
    }

    @RequestMapping(value = "show_one_news/{newsId}", method = RequestMethod.GET)
    public String showOneNews(@PathVariable("newsId") Integer newsId, Model model) {
        NewsDTO news;
        try {
            news = newsService.getNewsById(newsId);
        } catch (ServiceException e) {
            LOGGER.error(e);
            throw new RuntimeException();
        }
        model.addAttribute("news", news);
        return "/user/show_one_news";
    }
}
