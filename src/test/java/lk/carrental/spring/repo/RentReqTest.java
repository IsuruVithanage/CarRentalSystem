package lk.carrental.spring.repo;

import lk.carrental.spring.config.JPAConfig;
import lk.carrental.spring.entity.*;
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
public class RentReqTest {
    @Autowired
    RentReqRepo rentReqRepo;

    @Autowired
    VehicleRepo vehicleRepo;

    @Autowired
    DriverRepo driverRepo;

    @Autowired
    CustomerRepo customerRepo;

    @Test
    public void saveUser() {
        Vehicle id = vehicleRepo.getReferenceById("V002");
        Driver d002 = driverRepo.getReferenceById("D001");
        Customer c002 = customerRepo.getReferenceById("C003");

        RentReq rentReq=new RentReq("R001","23","2","33","12","Yes","Pending","none",id,d002,c002);
        rentReqRepo.save(rentReq);

    }

    @Test
    public void getAllRentReq() {
        List<RentReq> all = rentReqRepo.findAll();
        for (RentReq rentReq : all) {
            System.out.println(rentReq.toString());
        }
    }

    @Test
    public void deleteRentReq() {
        rentReqRepo.deleteById("R001");
    }

    @Test
    public void updateRentReq(){
        if (rentReqRepo.existsById("R001")) {
            Vehicle id = vehicleRepo.getReferenceById("V001");
            Driver d002 = driverRepo.getReferenceById("D002");
            Customer c002 = customerRepo.getReferenceById("C002");
            RentReq rentReq=new RentReq("R001","100","2","33","12","Yes","Pending","none",id,d002,c002);
            rentReqRepo.save(rentReq);
        }else{
            throw new RuntimeException("No Such Diver To Update");
        }

    }
}
