package com.employeeDetails.service;

import com.employeeDetails.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface EmployeeService {

    List<Employee> getAllEmployees();
    Optional<Employee> getEmployeeById(Long id);
    Employee createEmployee(Employee employee);
    Employee updateEmployee(Long id, Employee employee);
    Employee patchEmployee(Long id, Employee employee);
    void deleteEmployee(Long id);
}
