package org.example.apiuidemo.controller;

import lombok.RequiredArgsConstructor;
import org.example.apiuidemo.entity.Customer;
import org.example.apiuidemo.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping("/api-ui")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/customer-list")
    public String getCustomerList(Model model) {
        model.addAttribute("customers", customerService.getCustomers());
        return "customer";
    }
}
