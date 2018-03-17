package com.atlyakov.vshop.controller;

import com.atlyakov.vshop.controller.exception.ExceptionController;
import com.atlyakov.vshop.service.INewsService;
import com.atlyakov.vshop.service.exception.ServiceException;
import com.atlyakov.vshop.service.model.NewsDTO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "/admin")
public class AdminNewsController {
    private static final Logger LOGGER = Logger.getLogger(AdminNewsController.class);

    private INewsService newsService;

    @Autowired
    public AdminNewsController(INewsService newsService) {
        this.newsService = newsService;
    }

    @RequestMapping(value = "/add_news", method = RequestMethod.GET)
    public String showAddNewsPage(@ModelAttribute("newsDTO") NewsDTO newsDTO) {
        return "admin/add_news";
    }

    @RequestMapping(value = "/admin/add_news", method = RequestMethod.POST)
    public String saveNews(@Valid @ModelAttribute("newsDTO") NewsDTO newsDTO, BindingResult result) {
        if (!result.hasErrors()) {
            try {
                newsService.saveNews(newsDTO);
            } catch (ServiceException e) {
                throw new RuntimeException();
            }
            return "admin/add_news";
        } else {
            return "admin/add_news";
        }
    }

    @RequestMapping(value = "/show_all_news", method = RequestMethod.GET)
    public String getAllNews(Model model) {
        List<NewsDTO> newsList;
        try {
            newsList = newsService.getAll();
        } catch (ServiceException e) {
            LOGGER.error(e);
            throw new RuntimeException();
        }
        model.addAttribute("newsList", newsList);
        return "/admin/show_all_news";
    }

    @RequestMapping(value = "show_news_details/{newsId}", method = RequestMethod.GET)
    public String showOneNews(@PathVariable("newsId") Integer newsId, Model model) {
        NewsDTO news;
        try {
            news = newsService.getNewsById(newsId);
        } catch (ServiceException e) {
            LOGGER.error(e);
            throw new RuntimeException();
        }
        model.addAttribute("news", news);
        return "admin/news_details";
    }

    @RequestMapping(value = "/show_all_news/removeNews/{newsId}")
    public String removeNews(@PathVariable("newsId") Integer newsId) {
        try {
            newsService.removeNews(newsId);
        } catch (ServiceException e) {
            LOGGER.error(e);
            throw new RuntimeException();
        }
        return "redirect:/admin/show_all_news";
    }

    @RequestMapping(value = "/editNews/{newsId}", method = RequestMethod.GET)
    public String editNews(@PathVariable("newsId") Integer newsId, Model model) {
        NewsDTO news;
        try {
            news = newsService.getNewsById(newsId);
        } catch (ServiceException e) {
            LOGGER.error(e);
            throw new RuntimeException();
        }
        model.addAttribute("newsEdit", news);
        model.addAttribute("news", news);
        return "admin/news_details";
    }

    @RequestMapping(value = "/editNews/add", method = RequestMethod.GET)
    public String addEditNews(@Valid @ModelAttribute("newsDTO") NewsDTO newsDTO, BindingResult result,
                              Model model) {
        List<NewsDTO> newsList;
        NewsDTO news;
        if (!result.hasErrors()) {
            try {
                newsService.editNews(newsDTO);
                newsList = newsService.getAll();
            } catch (ServiceException e) {
                LOGGER.error(e);
                throw new RuntimeException();
            }
            model.addAttribute("newsList", newsList);
            return "admin/show_all_news";
        }
        try {
            news = newsService.getNewsById(newsDTO.getNewsId());
        } catch (ServiceException e) {
            LOGGER.error(e);
            throw new RuntimeException();
        }
        model.addAttribute("news", news);
        return "admin/news_details";
    }


}
