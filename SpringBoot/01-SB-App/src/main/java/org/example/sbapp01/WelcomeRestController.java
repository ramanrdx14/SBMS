package org.example.sbapp01;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeRestController {
    @GetMapping("/")
    public String getMessege(){
        return "Welcome Raman to BOOT!!";
    }
}
