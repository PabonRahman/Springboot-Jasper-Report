package com.example.springboot_jasper_report.repository;

import com.example.springboot_jasper_report.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
