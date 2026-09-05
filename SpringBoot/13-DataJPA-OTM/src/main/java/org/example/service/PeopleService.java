package org.example.service;

import org.example.entity.BankName;
import org.example.entity.People;
import org.example.repo.PeopleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class PeopleService {
    @Autowired
    PeopleRepo peopleRepo;
    public void savePeople(){



        People people = new People();
        people.setName("Ankit");
        people.setNumber("9914173314");

        BankName b1 = new BankName();
        b1.setAdddress("Addr1");
        b1.setBankName("BOI");
        b1.setIfscCode("1234");

        BankName b2 = new BankName();
        b2.setAdddress("Addr2");
        b2.setBankName("SBI");
        b2.setIfscCode("4356");
        b1.setPeople(people);
        b2.setPeople(people);

        people.setBankName(Arrays.asList(b1,b2));
        peopleRepo.save(people);
    }

    public void showAllPeople(){
        List<People> all = peopleRepo.findAll();

        all.forEach(People-> System.out.println(People.getName()));
    }
    public void deletePeople(Integer Id){
        peopleRepo.deleteById(Id);
    }
}
