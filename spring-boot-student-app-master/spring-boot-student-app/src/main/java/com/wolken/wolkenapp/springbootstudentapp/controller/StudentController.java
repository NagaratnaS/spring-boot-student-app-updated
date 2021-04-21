package com.wolken.wolkenapp.springbootstudentapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wolken.wolkenapp.springbootstudentapp.dto.StudentDTO;
import com.wolken.wolkenapp.springbootstudentapp.entity.StudentEntity;
import com.wolken.wolkenapp.springbootstudentapp.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentController {
	
	@Autowired
	StudentService service;

	@GetMapping("/index")
	public String index() {
		return "Hello world!";
	}
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody StudentDTO dto) {
		String message = service.add(dto);
		if (!message.equals(null)) {
			return new ResponseEntity<String>(message, HttpStatus.OK);
		}
		return new ResponseEntity<String>("Some error occurred!", HttpStatus.BAD_GATEWAY);
	}
	
	@PostMapping("/saveall") 
	public ResponseEntity<Integer> saveall(@RequestBody List<StudentEntity> studententityList) {
		int result = service.validateAndSaveAll(studententityList);
		if (result == 0) {
			return new ResponseEntity<Integer>(result, HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<Integer>(result, HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/getall")
	public ResponseEntity<List<StudentEntity>> getAll() {
		List<StudentEntity> list = service.getAll();
		if (list != null) {
			return new ResponseEntity<List<StudentEntity>>(list, HttpStatus.OK);
		}
		return new ResponseEntity<List<StudentEntity>>(list, HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> update(@RequestBody StudentEntity entity) {
		String message =  service.updateByName(entity);
		if (!message.equals(null)) {
			return new ResponseEntity<String>(message, HttpStatus.OK);
		}
		return new ResponseEntity<String>(message, HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> delete(String studentName) {
		String message =  service.deleteByName(studentName);
		if (!message.equals(null)) {
			return new ResponseEntity<String>(message, HttpStatus.OK);
		}
		return new ResponseEntity<String>(message, HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/getallbycollegecode")
	public ResponseEntity<List<StudentEntity>> getAllByCollegeName(String collegeCode) {
		List<StudentEntity> list = service.getAllByCollegeName(collegeCode);
		if (list != null) {
			return new ResponseEntity<List<StudentEntity>>(list, HttpStatus.OK);
		}
		return new ResponseEntity<List<StudentEntity>>(list, HttpStatus.BAD_REQUEST);
		
	}
	
	@PutMapping("/updatestudentsemesterbystudentAddress")
	public ResponseEntity<Boolean> UpdateStudentSemesterByStudentAddress(String studentAddress, Integer studentSemester) {
		boolean isUpdated = service.validateAndUpdateStudentSemesterByStudentAddress(studentSemester, studentAddress);
		if (isUpdated) {
			return new ResponseEntity<Boolean>(isUpdated, HttpStatus.OK);
		}
		return new ResponseEntity<Boolean>(isUpdated, HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping("/updatestudentnamebystudentaddres")
	public ResponseEntity<StudentEntity> UpdateStudentNameByStudentAddres(String studentName, String studentAddress) {
		StudentEntity entity = service.validateAndUpdateStudentNameByStudentAddress(studentName, studentAddress);
		if (entity != null) {
			return new ResponseEntity<StudentEntity>(entity, HttpStatus.OK);
		}
		return new ResponseEntity<StudentEntity>(entity, HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/getallbystudentsemester")
	public ResponseEntity<List<StudentEntity>> getAllByStudentSemester(Integer studentSemester) {
		List<StudentEntity> studentlist = service.getAllByStudentSemester(studentSemester);
		if (studentlist != null) {
			return new ResponseEntity<List<StudentEntity>>(studentlist, HttpStatus.OK);
		}
		return new ResponseEntity<List<StudentEntity>>(studentlist, HttpStatus.BAD_REQUEST);
	}

	@PutMapping("/updatestudentsemesterandstudentaddressbystudentname")
	public ResponseEntity<StudentEntity> updateStudentSemesterAndStudentAddressByStudentName(int studentSemester, String studentAddress,
			String studentName) {
		StudentEntity entity = service.updateStudentSemesterAndStudentAddressByStudentName(studentSemester, studentAddress, studentName);
		if (entity != null) {
			return new ResponseEntity<StudentEntity>(entity, HttpStatus.OK);
		}
		
		return new ResponseEntity<StudentEntity>(entity, HttpStatus.BAD_REQUEST);
	}
	 
}
