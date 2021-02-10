package com.udemy.practice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udemy.practice.dao.ChartData;
import com.udemy.practice.dao.ProjectRepository;
import com.udemy.practice.entities.Project;

@Service
public class ProjectService {
	
	@Autowired
	private ProjectRepository proRepo;
	
	public Project save(Project project) {
		return proRepo.save(project);
	}


	public List<Project> getAll() {
		return proRepo.findAll();
	}
	
	public List<ChartData> getProjectStatus(){
		return proRepo.getProjectStatus();
	}
	
	
	/*
	 * public List<TimeChartData> getTimeData(){ return proRepo.getTimeData(); }
	 */
	

}
