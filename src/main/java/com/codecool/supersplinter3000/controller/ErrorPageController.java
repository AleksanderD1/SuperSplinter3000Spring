package com.codecool.supersplinter3000.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;

@Controller
public class ErrorPageController implements ErrorController {
    @GetMapping("/error")
    public String handleError(HttpServletResponse response, Model model){
        if(response.getStatus() == HttpStatus.NOT_FOUND.value()){
            model.addAttribute("info", "We are sorry this page does not exist!");
        } else {
            model.addAttribute("info", "Unknow error occurred!");
        }
        return "error_page";
    }
}
