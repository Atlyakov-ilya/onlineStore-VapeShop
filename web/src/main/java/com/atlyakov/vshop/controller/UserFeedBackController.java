package com.atlyakov.vshop.controller;

import com.atlyakov.vshop.controller.exception.ExceptionController;
import com.atlyakov.vshop.service.IFeedBackService;
import com.atlyakov.vshop.service.exception.ServiceException;
import com.atlyakov.vshop.service.model.FeedBackDTO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/user")
public class UserFeedBackController {
    private static final Logger LOGGER = Logger.getLogger(UserFeedBackController.class);

    private IFeedBackService feedBackService;

    @Autowired
    public UserFeedBackController(IFeedBackService feedBackService) {
        this.feedBackService = feedBackService;
    }


    @RequestMapping(value = "/add_feed_back", method = RequestMethod.GET)
    public String showAddFeedBackPage(@ModelAttribute("feedBack") FeedBackDTO feedBackDTO) {
        return "user/add_feed_back";
    }

    @RequestMapping(value = "/user/add_feed_back", method = RequestMethod.POST)
    public String saveMessage(@Valid @ModelAttribute("feedBack") FeedBackDTO feedBackDTO,
                              BindingResult result, Model model) {
        if (!result.hasErrors()) {
            try {
                feedBackService.addMessage(feedBackDTO);
            } catch (ServiceException e) {
                LOGGER.error(e);
                throw new RuntimeException();
            }
            model.addAttribute("successful", "Sending the message was successful");
            return "user/add_feed_back";
        } else {
            return "user/add_feed_back";
        }
    }
}
