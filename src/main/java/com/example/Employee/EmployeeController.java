package com.example.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class EmployeeController {
    @Autowired
    EmployeeService es;

    @GetMapping("details")
    public List<Employee> details()
    {
        return es.getAllDetails();
    }
//    @PostMapping("add")
//    public void addDetails(@RequestParam("e_id") int id,@RequestParam("name")  String name,
//                           @RequestParam("position") String position,
//                           @RequestParam("salary") int salary)
//    {
//       es.addDetails(id,name,position,salary);
//    }
    @PostMapping("add")
    public void addDetails(@RequestBody Employee e)
    {
        es.addDetails(e);
//        return "added sucessfully";
    }

    @DeleteMapping("delete")
    public void deleteById(@RequestParam("e_id") int id){
        es.deleteById(id);
//        return "deleted successfully";
    }

    @PutMapping("details/id")
    public void addDetailsById(@RequestParam("e_id") int id ,@RequestBody Employee e)
    {
        es.addDetailsById(id,e);
//        return "added successfully";
    }
    @GetMapping("details/salary")
    public List<Employee> detailsBasedOnSalary(@RequestParam("salary") int salary)
    {
        return es.detailsBasedOnSalary(salary);
    }


}
