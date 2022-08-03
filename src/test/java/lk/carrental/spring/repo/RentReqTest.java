package lk.carrental.spring.repo;

import lk.carrental.spring.config.JPAConfig;
import lk.carrental.spring.entity.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

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
    public void saveReq() {
        Vehicle id = vehicleRepo.getReferenceById("V-001");
        Driver d002 = driverRepo.getReferenceById("D-001");
        Customer c002 = customerRepo.getReferenceById("C-001");

        RentReq rentReq=new RentReq("R-024","2022-06-06","2","33","12","Yes","Pending","No",8000,id,null,c002);
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
    @Transactional
    public void confirmreq() {
        rentReqRepo.confirmReq("Confirmed","R-001");
    }

    @Test
    public void updateRentReq(){
        if (rentReqRepo.existsById("R001")) {
            Vehicle id = vehicleRepo.getReferenceById("V001");
            Driver d002 = driverRepo.getReferenceById("D002");
            Customer c002 = customerRepo.getReferenceById("C002");
            RentReq rentReq=new RentReq("R001","100","2","33","12","Yes","Pending","none",8000,id,d002,c002);
            rentReqRepo.save(rentReq);
        }else{
            throw new RuntimeException("No Such Diver To Update");
        }

    }
}
