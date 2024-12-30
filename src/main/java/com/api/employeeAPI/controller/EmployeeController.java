package com.api.employeeAPI.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.employeeAPI.model.Employee;
import com.api.employeeAPI.repository.EmployeeRepository;

@RestController
//@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	EmployeeRepository employeeRepository;

	@PostMapping("/employee")
	public String createNewEmployee(@RequestBody Employee employee) {
		employeeRepository.save(employee);
		return "Employee created successfully";

	}

	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		List<Employee> employees = employeeRepository.findAll();
		return employees;
	}

	@GetMapping("/employees/{e_id}")
	public Employee getEmployeeById(@PathVariable int e_id) {
		Employee employee = employeeRepository.findById(e_id).get();
		return employee;
	}

	@PutMapping("/employees/{e_id}")
	public String updateEmployee(@PathVariable int e_id, @RequestBody Employee employee) {
		Optional<Employee> emp = employeeRepository.findById(e_id);
		if (emp.isPresent()) {
			Employee existEmp = emp.get();
			existEmp.setE_name(employee.getE_name());
			existEmp.setE_city(employee.getE_city());
			existEmp.setE_salary(employee.getE_salary());
			employeeRepository.save(existEmp);
			return "Employee Details against id " + e_id + " updated";
		} else {
			return "Employee Details does not exist for id " + e_id;
		}
	}

	@DeleteMapping("/employees/{e_id}")
	public String deleteEmployeeById(@PathVariable int e_id) {
		employeeRepository.deleteById(e_id);
		return "Employee deleted successfully";
	}

}
