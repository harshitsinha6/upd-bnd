package com.myjobhunter.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.myjobhunter.dto.FilteredDataDTO;
import com.myjobhunter.entity.MyJobHunter;
import com.myjobhunter.repo.JobHuntingRepository;

@Service
public class JobHunterService {
	
	@Autowired
	JobHuntingRepository jobHuntingRepository;
	
	public List<MyJobHunter> getJobs(int pageNumber, int pageSize){
		Pageable pages = PageRequest.of(pageNumber, pageSize, Sort.by(Sort.Direction.DESC, "id"));
		List<MyJobHunter> retList = new ArrayList<>();
//		return Collections.reverse(jobHuntingRepository.findAll());
		for(MyJobHunter job: jobHuntingRepository.findAll()) {
			retList.add(0, job);
		}
		return retList;
	}
	
	public void add_job(MyJobHunter myJobHunter) {
		jobHuntingRepository.save(myJobHunter);
	}
	
	public void remove_job(String id) {
		jobHuntingRepository.deleteById(id);
	}
	
	public List<MyJobHunter> getByCompanyName(String companyName){
		Pageable pages = PageRequest.of(0, 3, Sort.by(Sort.Direction.DESC, "id"));
		return jobHuntingRepository.findAllByCompanyName(companyName, pages);
	}
	
	public List<MyJobHunter> getByJobType(String jobType){
		Pageable pages = PageRequest.of(0, 3, Sort.by(Sort.Direction.DESC, "id"));
		return jobHuntingRepository.findAllByJobType(jobType, pages);
	}
	
	@SuppressWarnings("unchecked")
	public List<MyJobHunter> getFilteredJobs(FilteredDataDTO filteredDataDTO, int pageNumber, int pageSize){
		Pageable pages = PageRequest.of(pageNumber, pageSize, Sort.by(Sort.Direction.DESC, "id"));
		List<MyJobHunter> jobDetailsList = (List<MyJobHunter>) jobHuntingRepository.findAll();
		
		System.out.println("=================================" + filteredDataDTO.toString());
		
		if(filteredDataDTO.isIscompanyNamePresent() && filteredDataDTO.isIscompanyJobTypePresent() && filteredDataDTO.isIscompanyStatusPresent() && filteredDataDTO.isIscompanyLocationPresent())
			return getDetailsByNameStatusLocationType(jobDetailsList, filteredDataDTO.getCompanyName(), filteredDataDTO.getStatus(), filteredDataDTO.getLocation(), filteredDataDTO.getJobType());
		
		else if(filteredDataDTO.isIscompanyNamePresent() && filteredDataDTO.isIscompanyStatusPresent() && filteredDataDTO.isIscompanyLocationPresent())
			return getDetailsByNameStatusLocation(jobDetailsList, filteredDataDTO.getCompanyName(), filteredDataDTO.getStatus(), filteredDataDTO.getLocation());
		
		else if(filteredDataDTO.isIscompanyNamePresent() && filteredDataDTO.isIscompanyJobTypePresent() && filteredDataDTO.isIscompanyStatusPresent())
			return getDetailsByNameStatusType(jobDetailsList, filteredDataDTO.getCompanyName(), filteredDataDTO.getStatus(), filteredDataDTO.getJobType());
			
		else if(filteredDataDTO.isIscompanyNamePresent() && filteredDataDTO.isIscompanyJobTypePresent() &&  filteredDataDTO.isIscompanyLocationPresent())
			return getDetailsByNameLocationType(jobDetailsList, filteredDataDTO.getCompanyName(), filteredDataDTO.getLocation(), filteredDataDTO.getJobType());
			
		else if(filteredDataDTO.isIscompanyJobTypePresent() && filteredDataDTO.isIscompanyStatusPresent() && filteredDataDTO.isIscompanyLocationPresent())
			return getDetailsByStatusLocationType(jobDetailsList, filteredDataDTO.getStatus(), filteredDataDTO.getLocation(), filteredDataDTO.getJobType());
		
		else if(filteredDataDTO.isIscompanyNamePresent() && filteredDataDTO.isIscompanyStatusPresent())
			return getDetailsByNameStatus(jobDetailsList, filteredDataDTO.getCompanyName(), filteredDataDTO.getStatus());
		
		else if(filteredDataDTO.isIscompanyJobTypePresent() && filteredDataDTO.isIscompanyLocationPresent())
			return getDetailsByLocationType(jobDetailsList, filteredDataDTO.getLocation(), filteredDataDTO.getJobType());
		
		else if(filteredDataDTO.isIscompanyNamePresent() && filteredDataDTO.isIscompanyJobTypePresent())
			return getDetailsByNameType(jobDetailsList, filteredDataDTO.getCompanyName(), filteredDataDTO.getJobType());
		
		else if(filteredDataDTO.isIscompanyNamePresent() && filteredDataDTO.isIscompanyLocationPresent())
			return getDetailsByNameLocation(jobDetailsList, filteredDataDTO.getCompanyName(), filteredDataDTO.getLocation());
		
		else if(filteredDataDTO.isIscompanyJobTypePresent() && filteredDataDTO.isIscompanyStatusPresent())
			return getDetailsByStatusType(jobDetailsList, filteredDataDTO.getStatus(), filteredDataDTO.getJobType());
		
		else if(filteredDataDTO.isIscompanyStatusPresent() && filteredDataDTO.isIscompanyLocationPresent())
			return getDetailsByStatusLocation(jobDetailsList, filteredDataDTO.getStatus(), filteredDataDTO.getLocation());
		
		else if(filteredDataDTO.isIscompanyNamePresent())
			return getDetailsByName(jobDetailsList, filteredDataDTO.getCompanyName());
		
		else if(filteredDataDTO.isIscompanyStatusPresent())
			return getDetailsByStatus(jobDetailsList, filteredDataDTO.getStatus());
		
		else if(filteredDataDTO.isIscompanyLocationPresent())
			return getDetailsByLocation(jobDetailsList, filteredDataDTO.getLocation());
		
		else if(filteredDataDTO.isIscompanyJobTypePresent())
			return getDetailsByType(jobDetailsList, filteredDataDTO.getJobType());
			
		System.out.println("+++++++++++++++++++++++++++++++++");
		return jobDetailsList;
		
	}
	
