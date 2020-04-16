package com.studentportal.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.studentportal.models.Student;

@Repository
public interface StudentDAO extends MongoRepository<Student, String> {

}
