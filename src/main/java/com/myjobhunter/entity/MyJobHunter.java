package com.myjobhunter.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "jobhunter")
public class MyJobHunter {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	private String companyName;
	private String Link;
	private String position;
	private String status;
	private boolean skillVisCheck;
	private String companyLogo;
	private String jobType;
	private String reqExperience;
	private String reqSkills;
	private String location;
	
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getLink() {
		return Link;
	}
	public void setLink(String link) {
		Link = link;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public boolean isSkillVisCheck() {
		return skillVisCheck;
	}
	public void setSkillVisCheck(boolean skillVisCheck) {
		this.skillVisCheck = skillVisCheck;
	}
	public String getCompanyLogo() {
		return companyLogo;
	}
	public void setCompanyLogo(String companyLogo) {
		this.companyLogo = companyLogo;
	}
	public String getJobType() {
		return jobType;
	}
	public void setJobType(String jobType) {
		this.jobType = jobType;
	}
	public String getReqExperience() {
		return reqExperience;
	}
	public void setReqExperience(String reqExperience) {
		this.reqExperience = reqExperience;
	}
	public String getReqSkills() {
		return reqSkills;
	}
	public void setReqSkills(String reqSkills) {
		this.reqSkills = reqSkills;
	}
	@Override
	public String toString() {
		return "MyJobHunter [id=" + id + ", companyName=" + companyName + ", Link=" + Link + ", position=" + position
				+ ", status=" + status + ", skillVisCheck=" + skillVisCheck + ", companyLogo=" + companyLogo
				+ ", jobType=" + jobType + ", reqExperience=" + reqExperience + ", reqSkills=" + reqSkills
				+ ", location=" + location + "]";
	}
	
	
	
}
