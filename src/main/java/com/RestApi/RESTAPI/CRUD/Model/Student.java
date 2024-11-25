package com.RestApi.RESTAPI.CRUD.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "student" )
public class Student {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int rollNo;
    private String firstName;
    private String lastName;
    private String percentange;

}
