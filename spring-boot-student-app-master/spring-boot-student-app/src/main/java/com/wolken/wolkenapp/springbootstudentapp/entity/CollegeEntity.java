package com.wolken.wolkenapp.springbootstudentapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name="college_spring_table")
public class CollegeEntity {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private int id;
	@Column(name="collegeName")
	private String collegeName;
	@Column(name="collegeCode")
	private String collegeCode;
	@Column(name="noOfBranches")
	private int noOfBranches;
	
	@OneToOne
	@JsonIgnoreProperties("collegeentity")
	private StudentEntity studenentity;
}
