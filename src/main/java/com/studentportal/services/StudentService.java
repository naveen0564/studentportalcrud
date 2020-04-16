package com.studentportal.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.studentportal.dao.StudentDAO;
import com.studentportal.models.Student;

@Service
public class StudentService {
	@Autowired
	StudentDAO studentDAO;
	
	public List<Student> getAllStudents(){
		return studentDAO.findAll();
	}
	
	public Optional<Student> getAllStudents(String id){
		return studentDAO.findById(id);
	}
	
	public String createStudent(Student student){
		studentDAO.save(student);
		return student.getId();
	}
	
	public void updateStudent(Student student){
		studentDAO.save(student);
	}
	
	public void deleteStudent(String id){
		studentDAO.deleteById(id);
	}
	
	public void deleteAllStudent(){
		studentDAO.deleteAll();
	}
}
