package lk.carrental.spring.repo;

import lk.carrental.spring.config.JPAConfig;
import lk.carrental.spring.dto.UserDTO;
import lk.carrental.spring.entity.Customer;
import lk.carrental.spring.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

@WebAppConfiguration // State test configuration class
@ContextConfiguration(classes = {JPAConfig.class}) // import configurations for Test Context
@ExtendWith(SpringExtension.class) // Run with Spring Extension
//@Transactional
public class CustomerRepoTest {
    @Autowired
    CustomerRepo customerRepo;

    @Test // Test method
    public void saveCustomer() {
        //Ok let's save a customer using Customer Repo
        Customer customer1 = new Customer("C002", "Isuru", "Panadura", "ema", "123sds", "1233232",
                "232323", new User("UC002", "Isuru", "1234", "Cust"));
        customerRepo.save(customer1);

    }

}
