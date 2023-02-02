package com.myjobhunter.dto;

import java.util.Arrays;

public class FilteredDataDTO {
	
	private String companyName;
	private boolean iscompanyNamePresent;
	
	private String[] status;
	private boolean iscompanyStatusPresent;
	
	private String[] jobType;
	private boolean iscompanyJobTypePresent;
	
	private String[] location;
	private boolean iscompanyLocationPresent;
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public boolean isIscompanyNamePresent() {
		return iscompanyNamePresent;
	}
	public void setIscompanyNamePresent(boolean iscompanyNamePresent) {
		this.iscompanyNamePresent = iscompanyNamePresent;
	}
	public String[] getStatus() {
		return status;
	}
	public void setStatus(String[] status) {
		this.status = status;
	}
	public boolean isIscompanyStatusPresent() {
		return iscompanyStatusPresent;
	}
	public void setIscompanyStatusPresent(boolean iscompanyStatusPresent) {
		this.iscompanyStatusPresent = iscompanyStatusPresent;
	}
	public String[] getJobType() {
		return jobType;
	}
	public void setJobType(String[] jobType) {
		this.jobType = jobType;
	}
	public boolean isIscompanyJobTypePresent() {
		return iscompanyJobTypePresent;
	}
	public void setIscompanyJobTypePresent(boolean iscompanyJobTypePresent) {
		this.iscompanyJobTypePresent = iscompanyJobTypePresent;
	}
	public String[] getLocation() {
		return location;
	}
	public void setLocation(String[] location) {
		this.location = location;
	}
	public boolean isIscompanyLocationPresent() {
		return iscompanyLocationPresent;
	}
	public void setIscompanyLocationPresent(boolean iscompanyLocationPresent) {
		this.iscompanyLocationPresent = iscompanyLocationPresent;
	}
	@Override
	public String toString() {
		return "FilteredDataDTO [companyName=" + companyName + ", iscompanyNamePresent=" + iscompanyNamePresent
				+ ", status=" + Arrays.toString(status) + ", iscompanyStatusPresent=" + iscompanyStatusPresent
				+ ", jobType=" + Arrays.toString(jobType) + ", iscompanyJobTypePresent=" + iscompanyJobTypePresent
				+ ", location=" + Arrays.toString(location) + ", iscompanyLocationPresent=" + iscompanyLocationPresent
				+ "]";
	}
	
	
		
	

}
