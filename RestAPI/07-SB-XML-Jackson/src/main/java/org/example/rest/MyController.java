package org.example.rest;

import org.example.bindings.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @PostMapping(value = "/student",consumes = {"application/json","application/xml"},produces = "text/plain")
    public String addStudent(@RequestBody Student student){
        System.out.println(student);
        return "student added";
    }
    @GetMapping(value = "/student",produces = {"application/json","application/xml"})
    public ResponseEntity<Student> getStudent(){
        Student std = new Student();
        std.setStdId("S-1");
        std.setStdName("AAA");
        std.setStdRoll("101");
        return new ResponseEntity<>(std, HttpStatus.OK);
    }
}
