package org.example.securitymaster.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.securitymaster.dao.CustomerDao;
import org.example.securitymaster.entity.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerDao customerDao;

    @GetMapping("/list-customer")
    public ModelAndView customerList() {
        return new ModelAndView("customer", "customers", customerDao.findAll() );
        // page, modelAttribute and model
    }

    @GetMapping("/customer-form")
    public ModelAndView customerForm() {
        return new ModelAndView("customerForm", "customer", new Customer());
    }

    @PostMapping("/save-customer")
    public String saveCustomer(@Valid Customer customer, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "customerForm";
        }
        customerDao.save(customer);
        return "redirect:/list-customer";
    }

    @GetMapping("/delete-customer")
    public String deleteCustomer(@RequestParam int id) {
        customerDao.deleteById(id);
        return "redirect:/list-customer";
    }

}
