package com.cognizant._springresthandson.dao;

import com.cognizant._springresthandson.model.Department;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class DepartmentDao {

    private static ArrayList<Department> DEPARTMENT_LIST;

    public DepartmentDao() {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("employee.xml");

        DEPARTMENT_LIST =
                (ArrayList<Department>) context.getBean("departmentList");

        context.close();
    }

    public ArrayList<Department> getAllDepartments() {
        return DEPARTMENT_LIST;
    }
}