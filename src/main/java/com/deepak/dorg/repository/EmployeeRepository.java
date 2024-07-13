package com.deepak.dorg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.deepak.dorg.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
