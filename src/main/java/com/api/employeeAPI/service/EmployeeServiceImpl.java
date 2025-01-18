package com.api.employeeAPI.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.employeeAPI.dto.EmployeeDto;
import com.api.employeeAPI.exception.EmployeeException;
import com.api.employeeAPI.mapper.EmployeeMapper;
import com.api.employeeAPI.model.Employee;
import com.api.employeeAPI.repository.EmployeeRepository;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	private EmployeeRepository employeeRepository;

	public EmployeeDto createNewEmployee(EmployeeDto employeeDto) {
		Employee newEmployee = EmployeeMapper.mapToEmployee(employeeDto);
		Employee savedEmployee = employeeRepository.save(newEmployee);
		return EmployeeMapper.mapToEmployeeDto(savedEmployee);
	}

	public List<EmployeeDto> getAllEmployees() {
		List<Employee> allEmployees = employeeRepository.findAll();
		return allEmployees.stream().map((e) -> EmployeeMapper.mapToEmployeeDto(e)).collect(Collectors.toList());
	}

	public EmployeeDto getEmployeeById(Long e_id) {
		// Employee employee = employeeRepository.findById(e_id)
		// .orElseThrow(() -> new EmployeeException("Employee Id requested doesn't
		// exist" + e_id));
		// return EmployeeMapper.mapToEmployeeDto(employee);
		Employee emp = employeeRepository.save(employee);
		return employeeRepository.findById(emp.getE_id());
	}

	public EmployeeDto updateEmployee(Long e_id, EmployeeDto employeeDto) {
		Employee employee = employeeRepository.findById(e_id)
				.orElseThrow(() -> new EmployeeException("Employee Id requested doesn't exist" + e_id));
		employee.setE_name(employeeDto.getE_name());
		employee.setE_city(employeeDto.getE_city());
		employee.setE_salary(employeeDto.getE_salary());
		Employee updatedEmployee = employeeRepository.save(employee);
		return EmployeeMapper.mapToEmployeeDto(updatedEmployee);
	}

	public void deleteEmployeeById(Long e_id) {
		Employee employee = employeeRepository.findById(e_id)
				.orElseThrow(() -> new EmployeeException("Employee Id requested doesn't exist" + e_id));
		employeeRepository.deleteById(e_id);
	}

}
