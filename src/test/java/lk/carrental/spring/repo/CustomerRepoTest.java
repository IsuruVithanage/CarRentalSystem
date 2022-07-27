package lk.carrental.spring.repo;

import lk.carrental.spring.config.JPAConfig;
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
        Customer customer1 = new Customer("C-001", "Isuru", "Panadura", "ema", "123sds", "1233232",
                "232323", new User("UC003", "Isuru", "1234", "Cust"));
        customerRepo.save(customer1);

    }

    @Test
    public void getAllCustomers() {
        List<Customer> all = customerRepo.findAll();
        for (Customer customer : all) {
            System.out.println(customer.toString());
        }
    }

    @Test
    public void generateid() {
        Customer top = customerRepo.findTopByOrderByCustIDDesc();
        if(top!=null){
            Integer index = Integer.parseInt(top.getCustID().split("-")[1]);
            ++index;
            System.out.println(index<10 ? "C-00"+index : index<100 ? "O-0"+index :"O-"+index);
        }
        System.out.println("C-001");
    }

    @Test
    public void deleteCustomer() {
        customerRepo.deleteById("C-001");
    }

    @Test
    public void updateCustomer(){
        if (customerRepo.existsById("C002")) {
            Customer customer1 = new Customer("C002", "Isuru", "Colombo", "ema", "123sds", "1233232",
                    "232323", new User("UC002", "Isuru", "1234", "Cust"));
            customerRepo.save(customer1);
        }else{
            throw new RuntimeException("No Such Customer To Update");
        }

    }



}
