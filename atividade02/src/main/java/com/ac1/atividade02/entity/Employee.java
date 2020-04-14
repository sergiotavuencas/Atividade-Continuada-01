package com.ac1.atividade02.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Employee
 */
@Entity
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name", nullable = false, length = 80)
    private String name;

    @Column(name = "role", nullable = false, length = 40)
    private String role;

    @Column(name = "salary", nullable = false, precision = 10, scale = 2)
    private double salary;

    //@Column(name = "admission", nullable = true, length = 80)
    private Date admission;

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

    public Date getAdmission() {
        return admission;
    }

    public void setAdmission(Date admission) {
        this.admission = admission;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", admission="  + admission + ", name=" + name + ", role=" + role
                + ", salary=" + salary + "]";
    }
    
    
}