package com.api.employeeAPI.mapper;

import com.api.employeeAPI.dto.EmployeeDto;
import com.api.employeeAPI.model.Employee;

public class EmployeeMapper {
	public static EmployeeDto mapToEmployeeDto(Employee employee) {
		return new EmployeeDto(employee.getE_id(), employee.getE_name(), employee.getE_city(), employee.getE_salary());
	}

	public static Employee mapToEmployee(EmployeeDto employeeDto) {
		return new Employee(employeeDto.getE_id(), employeeDto.getE_name(), employeeDto.getE_city(),
				employeeDto.getE_salary());
	}

}
