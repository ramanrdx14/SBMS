package org.example;

import org.example.entity.ContactInfo;
import org.example.repo.ContactInfoRepositary;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        ContactInfoRepositary repobean = context.getBean(ContactInfoRepositary.class);
        List<Object[]> contactInfo = repobean.getContactInfo("CI-1");
        contactInfo.forEach(e-> System.out.println((String)e[1]));

    }

}
