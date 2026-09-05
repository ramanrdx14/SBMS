package org.example.rest;

import org.example.entity.Student;
import org.example.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class MyRestController {
    @Autowired
    StudentRepo studentRepo;
    @PostMapping("/add")
    public String addStudent(@RequestBody Student student){
        studentRepo.save(student);
        return "Student added!!";
    }
    @GetMapping("/all")
    public Iterable<Student> addStudent(){
        Iterable<Student> all = studentRepo.findAll();
        return all;
    }
}
