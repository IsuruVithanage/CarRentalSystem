package lk.carrental.spring.repo;

import lk.carrental.spring.config.JPAConfig;
import lk.carrental.spring.entity.User;
import lk.carrental.spring.entity.Vehicle;
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
public class VehicleRepoTest {
    @Autowired
    VehicleRepo vehicleRepo;

    @Test
    public void saveVehicle() {
        Vehicle vehicle=new Vehicle("V002","Toyota","Car","4","Auto","Petrol","White","12333",100,100,100,100,"avaialable");
        vehicleRepo.save(vehicle);

    }

    @Test
    public void getAllVehicle() {
        List<Vehicle> all = vehicleRepo.findAll();
        for (Vehicle vehicle : all) {
            System.out.println(vehicle.toString());
        }
    }

    @Test
    public void deleteVehicle() {
        vehicleRepo.deleteById("V002");
    }

    @Test
    public void updateVehicle(){
        if (vehicleRepo.existsById("V001")) {
            Vehicle vehicle=new Vehicle("V001","Toyota","Van","4","Auto","Petrol","White","12333",100,100,100,100,"avaialable");
            vehicleRepo.save(vehicle);
        }else{
            throw new RuntimeException("No Such Diver To Update");
        }

    }
}
