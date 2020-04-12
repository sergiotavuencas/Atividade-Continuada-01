package com.ac1.atividade02.controller;

import com.ac1.atividade02.entity.Employee;
import com.ac1.atividade02.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/register")
    public String register() {
        return "registerEmployee";
    }

    @PostMapping("/register")
    public ModelAndView registerForm(@ModelAttribute Employee employee) {
        ModelAndView mv = new ModelAndView();

        employee = employeeService.createEmployee(employee.getName(), employee.getRole(), employee.getSalary());

        if(employee != null) {
            mv.setViewName("allEmployees");
            mv.addObject("employees", employeeService.getAllEmployees());
        } else {
            mv.setViewName("registrationError");
        }

        return mv;
    }

    @GetMapping("/allEmployees")
    public ModelAndView getAllEmployees() {
        ModelAndView mv = new ModelAndView("allEmployees");
        mv.addObject("employees", employeeService.getAllEmployees());
        return mv;
    }
}