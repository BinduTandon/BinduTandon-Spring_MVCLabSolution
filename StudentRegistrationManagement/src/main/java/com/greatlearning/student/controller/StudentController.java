package com.greatlearning.student.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.student.Student;
import com.greatlearning.student.service.StudentService;

@Controller

public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping("/")
	public String getStudents(Map<String, List<Student>> map) {
		map.put("students", studentService.findAll());
		return "studentlist";
	}

	@GetMapping("/delete")
	public String deleteStudent(@RequestParam int studentId) {
		this.studentService.delete(studentId);
		return "redirect:/";
	}

	@GetMapping("/add")
	public String addStudent(Map<String, Student> map) {
		map.put("Student", new Student());
		return "studentform";
	}

	@GetMapping("/update")
	public String updateStudent(@RequestParam int studentId, Map<String, Student> map) {
		System.out.println("update " + studentId);
		Student student = this.studentService.findById(studentId);
		map.put("Student", student);
		return "studentform";
	}

	@PostMapping("/save")
	public String save(Student student) {
		this.studentService.save(student);
		return "redirect:/";
	}
}
