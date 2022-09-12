package com.example.SpringBootCrud.service;

import java.util.List;

import com.example.SpringBootCrud.model.Employee;

public interface EmployeeService {
	
	Employee saveEmployee(Employee employee);
	
	List<Employee> getAllEmployees();
	Employee getEmployeeById(int id);
	Employee updateEmployee(Employee employee,int id);
	void daleteEmployee(int id);
	
}