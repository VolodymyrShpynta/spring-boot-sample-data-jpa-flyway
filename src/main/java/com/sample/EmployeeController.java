package com.sample;

import com.sample.entity.Employee;
import com.sample.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping(value = "/rest")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    @RequestMapping(value = "/employee", method = GET)
    public Iterable<Employee> getAll() {
        return employeeRepository.findAllEmployees();
    }
}
