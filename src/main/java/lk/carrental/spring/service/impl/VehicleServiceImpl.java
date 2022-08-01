package lk.carrental.spring.service.impl;

import lk.carrental.spring.dto.CustomerDTO;
import lk.carrental.spring.dto.UserDTO;
import lk.carrental.spring.dto.VehicleDTO;
import lk.carrental.spring.entity.Driver;
import lk.carrental.spring.entity.User;
import lk.carrental.spring.entity.Vehicle;
import lk.carrental.spring.repo.UserRepo;
import lk.carrental.spring.repo.VehicleRepo;
import lk.carrental.spring.service.VehicleService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepo repo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void saveVehicle(VehicleDTO dto) {
        if (!repo.existsById(dto.getVehicleID())) {
            repo.save(mapper.map(dto, Vehicle.class));
        } else {
            throw new RuntimeException("Driver Already Exist..!");
        }

    }

    @Override
    public List<VehicleDTO> getAllVehicle() {
        return mapper.map(repo.findAll(), new TypeToken<List<VehicleDTO>>() {
        }.getType());
    }

    @Override
    public void deleteVehicle(String id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
        } else {
            throw new RuntimeException("Please check the Customer ID.. No Such Customer..!");
        }

    }

    @Override
    public void updateVehicle(VehicleDTO dto) {
        if (repo.existsById(dto.getVehicleID())) {
            repo.save(mapper.map(dto, Vehicle.class));
        } else {
            throw new RuntimeException("No Such Customer To Update..! Please Check the ID..!");
        }

    }

    @Override
    public String generateVehicleID() {
        Vehicle top = repo.findTopByOrderByVehicleIDDesc();
        if(top!=null){
            Integer index = Integer.parseInt(top.getVehicleID().split("-")[1]);
            ++index;
            return index<10 ? "V-00"+index : index<100 ? "V-0"+index :"V-"+index;
        }
        return "V-001";
    }

    @Override
    public VehicleDTO searchVehicle(String id) {
        if (repo.existsById(id)) {
            return mapper.map(repo.findById(id).get(), VehicleDTO.class);
        } else {
            throw new RuntimeException("No Customer For " + id + " ..!");
        }
    }
}
