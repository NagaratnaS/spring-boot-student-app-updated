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
	
	@GetMapping("/getall")
	public ResponseEntity<List<StudentEntity>> getAll() {
		List<StudentEntity> list = service.getAll();
		if (list != null) {
			return new ResponseEntity<List<StudentEntity>>(list, HttpStatus.OK);
		}
		return new ResponseEntity<List<StudentEntity>>(list, HttpStatus.BAD_GATEWAY);
	}
	
	@PutMapping("/update")
	public String update(@RequestBody StudentEntity entity) {
		return service.updateByName(entity);
	}
	
	@DeleteMapping("/delete")
	public String delete(String studentName) {
		return service.deleteByName(studentName);
	}
	
	@GetMapping("/getallbycollegecode")
	public ResponseEntity<List<StudentEntity>> getAllByCollegeName(String collegeCode) {
		List<StudentEntity> list = service.getAllByCollegeName(collegeCode);
		if (list != null) {
			return new ResponseEntity<List<StudentEntity>>(list, HttpStatus.OK);
		}
		return new ResponseEntity<List<StudentEntity>>(list, HttpStatus.BAD_REQUEST);
		
	}
	

	
	 
}
