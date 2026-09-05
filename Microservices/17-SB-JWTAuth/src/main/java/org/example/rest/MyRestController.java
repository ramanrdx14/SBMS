package org.example.rest;

import org.example.bindings.StdAuthenticate;
import org.example.entity.Student;
import org.example.repo.StudentRepo;
import org.example.service.JWTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    StudentRepo studentRepo;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JWTService jwtService;
    @PostMapping("/register")
    public String registerStudent(@RequestBody Student student){
        String encode = passwordEncoder.encode(student.getStdPwd());
        student.setStdPwd(encode);
        studentRepo.save(student);
        return "User Register Successfully";
    }
    @PostMapping("/login")
    public String loginStudent(@RequestBody StdAuthenticate stdAuthenticate){
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(stdAuthenticate.getStdName(),stdAuthenticate.getStdPwd());

        try{
            authenticationManager.authenticate(authentication);
            //get JWT Token
            String token = jwtService.generateToken(stdAuthenticate.getStdName());
            return token; // return token in response
        }catch (Exception e){
            e.printStackTrace();
        }
        return "Invalid Credentials !!";
    }
    @GetMapping("/welcome")
    public String welcomeStudent(){
        return "welcome User";
    }
}
