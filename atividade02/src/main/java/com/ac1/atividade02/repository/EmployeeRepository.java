package com.ac1.atividade02.repository;

import com.ac1.atividade02.entity.Employee;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository <Employee, Integer> {

}