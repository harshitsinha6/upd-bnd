package com.myjobhunter.controller;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myjobhunter.dto.FilteredDataDTO;
import com.myjobhunter.entity.MyJobHunter;
import com.myjobhunter.service.JobHunterService;

@CrossOrigin("*")
@RestController
@RequestMapping()
public class JobHunterController {
	
	@Autowired
	JobHunterService jobHunterService;
	
	@GetMapping("/hello-app")
	public String helloHunters() {
		return "Hello Hunters";
	}
	
	@GetMapping("/get-jobs/{pageNumber}/{pageSize}")
	public ResponseEntity<List<MyJobHunter>> getJobs(@PathVariable int pageNumber, @PathVariable int pageSize){
		return ResponseEntity.ok(jobHunterService.getJobs(pageNumber, pageSize));
	}
	
	@PostMapping("/add-jobs")
	public ResponseEntity<String> addJobs(@RequestBody MyJobHunter jobDetails){
		jobHunterService.add_job(jobDetails);
		return ResponseEntity.ok("inserted Successfully");
	}
	
	@PostMapping("/get-filtered-jobs/{pageNumber}/{pageSize}")
	public ResponseEntity<List<MyJobHunter>> getFilteredJobs(@PathVariable int pageNumber, @PathVariable int pageSize, @RequestBody FilteredDataDTO filteredDataDTO){
		return ResponseEntity.ok(jobHunterService.getFilteredJobs(filteredDataDTO, pageNumber, pageSize));
	}
	

}
