package org.example.securitymaster.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.securitymaster.dao.DepartmentDao;
import org.example.securitymaster.entity.Department;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentDao departmentDao;

    @GetMapping("/list-department")
    public ModelAndView listDepartment() {

        return new ModelAndView("department", "departments", departmentDao.findAll());
    }

    @GetMapping("/create-department")
    public ModelAndView createDepartment() {
        return new ModelAndView("departmentForm", "department", new Department());
    }

    @PostMapping("/save-department")
    public String saveDepartment(@Valid Department department, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "departmentForm";
        }
        departmentDao.save(department);
        return "redirect:/list-department";
    }

    @GetMapping("/delete-department")
    public String  deleteDepartment(@RequestParam("id") int id) {
        departmentDao.deleteById(id);
        return  "redirect:/list-department";
    }
}