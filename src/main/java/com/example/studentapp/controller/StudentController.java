package com.example.studentapp.controller;

import com.example.studentapp.entity.Student;
import com.example.studentapp.service.StudentService;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import com.example.studentapp.dto.StudentDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private static final Logger logger =
            LoggerFactory.getLogger(StudentController.class);

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllStudents() {
        logger.info("Received request to fetch all students");
        return studentService.getAllStudents();
    }

    @PostMapping
    public Student addStudent(@Valid @RequestBody StudentDto studentDto) {

        logger.info("Received request to add student with email {}", studentDto.getEmail());

        Student student = new Student();

        student.setName(studentDto.getName());
        student.setCourse(studentDto.getCourse());
        student.setEmail(studentDto.getEmail());

        return studentService.addStudent(student);
    }

    @PutMapping("/{id}")
    public Student updateStudent(
            @PathVariable Long id,
            @Valid @RequestBody StudentDto studentDto) {

        Student student = new Student();

        student.setName(studentDto.getName());
        student.setCourse(studentDto.getCourse());
        student.setEmail(studentDto.getEmail());

        return studentService.updateStudent(id, student);
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id) {

        logger.info("Received request to delete student with id {}", id);

        studentService.deleteStudent(id);

        return "Student deleted successfully";
    }

    @GetMapping("/email/{email}")
    public Student getStudentByEmail(
            @PathVariable String email) {

        return studentService.getStudentByEmail(email);
    }

    @GetMapping("/course/{course}")
    public List<Student> getStudentsByCourse(
            @PathVariable String course) {

        return studentService.getStudentsByCourse(course);
    }

    @GetMapping("/name/{name}")
    public List<Student> searchStudentsByName(@PathVariable String name) {
        return studentService.searchStudentsByName(name);
    }

    @GetMapping("/page")
    public Page<Student> getStudents(Pageable pageable) {
        return studentService.getStudents(pageable);
    }
}