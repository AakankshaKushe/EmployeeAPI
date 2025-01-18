package com.api.employeeAPI.dto;

public class EmployeeDto {
	private Long e_id;
	private String e_name;
	private String e_city;
	private String e_salary;

	public EmployeeDto(Long e_id, String e_name, String e_city, String e_salary) {
		super();
		this.e_id = e_id;
		this.e_name = e_name;
		this.e_city = e_city;
		this.e_salary = e_salary;
	}

	public EmployeeDto() {
		// TODO Auto-generated constructor stub
	}

	public Long getE_id() {
		return e_id;
	}

	public void setE_id(Long e_id) {
		this.e_id = e_id;
	}

	public String getE_name() {
		return e_name;
	}

	public void setE_name(String e_name) {
		this.e_name = e_name;
	}

	public String getE_city() {
		return e_city;
	}

	public void setE_city(String e_city) {
		this.e_city = e_city;
	}

	public String getE_salary() {
		return e_salary;
	}

	public void setE_salary(String e_salary) {
		this.e_salary = e_salary;
	}

}
