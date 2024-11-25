package com.RestApi.RESTAPI.CRUD.Repository;

import com.RestApi.RESTAPI.CRUD.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public  interface StudentRepository extends JpaRepository<Student, Integer> {
}
