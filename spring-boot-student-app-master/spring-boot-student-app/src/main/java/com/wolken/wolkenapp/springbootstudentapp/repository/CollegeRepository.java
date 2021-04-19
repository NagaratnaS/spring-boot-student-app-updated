package com.wolken.wolkenapp.springbootstudentapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wolken.wolkenapp.springbootstudentapp.entity.CollegeEntity;

@Repository
public interface CollegeRepository extends JpaRepository<CollegeEntity, Integer>{

	public CollegeEntity findByCollegeName(String collegeName);
	public List<CollegeEntity> findByCollegeCode(String collegeCode);
	
}
