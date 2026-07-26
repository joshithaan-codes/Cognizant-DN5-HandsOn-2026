package com.cognizant._springresthandson.service;

import com.cognizant._springresthandson.dao.EmployeeDao;
import com.cognizant._springresthandson.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cognizant._springresthandson.exception.EmployeeNotFoundException;
import java.util.ArrayList;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Transactional
    public ArrayList<Employee> getAllEmployees() {
        return employeeDao.getAllEmployees();
    }

    public Employee getEmployee(int id) throws EmployeeNotFoundException {
        return employeeDao.getEmployee(id);
    }

    @Transactional
    public void updateEmployee(Employee employee)
            throws EmployeeNotFoundException {

        employeeDao.updateEmployee(employee);
    }

    public void deleteEmployee(int id) throws EmployeeNotFoundException {
        employeeDao.deleteEmployee(id);
    }

    public void addEmployee(Employee employee) {
        employeeDao.addEmployee(employee);
    }
}