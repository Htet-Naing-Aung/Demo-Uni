package com.university.crud.controller;

import com.university.crud.model.Student;
import com.university.crud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    private Boolean addStudentSuccess;

    //get all students
    @GetMapping
    public List<Student> getAllStudent(){
        return this.studentService.getAllStudent();
    }

    //get student by id
    @GetMapping(path = "/{id}")
    public Student getStudentById(@PathVariable(value = "id") Long id){
        Optional<Student> studentById = this.studentService.getStudentById(id);
        Student student = studentById.get();
        return student;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student){
        return this.studentService.createStudent(student);
    }

    //update student
    @PutMapping(path = "/{id}")
    public Student updateStudent(@PathVariable (value = "id") Long id,
                                 @Valid @RequestBody Student studentDetails){
        Optional<Student> studentById = this.studentService.getStudentById(id);
        Student student = studentById.get();
        student.setName(studentDetails.getName());
        student.setEmail(studentDetails.getEmail());
        student.setAddress(studentDetails.getAddress());
        return this.studentService.createStudent(student);
    }

    //delete student return boolean
    @DeleteMapping(path = "/{id}")
    public void deleteStudent(@PathVariable (value = "id") Long id){
        Optional<Student> studentById = this.studentService.getStudentById(id);
        Student student = studentById.get();
        this.studentService.deleteStudent(student);
    }
}
