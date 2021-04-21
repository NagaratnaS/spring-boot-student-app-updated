package com.wolken.wolkenapp.springbootstudentapp.service;

import java.util.List;

import com.wolken.wolkenapp.springbootstudentapp.dto.StudentDTO;
import com.wolken.wolkenapp.springbootstudentapp.entity.StudentEntity;


public interface StudentService {
	public String add(StudentDTO dto) ;
	public List<StudentEntity> getAll();
	public String updateByName(StudentEntity entity);
	public String deleteByName(String studentName);
	public List<StudentEntity> getAllByCollegeName(String collegeCode);
	public int validateAndSaveAll(List<StudentEntity> studententityList);
	public boolean validateAndUpdateStudentSemesterByStudentAddress(int studentSemester, String studentAddress);
	public StudentEntity validateAndUpdateStudentNameByStudentAddress(String studentName, String studentAddress);
	public List<StudentEntity> getAllByStudentSemester(int studentSemester);
	public StudentEntity updateStudentSemesterAndStudentAddressByStudentName(int studentSemester, String studentAddress, String studentName);
}
