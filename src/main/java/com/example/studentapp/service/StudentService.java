package com.example.studentapp.service;

import com.example.studentapp.entity.Student;
import com.example.studentapp.repository.StudentRepository;
import org.springframework.stereotype.Service;
import com.example.studentapp.exception.StudentNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        logger.info("Fetching all students");
        return studentRepository.findAll();
    }

    public Student addStudent(Student student) {
        logger.info("Adding student with email {}", student.getEmail());
        return studentRepository.save(student);
    }

    public Student updateStudent(Long id, Student updatedStudent) {
        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student not found with id: " + id));

        existingStudent.setName(updatedStudent.getName());
        existingStudent.setCourse(updatedStudent.getCourse());
        existingStudent.setEmail(updatedStudent.getEmail());

        return studentRepository.save(existingStudent);
    }

    public void deleteStudent(Long id) {

        logger.info(
                "Deleting student with id {}",
                id);

        if (!studentRepository.existsById(id)) {
            throw new StudentNotFoundException("Student not found with id: " + id);
        }

        studentRepository.deleteById(id);
    }

    public Student getStudentByEmail(String email) {

        Student student = studentRepository.findByEmail(email);

        if (student == null) {
            logger.warn(
                    "Student not found with email {}",
                    email);
            throw new StudentNotFoundException(
                    "Student not found with email: " + email);
        }

        return student;
    }

    public List<Student> getStudentsByCourse(String course) {
        return studentRepository.findByCourseContainingIgnoreCase(course);
    }

    public List<Student> searchStudentsByName(String name) {
        return studentRepository.findByNameIgnoreCase(name);
    }

    public Page<Student> getStudents(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }

    private static final Logger logger =
            LoggerFactory.getLogger(StudentService.class);

}