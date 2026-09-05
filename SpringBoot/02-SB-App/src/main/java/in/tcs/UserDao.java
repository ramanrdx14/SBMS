package in.tcs;

import org.springframework.stereotype.Component;

@Component
public class UserDao {
    UserDao(){
        System.out.println("User Dao Object Created ::");
    }
}
