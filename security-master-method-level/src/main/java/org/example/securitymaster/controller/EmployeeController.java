package org.example.securitymaster.controller;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.example.securitymaster.annotation.SuperAdmin;
import org.example.securitymaster.dao.EmployeeDao;
import org.example.securitymaster.entity.Employee;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeDao employeeDao;

    @Secured({"ROLE_SUPER_ADMIN","ROLE_DEPARTMENTS_PAG_VIEW", "DEPARTMENTS_READ"})
    @GetMapping("/list-employee")
    public String listEmployee(Model model) {
        model.addAttribute("employees", employeeDao.findAll());
        return "employee";
    }


    @Secured({"ROLE_SUPER_ADMIN", "ROLE_DEPARTMENTS_CREATE"})
    @GetMapping("/employee-form")
    public String addEmployee(Model model) {
        model.addAttribute("employee", new Employee());
        return "employeeForm";
    }


    @Secured({"ROLE_SUPER_ADMIN", "ROLE_DEPARTMENTS_CREATE"})
    @PostMapping("/employee-save")
    public String saveEmployee(@Valid Employee employee, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "employeeForm";
        }
        employeeDao.save(employee);
        return "redirect:/list-employee";

    }

    @SuperAdmin
    @GetMapping("/employee-delete")
    public String deleteEmployee(@RequestParam Integer id) {
        employeeDao.deleteById(id);
        return "redirect:/list-employee";
    }

}
