package org.example.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestContoller{
    @GetMapping("/")
    public String welcome(){
        return "Welcome to Rest API";
    }

    @GetMapping("/greet")
    public String greet(@RequestParam(defaultValue = "Guest",name = "name") String name){
        return "Hi "+name+" Good Moring !!";
    }
    @GetMapping("/greet2/{name}")
    public ResponseEntity<String> greet2(@PathVariable(name = "name") String name){
        String msg = "Good Night "+name;
        return new ResponseEntity<String>(msg,HttpStatus.OK);
    }
    @GetMapping("/greet3")
    public ResponseEntity<Void> greet3(){
        System.out.println("Greet3 Method Called");
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
