package com.example.studentapp.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class StudentDto {

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Course is required")
    private String course;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
    private String email;

    public StudentDto() {
    }

    public String getName() { //Returns values of the name//
        return name;
    }

    public void setName(String name) { //Setters -- update values//
        this.name = name;  // = name <--- method Parameter  this.name <-- class variable//
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

    public void setEmail(String email) {
        this.email = email;
    }
}