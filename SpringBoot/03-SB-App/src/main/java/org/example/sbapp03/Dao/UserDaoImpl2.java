package org.example.sbapp03.Dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("User2")
@Primary
public class UserDaoImpl2 implements UserDao{
    UserDaoImpl2(){
        System.out.println("User Dao Impl2 :: ");
    }
    @Override
    public String findNameById(int Id) {
        return "Tilak";
    }
}
