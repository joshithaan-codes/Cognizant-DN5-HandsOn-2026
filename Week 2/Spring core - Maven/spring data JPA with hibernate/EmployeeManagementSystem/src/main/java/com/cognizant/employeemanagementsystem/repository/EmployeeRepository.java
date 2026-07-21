package com.cognizant.employeemanagementsystem.repository;
import java.util.List;
import org.springframework.data.jpa.repository.Query;

import com.cognizant.employeemanagementsystem.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import com.cognizant.employeemanagementsystem.projection.EmployeeProjection;
import com.cognizant.employeemanagementsystem.projection.EmployeeDTO;
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByName(String name);

    List<Employee> findByEmail(String email);

    List<Employee> findByNameContaining(String keyword);

    @Query("SELECT e FROM Employee e WHERE e.email = ?1")
    List<Employee> getEmployeeByEmail(String email);

    @Query(name = "Employee.findByEmployeeName")
    List<Employee> findEmployeeByName(String name);

    List<EmployeeProjection> findBy();

    @Query("SELECT new com.cognizant.employeemanagementsystem.projection.EmployeeDTO(e.name, e.email) FROM Employee e")
    List<EmployeeDTO> getEmployeeDTOs();
}