package com.ac1.atividade02.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Employee
 */
@Entity
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotBlank
    @Column(name = "name", length = 80)
    private String name;

    @NotBlank
    @Column(name = "role", length = 40)
    private String role;

    @NotNull
    @Column(name = "salary", precision = 10, scale = 2)
    private double salary;

    @NotBlank
    @Column(name = "graduation", length = 40)
    private String graduation;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getGraduation() {
        return graduation;
    }

    public void setGraduation(String graduation) {
        this.graduation = graduation;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", graduation="  + graduation + ", name=" + name + ", role=" + role
                + ", salary=" + salary + "]";
    }
    
    
}