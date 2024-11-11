package com.employeeDetails.service;

import com.employeeDetails.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import com.employeeDetails.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        if(employeeRepository.existsById(id)) {
            employee.setId(id);
            return employeeRepository.save(employee);
        } else {
            throw new RuntimeException("Employee not found");
        }
    }

    @Override
    public Employee patchEmployee(Long id, @org.jetbrains.annotations.NotNull Employee employee) {
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
        if (employee.getName() != null) existingEmployee.setName(employee.getName());
        if (employee.getRole() != null) existingEmployee.setRole(employee.getRole());
        if (employee.getSalary() > 0) existingEmployee.setSalary(employee.getSalary());
        return employeeRepository.save(existingEmployee);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }


}
