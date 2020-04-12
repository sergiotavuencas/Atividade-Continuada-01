package com.ac1.atividade02.service;

import java.util.List;

import com.ac1.atividade02.entity.Employee;
import com.ac1.atividade02.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public Employee createEmployee(String name, String role, double salary) {
        Employee employee = new Employee();
        Employee aux = null;

        employee.setName(name.toUpperCase());
        employee.setRole(role.toUpperCase());
        employee.setSalary(salary);

        employeeRepository.save(employee);

        for(Employee emp : employeeRepository.findAll())
        {
            if(emp.equals(employee))
                aux = emp;
        }

        return aux;
    }

    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }
}