package com.planner.planner.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;

public class CustomErrorController implements ErrorController{
    private static final String PATH = "/error";

    @RequestMapping(value = PATH)
    public String error() {
        return "customError";
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
}
