package com.cognizant._springresthandson.controller;

import com.cognizant._springresthandson.model.Employee;
import com.cognizant._springresthandson.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cognizant._springresthandson.exception.EmployeeNotFoundException;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.ArrayList;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public ArrayList<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PutMapping("/employees")
    public void updateEmployee(@RequestBody @Valid Employee employee)
            throws EmployeeNotFoundException {

        employeeService.updateEmployee(employee);
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable int id)
            throws EmployeeNotFoundException {

        employeeService.deleteEmployee(id);
    }

    @PostMapping("/employees")
    public void addEmployee(@RequestBody @Valid Employee employee) {
        employeeService.addEmployee(employee);
    }


    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id)
            throws EmployeeNotFoundException {

        return employeeService.getEmployee(id);
    }
}