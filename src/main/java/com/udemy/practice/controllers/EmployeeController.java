package com.udemy.practice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.udemy.practice.dao.EmployeeRepository;
import com.udemy.practice.entities.Employee;
import com.udemy.practice.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository empRepo;
	
	/*
	 * @Autowired private EmployeeService employeeService ;
	 */
	
	
	
	@GetMapping
	public String employeeHome(Model model) {
		List<Employee> emp = empRepo.findAll();
	model.addAttribute("employeeList", emp);
	return "employees/list-employees";
	}
	@GetMapping("/new")
	public String displayEmployeeForm(Model model) {
		
		Employee anEmployee = new Employee();
		model.addAttribute("employee",anEmployee);
		
		return "employees/new-employee";
		
	}
	@GetMapping("/update/{id}")
	public String updateForm(@PathVariable int id,Model model) {
		Employee updateEmp = empRepo.findByEmployeeId(id);
		model.addAttribute("updateEmp",updateEmp);
		return "employees/update-employee";
	}
	@GetMapping("delete/{id}")
	public String deleteForm(@PathVariable long id) {
		empRepo.deleteById(id);
		return "redirect:/employees";
	}
	
	
	
	@PutMapping("/save")
	public String createorUpdateEmployee(Employee emp, Model model) {
		empRepo.save(emp);
		return "redirect:/employees/new";
		
	}

}
