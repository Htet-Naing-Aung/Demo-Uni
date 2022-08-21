package com.university.crud.service;

import com.university.crud.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    List<Student> getAllStudent();

    Optional<Student> getStudentById(Long id);

    Student createStudent(Student student);

    void deleteStudent(Student student);
}
