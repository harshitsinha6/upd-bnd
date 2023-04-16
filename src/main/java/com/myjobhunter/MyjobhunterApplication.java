package com.myjobhunter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyjobhunterApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyjobhunterApplication.class, args);
//		apt install docker.io
//		docker run -d -p 5432:5432 -e POSTGRES_USER=sinha -e POSTGRES_PASSWORD=sinha12345 postgres:latest
		
//		-- public.jobhunter definition
//
//		-- Drop table
//
//		-- DROP TABLE public.jobhunter;
//
//		CREATE TABLE public.jobhunter (
//			id varchar NOT NULL,
//			company_name varchar NOT NULL,
//			link varchar NOT NULL,
//			position varchar NOT NULL,
//			status varchar NULL,
//			skill_vis_check bool NULL,
//			job_type varchar NOT NULL,
//			company_logo varchar NOT NULL,
//			req_experiance varchar NULL,
//			req_skills varchar NULL
//		);
//		
		
//		"company_name": "de-shaw",
//        "position": "MTS",
//        "req_experience": "2-5 yrs",
//        "link": "www.infosys.com",
//        "company_logo": "https://freakydiodes.com/wp-content/uploads/2022/02/de-shaw-co.png",
//        "skill_vis_check": false,
//        "req_skills": "java, c, c++, python, UI, Backend",
//        "location": "noida",
//        "status": "open",
//        "job_type": "software"
	}

}
