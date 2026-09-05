package org.example.Service;

import org.springframework.stereotype.Component;

@Component
public class EmailService {
    public boolean sendEmail(){
        System.out.println("Email Send Successfully!");
        return true;
    }
}
