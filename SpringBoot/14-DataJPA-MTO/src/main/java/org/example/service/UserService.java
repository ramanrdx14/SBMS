package org.example.service;

import org.example.entity.Roles;
import org.example.entity.User;
import org.example.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Arrays;
@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    public void saveUser(){
        User u1 = new User();
        Roles r1 = new Roles();
        Roles r2 = new Roles();
        r1.setRoleName("Admin");
        r2.setRoleName("Manager");
        u1.setUserName("A");
        u1.setRoles(Arrays.asList(r1,r2));
        r1.setUsers(Arrays.asList(u1));
        r2.setUsers(Arrays.asList(u1));

        userRepo.save(u1);
    }
}
