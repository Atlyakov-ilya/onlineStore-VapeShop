package com.atlyakov.vshop.controller;

import com.atlyakov.vshop.controller.exception.ExceptionController;
import com.atlyakov.vshop.service.IAddressService;
import com.atlyakov.vshop.service.IUserService;
import com.atlyakov.vshop.service.exception.ServiceException;
import com.atlyakov.vshop.service.model.AddressDTO;
import com.atlyakov.vshop.service.model.UserDTO;
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
public class UserProfileController {
    private static final Logger LOGGER = Logger.getLogger(UserProfileController.class);

    private final IUserService userService;
    private final IAddressService addressService;

    @Autowired
    public UserProfileController(IUserService userService, IAddressService addressService) {
        this.userService = userService;
        this.addressService = addressService;
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String profileCurrentUser(Model model) {
        UserDTO user = null;
        AddressDTO addressDTO = null;
        try {
            user = userService.getCurrentUser();
            addressDTO = addressService.getAddressByUserId();
        } catch (ServiceException e) {
            LOGGER.error(e);
        }
        model.addAttribute("user", user);
        if (addressDTO != null) {
            model.addAttribute("address", addressDTO);
        }
        return "/user/profile";
    }

    @RequestMapping(value = "/profile/update", method = RequestMethod.GET)
    public String updateUser(Model model) {
        UserDTO user;
        try {
            user = userService.getCurrentUser();
        } catch (ServiceException e) {
            LOGGER.error(e);
            throw new RuntimeException();
        }
        model.addAttribute("userUpdate", user);
        return "/user/profile";
    }

    @RequestMapping(value = "/update/add", method = RequestMethod.POST)
    public String updateUserForm(@Valid @ModelAttribute("userDTO") UserDTO userDTO,
                                 BindingResult result, Model model) {
        AddressDTO addressDTO;
        UserDTO user;
        if (!result.hasErrors()) {
            try {
                userService.update(userDTO);
                user = userService.getCurrentUser();
                addressDTO = addressService.getAddressByUserId();
            } catch (ServiceException e) {
                LOGGER.error(e);
                throw new RuntimeException();
            }
            model.addAttribute("address", addressDTO);
            model.addAttribute("user", user);
            return "redirect:/user/profile";
        } else {
            model.addAttribute("errorUpdate", result);
            return "redirect:/user/profile/update";
        }
    }

    @RequestMapping(value = "/profile/address", method = RequestMethod.GET)
    public String addAddressForm(@ModelAttribute("addressDTO") AddressDTO addressDTO) {
        return "/user/profile_address";
    }

    @RequestMapping(value = "/profile/addressAdd", method = RequestMethod.POST)
    public String addAddressAdd(@Valid @ModelAttribute("addressDTO") AddressDTO addressDTO,
                                BindingResult result, Model model) {
        UserDTO user;
        if (!result.hasErrors()) {
            try {
                addressService.addAddress(addressDTO);
                addressDTO = addressService.getAddressByUserId();
                user = userService.getCurrentUser();
            } catch (ServiceException e) {
                LOGGER.error(e);
                throw new RuntimeException();
            }
            model.addAttribute("user", user);
            model.addAttribute("address", addressDTO);
            return "redirect:/user/profile";
        } else {
            return "/user/profile_address";
        }
    }

}
