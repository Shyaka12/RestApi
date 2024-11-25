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
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(int id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public void createStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public ResponseEntity<Student> updateStudent(int id, Student updatedStudent) {
        Optional<Student> optionalStudent = studentRepository.findById(id);

        if (!optionalStudent.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        Student existingStudent = optionalStudent.get();
        existingStudent.setFirstName(updatedStudent.getFirstName());
        existingStudent.setLastName(updatedStudent.getLastName());
        existingStudent.setPercentange(updatedStudent.getPercentange());

        studentRepository.save(existingStudent);
        return ResponseEntity.ok(existingStudent);
    }

    @Override
    public void deleteStudent(int id) {
        Student student = studentRepository.findById(id).get();
        studentRepository.delete(student);
    }
}