	public List<MyJobHunter> getDetailsByNameStatusLocationType(List<MyJobHunter> jobDetailsList, String name, String[] status, String[] location, String[] jobType){
		List<MyJobHunter> detailsList = new ArrayList<MyJobHunter>();
		for(MyJobHunter details: jobDetailsList) {
			if(details.getCompanyName().equals(name) && itemInList(status, details.getStatus()) && itemInList(jobType, details.getJobType())
					&& itemInList(location, details.getLocation()))
				detailsList.add(details);
		}
		return detailsList;
	}
	
	
	public List<MyJobHunter> getDetailsByNameStatusLocation(List<MyJobHunter> jobDetailsList, String name, String[] status, String[] location){
		List<MyJobHunter> detailsList = new ArrayList<MyJobHunter>();
		for(MyJobHunter details: jobDetailsList) {
			if(details.getCompanyName().equals(name) && itemInList(status, details.getStatus()) && itemInList(location, details.getLocation()))
				detailsList.add(details);
		}
		return detailsList;
	}
	
	public List<MyJobHunter> getDetailsByNameStatusType(List<MyJobHunter> jobDetailsList, String name, String[] status, String[] jobType){
		List<MyJobHunter> detailsList = new ArrayList<MyJobHunter>();
		for(MyJobHunter details: jobDetailsList) {
			if(details.getCompanyName().equals(name) && itemInList(status, details.getStatus()) && itemInList(jobType, details.getJobType()))
				detailsList.add(details);
		}
		return detailsList;
	}
	
	public List<MyJobHunter> getDetailsByNameLocationType(List<MyJobHunter> jobDetailsList, String name, String[] location, String[] jobType){
		List<MyJobHunter> detailsList = new ArrayList<MyJobHunter>();
		for(MyJobHunter details: jobDetailsList) {
			if(details.getCompanyName().equals(name) && itemInList(jobType, details.getJobType()) && itemInList(location, details.getLocation()))
				detailsList.add(details);
		}
		return detailsList;
	}

	public List<MyJobHunter> getDetailsByStatusLocationType(List<MyJobHunter> jobDetailsList, String[] status, String[] location, String[] jobType){
		List<MyJobHunter> detailsList = new ArrayList<MyJobHunter>();
		for(MyJobHunter details: jobDetailsList) {
			if(itemInList(status, details.getStatus()) && itemInList(jobType, details.getJobType()) && itemInList(location, details.getLocation()))
				detailsList.add(details);
		}
		return detailsList;
	}

