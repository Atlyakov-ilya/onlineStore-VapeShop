package com.atlyakov.vshop.controller.validation;


import com.atlyakov.vshop.service.model.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidation implements Validator {

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(UserDTO.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        UserDTO user = (UserDTO) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"mail","error.email.empty");
        if(!user.getMail().matches("^[-\\w.]+@([A-z0-9][-A-z0-9]+\\.)+[A-z]{2,4}$")){
            errors.rejectValue("mail", "error.email.pattern");
        }
        ValidationUtils.rejectIfEmpty(errors, "username", "error.username.empty");
        if (user.getUsername().length() < 3) {
            errors.rejectValue("username", "error.username.length");
        }
        UserDetails userDetails = null;
        try {
            userDetails = userDetailsService.loadUserByUsername(user.getUsername());
        } catch (UsernameNotFoundException e) {
        }
        if (userDetails != null) {
            errors.rejectValue("username", "error.username.exist");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.password.empty");
        if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "error.password.length");
        }

        if (user.getConfirmPassword() == null & !user.getConfirmPassword().equals(user.getPassword())) {
            errors.rejectValue("confirmPassword", "error.password.repeat");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"firstName","error.firstName.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"lastName","error.firstName.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"middleName","error.firstName.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"phoneNumber","error.phoneNumber.empty");

        if(!user.getPhoneNumber().matches("^(\\+375|80)(29|25|44|33)(\\d{3})(\\d{2})(\\d{2})$")){
            errors.rejectValue("phoneNumber", "error.phoneNumber.pattern");
        }
    }
}
