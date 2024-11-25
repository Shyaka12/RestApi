package com.RestApi.RESTAPI.CRUD.Service;

import com.RestApi.RESTAPI.CRUD.Model.Student;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    Student getStudentById(int id);
    void createStudent(Student student);
    ResponseEntity<Student> updateStudent(int id, Student student);
    void deleteStudent(int id);
}
