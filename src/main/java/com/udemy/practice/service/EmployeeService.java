package com.udemy.practice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.udemy.practice.dao.EmployeeRepository;
import com.udemy.practice.dto.EmployeeProject;
import com.udemy.practice.entities.Employee;

public class EmployeeService {
	
	@Autowired
	EmployeeRepository empRepo;
	
	
	public Employee save(Employee employee) {
		return empRepo.save(employee);
	}


	public List<Employee> getAllEmployes() {
		return empRepo.findAll();
	}


	public List<EmployeeProject> employeeProjects() {
		return empRepo.employeeProjects();
	}


	public Employee findByEmployeeId(long theId) {
		// TODO Auto-generated method stub
		return empRepo.findByEmployeeId(theId);
	}


	public void delete(Employee theEmp) {
		empRepo.delete(theEmp);
		
	}

}
