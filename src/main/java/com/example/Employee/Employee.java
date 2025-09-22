package com.example.Employee;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import javax.management.ConstructorParameters;

@Entity
@Data
public class Employee {
    @Id
    private int e_id;
    private String name;
    private String position;
    private int salary;

    public Employee(String name, String position, int salary) {

        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public Employee()
    {

    }

    public Employee(int e_id, String name, String position, int salary) {
        this.e_id = e_id;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }
}
