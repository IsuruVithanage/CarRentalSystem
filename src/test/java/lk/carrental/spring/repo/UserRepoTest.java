package lk.carrental.spring.repo;

import lk.carrental.spring.config.JPAConfig;
import lk.carrental.spring.entity.Driver;
import lk.carrental.spring.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

@WebAppConfiguration
@ContextConfiguration(classes = {JPAConfig.class})
@ExtendWith(SpringExtension.class)
//@Transactional
public class UserRepoTest {

    @Autowired
    UserRepo userRepo;

    @Test
    public void saveUser() {
        User user=new User("UA001","Kusum","23hnd","ad");
        userRepo.save(user);

    }

    @Test
    public void getAllUsers() {
        List<User> all = userRepo.findAll();
        for (User user : all) {
            System.out.println(user.toString());
        }
    }

    @Test
    public void deleteUser() {
        userRepo.deleteById("UD002");
    }

    @Test
    public void updateUser(){
        if (userRepo.existsById("UA001")) {
            User user=new User("UA001","Kusum123","23hnd","ad");
            userRepo.save(user);
        }else{
            throw new RuntimeException("No Such Diver To Update");
        }

    }
}
