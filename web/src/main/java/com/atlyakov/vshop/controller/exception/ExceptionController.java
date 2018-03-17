package com.atlyakov.vshop.controller.exception;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;

@ControllerAdvice
public class ExceptionController {
    private static final Logger LOGGER = Logger.getLogger(ExceptionController.class);

    @ExceptionHandler(value = RuntimeException.class)
    public String processException(Exception e){
        LOGGER.error(e.getMessage(), e);
        return "redirect:/login";
    }

}
