package com.university.crud.service;

import com.university.crud.model.Student;
import com.university.crud.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudent() {
        return this.studentRepository.findAll();
    }

    @Override
    public Optional<Student> getStudentById(Long id) {
        return this.studentRepository.findById(id);
    }

    @Override
    public Student createStudent(Student student) {
//        Optional<Student> existStudent = this.studentRepository.findByEmailAddress(student.getEmail());
//        if (existStudent.isPresent()){
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,student.getEmail() + "already exist");
//        }
        return this.studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Student student) {
        this.studentRepository.delete(student);
    }
}
