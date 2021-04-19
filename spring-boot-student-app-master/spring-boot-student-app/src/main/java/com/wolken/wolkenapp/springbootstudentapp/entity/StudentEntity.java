package com.wolken.wolkenapp.springbootstudentapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Component
@Table(name="student_spring_table")
public class StudentEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@GenericGenerator(name = "native", strategy = "native")
	private int studentId;
	@Column(name="studentName")
	private String studentName;
	@Column(name="studentAddress")
	private String studentAddress;
	@Column(name="studentSemester")
	private int studentSemester;
	
	@OneToOne
	@JoinColumn(name = "id")
	@JsonIgnoreProperties("studententity")
	private CollegeEntity collegeentity;
	
	
}

