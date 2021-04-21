package com.wolken.wolkenapp.springbootstudentapp.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wolken.wolkenapp.springbootstudentapp.entity.StudentEntity;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Integer>{

	@Query(nativeQuery = true, value = "select se.* from student_spring_table st inner join college_spring_table ct pe on st.id=ct.id")
	public void deleteByStudentName(String studentName);
	public StudentEntity findByStudentName(String studentName);
	public StudentEntity findById(int id);
	public StudentEntity findByStudentAddress(String studentAddress);
	public List<StudentEntity> findByStudentSemester(int studentSemester);
}
