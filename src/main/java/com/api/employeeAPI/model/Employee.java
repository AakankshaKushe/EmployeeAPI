package com.api.employeeAPI.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int e_id;
	@Column(name = "e_name")
	private String e_name;
	@Column(name = "e_city")
	private String e_city;
	@Column(name = "e_salary")
	private String e_salary;

	public Employee(int e_id, String e_name, String e_city, String e_salary) {
		super();
		this.e_id = e_id;
		this.e_name = e_name;
		this.e_city = e_city;
		this.e_salary = e_salary;
	}

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public int getE_id() {
		return e_id;
	}

	public void setE_id(int e_id) {
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

	@Override
	public String toString() {
		return "Employee [e_id=" + e_id + ", e_name=" + e_name + ", e_city=" + e_city + ", e_salary=" + e_salary + "]";
	}

}
