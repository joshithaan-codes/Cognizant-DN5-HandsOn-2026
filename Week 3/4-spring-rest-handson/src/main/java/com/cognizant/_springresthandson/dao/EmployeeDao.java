package com.cognizant._springresthandson.dao;

import com.cognizant._springresthandson.model.Employee;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
import com.cognizant._springresthandson.exception.EmployeeNotFoundException;
import com.cognizant._springresthandson.exception.EmployeeNotFoundException;

import java.util.ArrayList;

@Repository
public class EmployeeDao {

    private static ArrayList<Employee> EMPLOYEE_LIST;

    public EmployeeDao() {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("employee.xml");

        EMPLOYEE_LIST =
                (ArrayList<Employee>) context.getBean("employeeList");

        context.close();
    }

    public ArrayList<Employee> getAllEmployees() {
        return EMPLOYEE_LIST;
    }

    public void updateEmployee(Employee employee)
            throws EmployeeNotFoundException {

        Employee existingEmployee = EMPLOYEE_LIST.stream()
                .filter(e -> e.getId() == employee.getId())
                .findFirst()
                .orElseThrow(() ->
                        new EmployeeNotFoundException(
                                "Employee with ID " + employee.getId() + " not found"));

        int index = EMPLOYEE_LIST.indexOf(existingEmployee);

        EMPLOYEE_LIST.set(index, employee);
    }

    public void deleteEmployee(int id) throws EmployeeNotFoundException {

        Employee employeeToDelete = null;

        for (Employee employee : EMPLOYEE_LIST) {
            if (employee.getId() == id) {
                employeeToDelete = employee;
                break;
            }
        }

        if (employeeToDelete == null) {
            throw new EmployeeNotFoundException(
                    "Employee with ID " + id + " not found");
        }

        EMPLOYEE_LIST.remove(employeeToDelete);
    }

    public void addEmployee(Employee employee) {
        EMPLOYEE_LIST.add(employee);
    }

    public Employee getEmployee(int id) throws EmployeeNotFoundException {

        return EMPLOYEE_LIST.stream()
                .filter(employee -> employee.getId() == id)
                .findFirst()
                .orElseThrow(() ->
                        new EmployeeNotFoundException(
                                "Employee with ID " + id + " not found"));
    }

}