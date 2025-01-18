package com.api.employeeAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.employeeAPI.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
