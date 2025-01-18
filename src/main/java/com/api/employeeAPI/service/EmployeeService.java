package com.api.employeeAPI.service;

import java.util.List;

import com.api.employeeAPI.dto.EmployeeDto;

public interface EmployeeService {
	EmployeeDto createNewEmployee(EmployeeDto employeeDto);

	List<EmployeeDto> getAllEmployees();

	EmployeeDto getEmployeeById(Long e_id);

	EmployeeDto updateEmployee(Long e_id, EmployeeDto employeeDto);

	void deleteEmployeeById(Long e_id);

}
