package com.api.employeeAPI.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.employeeAPI.dto.EmployeeDto;
import com.api.employeeAPI.service.EmployeeService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	private EmployeeService employeeService;

	@PostMapping
	public ResponseEntity<EmployeeDto> createNewEmployee(@RequestBody EmployeeDto employeeDto) {
		EmployeeDto savedEmployee = employeeService.createNewEmployee(employeeDto);
		return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);

	}

	@GetMapping
	public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
		List<EmployeeDto> allEmployees = employeeService.getAllEmployees();
		// System.out.println("saved user" + allEmployees);
		return new ResponseEntity<>(allEmployees, HttpStatus.OK);

	}

	@GetMapping("/{e_id}")
	public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long e_id) {
		EmployeeDto employeeById = employeeService.getEmployeeById(e_id);
		return new ResponseEntity<>(employeeById, HttpStatus.OK);

	}

	@PutMapping("/{e_id}")
	public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable Long e_id,
			@RequestBody EmployeeDto updatedEmployee) {
		EmployeeDto employee = employeeService.updateEmployee(e_id, updatedEmployee);
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}

	@DeleteMapping("/{e_id}")
	public ResponseEntity<String> deleteEmployeeById(@PathVariable Long e_id) {
		employeeService.deleteEmployeeById(e_id);
		return new ResponseEntity<>("Employee record deleted successfully", HttpStatus.OK);
	}

}
