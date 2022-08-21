package com.university.crud.service;

import com.university.crud.model.Classes;
import com.university.crud.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassServiceImpl implements ClassService{

    @Autowired
    private ClassRepository classRepository;

    @Override
    public List<Classes> getAllClasses() {
        return this.classRepository.findAll();
    }

    @Override
    public Optional<Classes> getClassById(Long id) {
        return this.classRepository.findById(id);
    }

    @Override
    public Classes createClass(Classes classes) {
        return this.classRepository.save(classes);
    }

    @Override
    public void deleteClass(Classes classes) {
        this.classRepository.delete(classes);
    }
}
