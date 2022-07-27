package lk.carrental.spring.repo;

import lk.carrental.spring.config.JPAConfig;
import lk.carrental.spring.entity.Admin;
import lk.carrental.spring.entity.Customer;
import lk.carrental.spring.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

@WebAppConfiguration
@ContextConfiguration(classes = {JPAConfig.class})
@ExtendWith(SpringExtension.class)
//@Transactional
public class AdminRepoTest {
    @Autowired
    AdminRepo adminRepo;

    @Test
    public void saveAdmin() {
        Admin admin = new Admin("A-003","Nimal","emsd","12223",new User("U-005","Nimal","232323","ad"));
        adminRepo.save(admin);

    }
}
