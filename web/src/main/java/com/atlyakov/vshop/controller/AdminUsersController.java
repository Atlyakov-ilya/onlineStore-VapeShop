package com.atlyakov.vshop.controller;

import com.atlyakov.vshop.controller.exception.ExceptionController;
import com.atlyakov.vshop.service.IUserService;
import com.atlyakov.vshop.service.exception.ServiceException;
import com.atlyakov.vshop.service.model.UserDTO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(value = "/admin")
public class AdminUsersController {
    private static final Logger LOGGER = Logger.getLogger(AdminUsersController.class);

    private IUserService userService;

    @Autowired
    public AdminUsersController(IUserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/show_users", method = RequestMethod.GET)
    public String getAllUser(Model model) {
        List<UserDTO> users;
        try {
            users = userService.getAll();
        } catch (ServiceException e) {
            LOGGER.error(e);
            throw new RuntimeException();
        }
        model.addAttribute("users", users);
        return "admin/show_users";
    }

    @RequestMapping("/remove/{userId}")
    public String removeUser(@PathVariable("userId") Integer userId) {
        try {
            userService.removeUser(userId);
        } catch (ServiceException e) {
            LOGGER.error(e);
            throw new RuntimeException();
        }
        return "redirect:/admin/show_users";
    }

    @RequestMapping(value = "/edit/{userId}", method = RequestMethod.GET)
    public String goToEditForm(@PathVariable("userId") Integer userId, Model model) {
        UserDTO user;
        List<UserDTO> users;
        try {
            user = userService.getUserById(userId);
            users = userService.getAll();
        } catch (ServiceException e) {
            LOGGER.error(e);
            throw new RuntimeException();
        }
        model.addAttribute("user", user);
        model.addAttribute("users", users);
        return "admin/show_users";
    }

    @RequestMapping(value = "/edit/add", method = RequestMethod.POST)
    public String editUserPage(@ModelAttribute("userDTO") UserDTO userDTO,
                               Model model) {
            List<UserDTO> users;
            try {
                userService.update(userDTO);
                users = userService.getAll();
            } catch (ServiceException e) {
                LOGGER.error(e);
                throw new RuntimeException();
            }
            model.addAttribute("users", users);
            return "redirect: /admin/show_users";
    }
}
