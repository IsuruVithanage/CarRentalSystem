package lk.carrental.spring.repo;


import lk.carrental.spring.config.JPAConfig;
import lk.carrental.spring.entity.Customer;
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
public class DriverRepoTest {

    @Autowired
    DriverRepo driverRepo;

    @Test
    public void saveDriver() {
        Driver driver=new Driver("D-001","Nuwan","Galle","23332","323","12212","available",new User("UD002","Nuwan","34nd","dr"));
        driverRepo.save(driver);

    }

    @Test
    public void getAllDrivers() {
        List<Driver> all = driverRepo.findAll();
        for (Driver driver : all) {
            System.out.println(driver.toString());
        }
    }

    @Test
    public void deleteDriver() {
        driverRepo.deleteById("D001");
    }

    @Test
    public void updateDriver(){
        if (driverRepo.existsById("D002")) {
            Driver driver=new Driver("D002","Saman","Galle","23332","323","12212","available",new User("UD002","Nuwan","34nd","dr"));
            driverRepo.save(driver);
        }else{
            throw new RuntimeException("No Such Diver To Update");
        }

    }
}
