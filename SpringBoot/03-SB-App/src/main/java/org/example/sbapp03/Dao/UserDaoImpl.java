package org.example.sbapp03.Dao;

import org.springframework.stereotype.Component;

@Component("User1")
public class UserDaoImpl implements UserDao{
    UserDaoImpl(){
        System.out.println("UserDao constructor ...");
    }
    @Override
    public String findNameById(int Id) {
        return "Raju";
    }
}
