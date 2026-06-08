package com.example.studentapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity     // It Tells Spring and Hibernate that this class will become database table//
public class Student {

    @Id         //--- this field is primary key.//
    @GeneratedValue(strategy = GenerationType.IDENTITY)   //It creates id automatically for every student//

    private Long id;
    private String name;
    private String course;
    private String email;

    public Student() {
    }

    public Student(Long id, String name, String course, String email) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

}