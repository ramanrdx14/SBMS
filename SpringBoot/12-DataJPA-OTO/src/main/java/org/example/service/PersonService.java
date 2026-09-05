package org.example.service;

import org.example.entity.Passport;
import org.example.entity.Person;
import org.example.repo.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    PersonRepo personRepo;
    public void savePerson(){
        Passport passport = new Passport();
        passport.setPassportNo("ABCDEF-XLALD-124424");
        Person   person   = new Person();
        person.setEmail("suman@gmailc.om");
        person.setName("Suman");

        //Association
        person.setPassport(passport);
        passport.setPerson(person);

        //Save Parent record
        personRepo.save(person);

    }
    public void findAllPerson(){
       personRepo.findAll().forEach(System.out::println);
    }
}
