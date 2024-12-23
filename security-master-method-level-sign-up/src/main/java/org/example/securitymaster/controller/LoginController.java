package org.example.securitymaster.controller;

import lombok.RequiredArgsConstructor;
import org.example.securitymaster.security.ds.SignUpModel;
import org.example.securitymaster.service.UserSignUpService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final UserSignUpService userSignUpService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/sign-up-form")
    public String signUpForm(Model model) {
        model.addAttribute("signUpModel", new SignUpModel());
        return "signUpForm";
    }

    @PostMapping("/sign-up-form/sign-up-save")
    public String signUpSave(SignUpModel signUpModel, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "signUpForm";
        }
        userSignUpService.signUp(signUpModel);
        return "redirect:/login";
    }
}
