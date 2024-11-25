package com.RestApi.RESTAPI.CRUD.StudentServiceImpl;

import com.RestApi.RESTAPI.CRUD.Model.Student;
import com.RestApi.RESTAPI.CRUD.Repository.StudentRepository;
import com.RestApi.RESTAPI.CRUD.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        try {
            return studentRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error while fetching students: " + e.getMessage());
        }
    }
    @Override
    public Student getStudentById(int id) {
        try {
            Optional<Student> student = studentRepository.findById(id);
            if (student.isEmpty()) {
                throw new RuntimeException("Student not found with id: " + id);
            }
            return student.get();
        } catch (Exception e) {
            throw new RuntimeException("Error while fetching student: " + e.getMessage());
        }
    }

    @Override
    public void createStudent(Student student) {
        try {
            studentRepository.save(student);
        } catch (Exception e) {
            throw new RuntimeException("Error while creating student: " + e.getMessage());
        }
    }

    @Override
    public ResponseEntity<Student> updateStudent(int id, Student updatedStudent) {
        try {
            Optional<Student> optionalStudent = studentRepository.findById(id);

            if (optionalStudent.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }

            Student existingStudent = optionalStudent.get();
            existingStudent.setFirstName(updatedStudent.getFirstName());
            existingStudent.setLastName(updatedStudent.getLastName());
            existingStudent.setPercentange(updatedStudent.getPercentange());

            Student savedStudent = studentRepository.save(existingStudent);
            return ResponseEntity.ok(savedStudent);

        } catch (Exception e) {
            throw new RuntimeException("Error while updating student: " + e.getMessage());
        }
    }

    @Override
    public void deleteStudent(int id) {
        try {
            Optional<Student> student = studentRepository.findById(id);
            if (student.isEmpty()) {
                throw new RuntimeException("Student not found with id: " + id);
            }
            studentRepository.delete(student.get());
        } catch (Exception e) {
            throw new RuntimeException("Error while deleting student: " + e.getMessage());
        }
    }
}
