package com.restdemo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	private List<Student> student;
	
	@PostConstruct
	public void loadData() {
		
		student = new ArrayList<>();
		student.add(new Student("Abhishek", "Ramamurthy"));
		student.add(new Student("Ramamurthy", "Rangaiah"));
		student.add(new Student("Anand", "Ramamurthy"));
	}
	
	@GetMapping("/students")
	public List<Student> getStudents () {
		
		return student;
	}
	
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		
		//index from list
		if(studentId >= student.size() || studentId < 0) {
			throw new StudentNotFoundException("student not found "+ studentId);
		} 
		return student.get(studentId);
	}
	
}
