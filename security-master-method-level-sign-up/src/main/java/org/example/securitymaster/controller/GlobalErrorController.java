package org.example.securitymaster.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GlobalErrorController implements ErrorController {

    @RequestMapping("/error")
    public String error(HttpServletRequest request, Model model) {
        Integer statusCode = (Integer) request.getAttribute("jakarta.servlet.error.status_code");
        String errorMessage = switch (statusCode) {
            case 403 -> "Forbidden, This Person's Not Allowed";
            case 404 -> "Not Found";
            case 500 -> "Internal Server Error";
            default -> "Some Error";
        };
        model.addAttribute("errorMessage", errorMessage);
        model.addAttribute("statusCode", statusCode);
        return "error";
    }
}
