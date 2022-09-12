package com.example.SpringBootCrud.serviceimplimentation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringBootCrud.Exception.ResourceNotFoundException;
import com.example.SpringBootCrud.model.Employee;
import com.example.SpringBootCrud.repository.EmployeeRepositoryInterface;
import com.example.SpringBootCrud.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	 //@Autowired=if a class which is configured as a spring bean,has only one constructor,
	//the @Autowird annotation can be omitted and spring will use that constructor and 
	//inject all necessary dependencies
	
private EmployeeRepositoryInterface employeeRepository;
	@Override
	public Employee saveEmployee(Employee employee) {

		return employeeRepository.save(employee);
	}
	@Override
	public List<Employee> getAllEmployees() {
	
		return employeeRepository.findAll();
	}
	@Override
	public Employee getEmployeeById(int id) {

	Optional <Employee> employee=employeeRepository.findById(id)

;
	
	if(employee.isPresent()) {
		return employee.get();
		
	}
	else {
		throw new ResourceNotFoundException("Employee","Id",id);
	}
	}
	@Override
	public Employee updateEmployee(Employee employee, int id) {
		// we check whether employee with given id is exist in DB or not
		
		Employee existingEmployee=employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee","Id",id));
				existingEmployee.setFirstName(employee.getFirstName());
				existingEmployee.setLastName(employee.getLastName());
				existingEmployee.setAge(employee.getAge());
	// save existing employee to DB
				employeeRepository.save(existingEmployee);
				return existingEmployee;
	}
	@Override
	public void daleteEmployee(int id) {
		employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee","Id",id));
		employeeRepository.deleteById(id)
;
			
		}

	}