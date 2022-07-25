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

import java.util.List;

@WebAppConfiguration
@ContextConfiguration(classes = {JPAConfig.class})
@ExtendWith(SpringExtension.class)
//@Transactional
public class CustomerRepoTest {
    @Autowired
    CustomerRepo customerRepo;

    @Test
    public void saveCustomer() {
        Customer customer1 = new Customer("C002", "Isuru", "Panadura", "ema", "123sds", "1233232",
                "232323", new User("UC002", "Isuru", "1234", "Cust"));
        customerRepo.save(customer1);

    }

    @Test
    public void getAllCustomers() {
        List<Customer> all = customerRepo.findAll();
        for (Customer customer : all) {
            System.out.println(customer.toString());
        }
    }



}
