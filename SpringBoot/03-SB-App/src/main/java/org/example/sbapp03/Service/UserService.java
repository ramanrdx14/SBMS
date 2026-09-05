package org.example.sbapp03.Service;

import org.example.sbapp03.Dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class UserService {
    @Autowired
    //@Qualifier("User2")
    private UserDao userDao;

    UserService(){
        System.out.println("UserService Constructor Execute::");
    }
    public void getName(int id){
        String name = userDao.findNameById(id);
        System.out.println(name);
    }
}
