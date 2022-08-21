package com.university.crud.repository;

import com.university.crud.model.Student;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

//@DataJpaTest
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    //JUnit test for save student
    @Test
    @Order(1)
    public void saveStudentTest(){

        Student student = Student.builder()
                .name("ZZZ Designer")
                .email("ZZZ@gmail.com")
                .address("Lone Khinn")
                .build();

        studentRepository.save(student);

        Assertions.assertThat(student.getId()).isGreaterThan(0);

    }

    //JUnit test for get student
    @Test
    @Order(2)
    public void getStudentTest(){

        Student student = studentRepository.findById(30L).get();

        Assertions.assertThat(student.getId()).isEqualTo(30L);

    }

    //JUnit test for get all students
    @Test
    @Order(3)
    public void getAllStudents(){

        List<Student> students = studentRepository.findAll();

        Assertions.assertThat(students.size()).isGreaterThan(0);

    }

    //JUnit test for update student
    @Test
    @Order(4)
    public void updateStudent(){

        Student student = studentRepository.findById(35L).get();

        student.setName("Senior Designer");

        Student updatedStudent = studentRepository.save(student);

        Assertions.assertThat(updatedStudent.getName()).isEqualTo("Senior Designer");

    }

    //JUnit test for delete student
    @Test
    @Order(5)
    public void deleteStudent(){

        Student student = studentRepository.findById(35L).get();

        studentRepository.delete(student);

        Student studentReFindByEmail = null;

        Optional<Student> optionalStudent = studentRepository.findByEmail("graphicdesigner@gmail.com");

        if (optionalStudent.isPresent()){
            studentReFindByEmail = optionalStudent.get();
        }

        Assertions.assertThat(studentReFindByEmail).isNull();

    }

}
