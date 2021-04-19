package com.wolken.wolkenapp.springbootstudentapp.dto;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class StudentDTO {

	private String studentName;
	private String studentAddress;
	private int studentSemester;
	private String collegeName;
}
