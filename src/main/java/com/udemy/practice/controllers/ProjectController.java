package com.udemy.practice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.udemy.practice.dao.EmployeeRepository;
import com.udemy.practice.dao.ProjectRepository;
import com.udemy.practice.entities.Employee;
import com.udemy.practice.entities.Project;

@Controller
@RequestMapping("/projects")
public class ProjectController {

	@Autowired
	private ProjectRepository proRepo;
	
	@Autowired
	private EmployeeRepository empRepo;

	@GetMapping
	public String employeeHome(Model model) {
		List<Project> project = proRepo.findAll();
		model.addAttribute("projectList", project);
		return "projects/list-projects";
	}

	@GetMapping("/new")
	public String displayProjectForm(Model model) {
		Project aProject = new Project();
		List<Employee> employees = empRepo.findAll();
		model.addAttribute("project", aProject);
		model.addAttribute("allEmployees",employees);
		return "projects/new-project";
	}

	@PostMapping("/save")
	public String createProject(Project project) {
		proRepo.save(project);
		return "redirect:/projects/new";

	}
}
