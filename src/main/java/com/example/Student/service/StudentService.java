package com.example.Student.service;


import com.example.Student.repository.StudentRepository;
import com.example.Student.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {


    @Autowired
    StudentRepository repo;

    public List<Student> getAll(){
        return repo.findAll();
    }

    public Student addStudent(Student student){
        return repo.save(student);
    }

    public void deleteAll(){
         repo.deleteAll();
    }
}
