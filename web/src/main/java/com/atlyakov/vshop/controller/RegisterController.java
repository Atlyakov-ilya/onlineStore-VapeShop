package com.atlyakov.vshop.controller;

import com.atlyakov.vshop.controller.exception.ExceptionController;
import com.atlyakov.vshop.controller.validation.UserValidation;
import com.atlyakov.vshop.service.IUserService;
import com.atlyakov.vshop.service.exception.ServiceException;
import com.atlyakov.vshop.service.model.UserDTO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegisterController {
    private static final Logger LOGGER = Logger.getLogger(RegisterController.class);

    private IUserService userService;

    private UserValidation userValidation;

    @Autowired
    public RegisterController(IUserService userService, UserValidation userValidation) {
        this.userService = userService;
        this.userValidation = userValidation;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("userDTO") UserDTO userDTO, BindingResult result) {
               userValidation.validate(userDTO,result);
        if (!result.hasErrors()) {
            try {
                userService.registration(userDTO);
            } catch (ServiceException e) {
                LOGGER.error(e);
                throw new RuntimeException();
            }
            return "redirect:login";
        } else {
            return "register";
        }
    }
}
