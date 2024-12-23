package org.example.springmvcscope.controller;

import lombok.RequiredArgsConstructor;
import org.example.springmvcscope.bean.ApplicationScopeBean;
import org.example.springmvcscope.bean.RequestScopeBean;
import org.example.springmvcscope.bean.SessionScopeBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class ScopeController {

    private final RequestScopeBean reqScopeBean;
    private final SessionScopeBean sessionScopeBean;
    private final ApplicationScopeBean applicationScopeBean;

    @RequestMapping("/")
    public String showScopeValue(Model model) {
        model.addAttribute("reqScopeBean", reqScopeBean.getRequestCount());
        model.addAttribute("sessionScopeBean", sessionScopeBean.getSessionCount());
        model.addAttribute("applicationScopeBean", applicationScopeBean.getApplicationScopeCount());

        return "index";
    }

    @PostMapping("/save-request-value")
    public String saveRequestValue(@RequestParam("requestValue") int value) {
        reqScopeBean.setRequestCount(value);
        return "forward:/";
    }

    @PostMapping("/save-session-value")
    public String saveSessionValue(@RequestParam("sessionValue") int value) {
        sessionScopeBean.setSessionCount(value);
        return "forward:/";
    }

    @PostMapping("/save-application-value")
    public String saveApplicationValue(@RequestParam("applicationValue") int value) {
        applicationScopeBean.setApplicationScopeCount(value);
        return "forward:/";
    }
}
