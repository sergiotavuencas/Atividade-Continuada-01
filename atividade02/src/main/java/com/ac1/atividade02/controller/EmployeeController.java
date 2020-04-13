package com.ac1.atividade02.controller;

import com.ac1.atividade02.entity.Employee;
import com.ac1.atividade02.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class EmployeeController {
    
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/allEmployees")
    public ModelAndView getAllEmployees() {
        ModelAndView mv = new ModelAndView("employeeTemplate");
        mv.addObject("employees", employeeService.getAllEmployees());
        return mv;
    }

    @PostMapping("/register")
    public String register(@ModelAttribute Employee employee) {
        employeeService.createEmployee(employee);
        return "redirect:/allEmployees";
    }
}