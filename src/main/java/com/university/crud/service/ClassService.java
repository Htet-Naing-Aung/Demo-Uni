package com.university.crud.service;

import com.university.crud.model.Classes;

import java.util.List;
import java.util.Optional;

public interface ClassService {
    List<Classes> getAllClasses();

    Optional<Classes> getClassById(Long id);

    Classes createClass(Classes classes);

    void deleteClass(Classes classes);
}
