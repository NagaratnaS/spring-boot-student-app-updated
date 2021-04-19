package com.wolken.wolkenapp.springbootstudentapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wolken.wolkenapp.springbootstudentapp.dto.StudentDTO;
import com.wolken.wolkenapp.springbootstudentapp.entity.CollegeEntity;
import com.wolken.wolkenapp.springbootstudentapp.entity.StudentEntity;
import com.wolken.wolkenapp.springbootstudentapp.repository.CollegeRepository;
import com.wolken.wolkenapp.springbootstudentapp.repository.StudentRepository;

@Service
@Transactional
public class StudentServiceImpl implements StudentService{

	@Autowired
	StudentRepository studentrepository;
	
	@Autowired
	CollegeRepository collegerepository;
	
	@Autowired
	CollegeEntity collegeentity;
	
	@Autowired
	StudentEntity studententity;
	
	
	@Override
	public String add(StudentDTO dto) {
		// TODO Auto-generated method stub
		if (dto!=null) {
			if (!dto.getStudentName().equals(null) && !dto.getStudentAddress().equals(null) && dto.getStudentSemester() > 0) {
				collegeentity = collegerepository.findByCollegeName(dto.getCollegeName());
				studententity = new StudentEntity();
				studententity.setStudentAddress(dto.getStudentAddress());
				studententity.setStudentName(dto.getStudentName());
				studententity.setStudentSemester(dto.getStudentSemester());
				studententity.setCollegeentity(collegeentity);
				studentrepository.save(studententity);
				return "Data added successfulluy!!";
			}
		}
		return "Some error occurred!!";	
	}
	@Override
	public List<StudentEntity> getAll() {
		// TODO Auto-generated method stub
		return studentrepository.findAll();
	}
	
	
	@Override
	public String updateByName(StudentEntity entity) {
		// TODO Auto-generated method stub
		
		if (entity!=null) {
			if (!entity.getStudentName().equals(null) && !entity.getStudentAddress().equals(null) && entity.getStudentSemester() > 0) {
				StudentEntity updatingEntity = studentrepository.findByStudentName(entity.getStudentName());
				updatingEntity.setStudentAddress(entity.getStudentAddress());
				updatingEntity.setStudentSemester(entity.getStudentSemester());
				studentrepository.save(updatingEntity);
				return "Data updated successfulluy!!";
			}
		}
		return "Some error occurred!!";	
		
	}
	@Override
	public String deleteByName(String studentName) {
		// TODO Auto-generated method stub
		
		if (!studentName.equals(null)) {
			studentrepository.deleteByStudentName(studentName);
			return "Deleted successfully!";
		}
		return "Some error occurred!!";
	}
	@Override
	public List<StudentEntity> getAllByCollegeName(String collegeCode) {
		// TODO Auto-generated method stub
		List<CollegeEntity> collegeList = collegerepository.findByCollegeCode(collegeCode);
		List<StudentEntity> studentList = new ArrayList<StudentEntity>();
		for(CollegeEntity collegeentity: collegeList) {
			int id = collegeentity.getId();
			studentList.add(studentrepository.findById(id));
		}
		return studentList;
	}
	
	

}
