package org.example.Service;

import org.springframework.stereotype.Component;

@Component
public class PwdService {
   public String encrypyPassword(String pwd){
       System.out.println("Password Encrypt Successfully!");
       return pwd+"##";
   }
}
