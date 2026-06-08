package com.example.studentapp.repository;

import com.example.studentapp.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Student findByEmail(String email);

    List<Student> findByCourseContainingIgnoreCase(String course);

    List<Student> findByNameIgnoreCase(String name);

}