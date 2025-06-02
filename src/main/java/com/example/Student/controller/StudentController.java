package com.example.Student.controller;

import com.example.Student.Entity.Student;
import com.example.Student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService service;

    @GetMapping("/all")
    public List<Student> getAll(){
        return service.getAll();
    }

    @PostMapping("/add")
    public Student addStudent(@RequestBody Student student){
        return service.addStudent(student);
    }

    @DeleteMapping("/delete")
    public void deleteAll(){
        service.deleteAll();
    }

}
