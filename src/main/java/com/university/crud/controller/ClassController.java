package com.university.crud.controller;

import com.university.crud.model.Classes;
import com.university.crud.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/classes")
public class ClassController {

    @Autowired
    private ClassService classService;

    //get all classes
    @GetMapping
    public List<Classes> getAllClasses(){
        return this.classService.getAllClasses();
    }

    //get class by id
    @GetMapping(path = "/{id}")
    public Classes getClassById(@PathVariable (value = "id") Long id){
        Optional<Classes> classById = this.classService.getClassById(id);
        Classes classes = classById.get();
        return classes;
    };

    //save class
    @PostMapping
    public Classes createClass(@RequestBody Classes classes){
        return this.classService.createClass(classes);
    }

    //update class
    @PutMapping(path = "/{id}")
    public Classes updateClass(@PathVariable (value = "id") Long id,
                               @Valid @RequestBody Classes classDetails){
        Optional<Classes> classById = this.classService.getClassById(id);
        Classes classes = classById.get();
        classes.setSubject(classDetails.getSubject());
        classes.setDescription(classDetails.getDescription());
        return this.classService.createClass(classes);
    }

    //delete class
    @DeleteMapping(path = "/{id}")
    public void deleteClass(@PathVariable (value = "id") Long id){
        Optional<Classes> classById = this.classService.getClassById(id);
        Classes classes = classById.get();
        this.classService.deleteClass(classes);
    }

}
