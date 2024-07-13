package com.deepak.dorg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.deepak.dorg.model.Employee;
import com.deepak.dorg.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	
    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
    	System.out.println("Entered");
        return employeeService.getAllEmployees();
    }
}