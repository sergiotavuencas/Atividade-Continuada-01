package com.ac1.atividade02.controller;

import javax.validation.Valid;

import com.ac1.atividade02.entity.Employee;
import com.ac1.atividade02.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/employee")
public class EmployeeController {
    
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/home")
    public String employeeHome() {
        return "employeeHome";
    }

    @GetMapping("/all")
    public ModelAndView getAllEmployees() {
        ModelAndView mv = new ModelAndView("registeredEmployees");
        mv.addObject("employees", employeeService.getAllEmployees());
        return mv;
    }

    @GetMapping("/register")
    public String registerForm(Employee employee) {
        return "registerEmployee";
    }

    @PostMapping("/register")
    public String saveEmployee( @Valid Employee employee, BindingResult bindingResult) {
        if(bindingResult.hasErrors())
        {
            return "registerError";
        }
        employeeService.createEmployee(employee);
        return "redirect:/employee/all";
    }
}