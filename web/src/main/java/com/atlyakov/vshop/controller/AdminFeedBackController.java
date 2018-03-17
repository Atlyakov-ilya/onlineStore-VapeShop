package com.atlyakov.vshop.controller;

import com.atlyakov.vshop.controller.exception.ExceptionController;
import com.atlyakov.vshop.service.IFeedBackService;
import com.atlyakov.vshop.service.exception.ServiceException;
import com.atlyakov.vshop.service.model.FeedBackDTO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(value = "/admin")
public class AdminFeedBackController {
    private static final Logger LOGGER = Logger.getLogger(AdminFeedBackController.class);

    private IFeedBackService feedBackService;

    @Autowired
    public AdminFeedBackController(IFeedBackService feedBackService) {
        this.feedBackService = feedBackService;
    }


    @RequestMapping(value = "/show_user_message/{pageId}", method = RequestMethod.GET)
    public String getAllMessage(@PathVariable("pageId") Integer pageId, Model model) {
        List<FeedBackDTO> message;
        try {
            message = feedBackService.getAllMessage(pageId);
        } catch (ServiceException e) {
            LOGGER.error(e);
            throw new RuntimeException();
        }
        model.addAttribute("message", message);
        return "admin/show_user_message";
    }

    @RequestMapping("/show_user_message/removeFeedBack/{feedBackId}")
    public String removeFeedBack(@PathVariable("feedBackId") Integer feedBackId) {
        try {
            feedBackService.removeFeedBack(feedBackId);
        } catch (ServiceException e) {
            LOGGER.error(e);
        }
        return "redirect:/admin/show_user_message/1";
    }
}
