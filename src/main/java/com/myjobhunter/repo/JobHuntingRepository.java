package com.myjobhunter.repo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.myjobhunter.entity.MyJobHunter;

@Repository
public interface JobHuntingRepository extends JpaRepository<MyJobHunter, String>, PagingAndSortingRepository<MyJobHunter, String> {
	List<MyJobHunter> findAllByCompanyName(String companyName, Pageable pageable);
	List<MyJobHunter> findAllByJobType(String jobType, Pageable pageable);
	Page<MyJobHunter> findAll(Pageable pageable);
	
}