	public List<MyJobHunter> getDetailsByNameStatus(List<MyJobHunter> jobDetailsList, String name, String[] status){
		List<MyJobHunter> detailsList = new ArrayList<MyJobHunter>();
		for(MyJobHunter details: jobDetailsList) {
			if(details.getCompanyName().equals(name) && itemInList(status, details.getStatus()))
				detailsList.add(details);
		}
		return detailsList;
	}

	public List<MyJobHunter> getDetailsByLocationType(List<MyJobHunter> jobDetailsList, String[] location, String[] jobType){
		List<MyJobHunter> detailsList = new ArrayList<MyJobHunter>();
		for(MyJobHunter details: jobDetailsList) {
			if(itemInList(jobType, details.getJobType()) && itemInList(location, details.getLocation()))
				detailsList.add(details);
		}
		return detailsList;
	}

	public List<MyJobHunter> getDetailsByNameType(List<MyJobHunter> jobDetailsList, String name, String[] jobType){
		List<MyJobHunter> detailsList = new ArrayList<MyJobHunter>();
		for(MyJobHunter details: jobDetailsList) {
			if(details.getCompanyName().equals(name) && itemInList(jobType, details.getJobType()))
				detailsList.add(details);
		}
		return detailsList;
	}
	
	public List<MyJobHunter> getDetailsByNameLocation(List<MyJobHunter> jobDetailsList, String name, String[] location){
		List<MyJobHunter> detailsList = new ArrayList<MyJobHunter>();
		for(MyJobHunter details: jobDetailsList) {
			if(details.getCompanyName().equals(name) && itemInList(location, details.getLocation()))
				detailsList.add(details);
		}
		return detailsList;
	}

	public List<MyJobHunter> getDetailsByStatusType(List<MyJobHunter> jobDetailsList, String[] status, String[] jobType){
		List<MyJobHunter> detailsList = new ArrayList<MyJobHunter>();
		for(MyJobHunter details: jobDetailsList) {
			if(itemInList(status, details.getStatus()) && itemInList(jobType, details.getJobType()))
				detailsList.add(details);
		}
		return detailsList;
	}

	public List<MyJobHunter> getDetailsByStatusLocation(List<MyJobHunter> jobDetailsList, String[] status, String[] location){
		List<MyJobHunter> detailsList = new ArrayList<MyJobHunter>();
		for(MyJobHunter details: jobDetailsList) {
			if(itemInList(status, details.getStatus()) && itemInList(location, details.getLocation()))
				detailsList.add(details);
		}
		return detailsList;
	}

	public List<MyJobHunter> getDetailsByName(List<MyJobHunter> jobDetailsList, String name){
		List<MyJobHunter> detailsList = new ArrayList<MyJobHunter>();
		for(MyJobHunter details: jobDetailsList) {
//			System.out.println(details.toString());
			if(details.getCompanyName().equals(name))
				detailsList.add(details);
		}
		return detailsList;
	}

	public List<MyJobHunter> getDetailsByStatus(List<MyJobHunter> jobDetailsList, String[] status){
		List<MyJobHunter> detailsList = new ArrayList<MyJobHunter>();
		for(MyJobHunter details: jobDetailsList) {
			if(itemInList(status, details.getStatus()))
				detailsList.add(details);
		}
		return detailsList;
	}

	public List<MyJobHunter> getDetailsByLocation(List<MyJobHunter> jobDetailsList, String[] location){
		List<MyJobHunter> detailsList = new ArrayList<MyJobHunter>();
		for(MyJobHunter details: jobDetailsList) {
			if(itemInList(location, details.getLocation()))
				detailsList.add(details);
		}
		return detailsList;
	}

	public List<MyJobHunter> getDetailsByType(List<MyJobHunter> jobDetailsList, String[] jobType){
		List<MyJobHunter> detailsList = new ArrayList<MyJobHunter>();
		for(MyJobHunter details: jobDetailsList) {
			if(itemInList(jobType, details.getJobType()))
				detailsList.add(details);
		}
		return detailsList;
	}
	
	public boolean itemInList(String[] list, String item) {
		for(String s: list) {
			if(s != null && s.equals(item))
				return true;
		}
		return false;
	}
	

}
