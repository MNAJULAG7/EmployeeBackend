package com.example.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository er;
    public List<Employee> getAllDetails() {
     return er.findAll();
    }

//    public void addDetails(int id,String name, String position, int salary) {
//       Employee e = new Employee(id,name,position,salary);
//        er.save(e);
//    }

    public void deleteById(int id) {
        er.deleteById(id);
    }

    public List<Employee> detailsBasedOnSalary(int salary) {
       return er.detailsBasedOnSalary(salary);

    }

    @Transactional
    public void addDetailsById(int id,Employee e)
    {
        String name = e.getName();
        String position = e.getPosition();
        int salary = e.getSalary();
       er.addDetailsById(id,name,position,salary);
    }
    @Transactional
    public void updateByName(String name, Employee e) {
        int e_id = e.getE_id();
        String position = e.getPosition();
        int salary = e.getSalary();
        er.updateByName(name,e_id,position,salary);
    }

    public void addDetails(Employee e) {
        er.save(e);
    }
}
