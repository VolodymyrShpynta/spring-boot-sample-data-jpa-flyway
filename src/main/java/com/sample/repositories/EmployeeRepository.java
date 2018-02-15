package com.sample.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.sample.entity.Employee;

import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    List<Employee> findByFirstName(String firstName);

    @Query("SELECT e FROM Employee e LEFT JOIN FETCH e.address")
    List<Employee> findAllEmployees();
}
