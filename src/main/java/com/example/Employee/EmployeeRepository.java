package com.example.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    @Query(value="select * from employee where salary > :salary", nativeQuery = true)
    List<Employee> detailsBasedOnSalary(@Param("salary") int salary);

    @Modifying
    @Query(value="update employee E set  E.e_id=:e_id , E.position =:position, E.salary=:salary where E.name=:name", nativeQuery = true)
    void updateByName(@Param("name") String name, @Param("e_id") int e_id, @Param("position") String position, @Param("salary") int salary);

    @Modifying
    @Query(value="update employee E set  E.name=:name, E.position =:position, E.salary=:salary where E.e_id=:e_id", nativeQuery = true)
    void addDetailsById(@Param("e_id") int e_id, @Param("name") String name, @Param("position") String position, @Param("salary") int salary);
}
