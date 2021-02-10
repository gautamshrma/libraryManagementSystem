package com.udemy.practice.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.udemy.practice.dao.ChartData;
import com.udemy.practice.dao.EmployeeRepository;
import com.udemy.practice.dao.ProjectRepository;
import com.udemy.practice.dto.EmployeeProject;
import com.udemy.practice.entities.Project;

@Controller
public class HomeController {

	
	  @Value("${version}") 
	  private String version;
	  
	 
	@ModelAttribute("title")
	public String title() {
		return "Project Management";
	}

	@Autowired
	private ProjectRepository proRepo;

	@Autowired
	private EmployeeRepository empRepo;

	@GetMapping("/")
	public String displayHome(Model model) throws JsonProcessingException {
		Map<String, Object> map = new HashMap<>();

		List<Project> projects = proRepo.findAll();
		List<ChartData> projectData = proRepo.getProjectStatus();

		// to convert java object into json to use in javascript
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(projectData);

		model.addAttribute("projectStatusCnt", jsonString);

		 model.addAttribute("versionNumber", version);

		List<EmployeeProject> employeesProjectCnt = empRepo.employeeProjects();
		model.addAttribute("projectList", projects);
		model.addAttribute("employeeListProjectsCnt", employeesProjectCnt);
		return "main/home";
	}

}
