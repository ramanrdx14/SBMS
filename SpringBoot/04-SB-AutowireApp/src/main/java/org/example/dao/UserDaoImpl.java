package org.example.dao;

import org.springframework.stereotype.Component;

@Component
public class UserDaoImpl implements IuserDao{
    @Override
    public boolean saveUser(String name, String email, String password) {
        System.out.println("Data Saved in Database");
        return true;
    }
}
