package org.example;

import org.example.entity.People;
import org.example.service.PeopleService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context =  SpringApplication.run(Application.class, args);
        PeopleService service = context.getBean(PeopleService.class);
        //service.savePeople();
        //service.showAllPeople();
        //service.deletePeople(1); Since Cascade is ALL then all the child records will be removed
    }

}
