package com.studentportal.controllers;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import com.studentportal.services.StudentService;
import com.studentportal.models.Student;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping(value= "/api/student")
public class StudentController {
	
	@Autowired 
	StudentService studentService;
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping(value= "/getall")
	public List<Student> getAllStudent(){
		logger.debug("Getting All Students.");
		return studentService.getAllStudents();
	}
	
	@GetMapping(value= "/getStudent/{id}")
	public Optional<Student> getStudentByID(@PathVariable(value="id") String id){
		logger.debug("Get Student by ID");
		return studentService.getAllStudents(id);
	}
	
	@PostMapping(value="/create")
	public ResponseEntity<String> createStudent(@RequestBody Student student)
	{
		logger.debug("Creating Student");
		return ResponseEntity.ok("student created with id "+studentService.createStudent(student));
	}
	
	@PutMapping(value="/update/{id}")
	public ResponseEntity<String> updateStudent(@RequestBody Student student, @PathVariable(value="id") String id){
		logger.debug("Updating Student", id);
		student.setId(id);
		studentService.updateStudent(student);
		return ResponseEntity.ok("Student Record Updated");
	}
	
	@DeleteMapping(value="/delete/{id}")
	public ResponseEntity<String> deleteStudentByID(@PathVariable(value="id") String id) {
		logger.debug("Deleting Student", id);
		studentService.deleteStudent(id);
		return ResponseEntity.ok("Student Deleted");
	}
	
	@DeleteMapping(value="/deleteAll")
	public ResponseEntity<String> deleteAllStudent() {
		logger.debug("Deleting All Students");
		studentService.deleteAllStudent();
		return ResponseEntity.ok("All Student Deleted");
	}
}
