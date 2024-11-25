package com.RestApi.RESTAPI.CRUD.Controller;


import com.RestApi.RESTAPI.CRUD.Model.Student;
import com.RestApi.RESTAPI.CRUD.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
public class StudentController {
    @Autowired
    StudentRepository studentRepository;
    //Get the  All Students

    @GetMapping("/students")
    public List<Student> getAllStudents(){
        List <Student> students=studentRepository.findAll();
        return students;
    }
    @GetMapping("/students/{Id}")
    public Student getStudentById(@PathVariable int Id){
        Student student=studentRepository.findById(Id).get();
        return student;
    }

    @PostMapping("/student/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createStudent (@RequestBody Student student){
        studentRepository.save(student);
    }

    @PutMapping("/student/update/{id}")
    public Student updateStudents (@PathVariable int id){
         Student student = studentRepository.findById(id).get();
         student.setFirstName("kero");
         student.setLastName("Ineza");
         student.setPercentange("86");
         studentRepository.save(student);
         return student;
    }
    @DeleteMapping("/student/delete/{id}")
    public void deleteStudent (@PathVariable int id){
        Student student=studentRepository.findById(id).get();
        studentRepository.delete(student);


    }
}
