package lk.carrental.spring.service.impl;

import lk.carrental.spring.dto.CustomerDTO;
import lk.carrental.spring.dto.DriverDTO;
import lk.carrental.spring.entity.Customer;
import lk.carrental.spring.entity.Driver;
import lk.carrental.spring.repo.CustomerRepo;
import lk.carrental.spring.repo.DriverRepo;
import lk.carrental.spring.service.DriverService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DriverServiceImpl implements DriverService {
    @Autowired
    private DriverRepo repo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void saveDriver(DriverDTO dto) {
        if (!repo.existsById(dto.getDriverID())) {
            repo.save(mapper.map(dto, Driver.class));
        } else {
            throw new RuntimeException("Driver Already Exist..!");
        }

    }

    @Override
    public List<DriverDTO> getAllDrivers() {
        return mapper.map(repo.findAll(), new TypeToken<List<DriverDTO>>() {
        }.getType());
    }

    @Override
    public void deleteDriver(String id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
        } else {
            throw new RuntimeException("Please check the Customer ID.. No Such Customer..!");
        }

    }

    @Override
    public void updateDriver(DriverDTO dto) {
        if (repo.existsById(dto.getDriverID())) {
            repo.save(mapper.map(dto, Driver.class));
        } else {
            throw new RuntimeException("No Such Customer To Update..! Please Check the ID..!");
        }

    }

    @Override
    public String generateDriverID() {
        Driver top = repo.findTopByOrderByDriverIDDesc();
        if(top!=null){
            Integer index = Integer.parseInt(top.getDriverID().split("-")[1]);
            ++index;
            return index<10 ? "D-00"+index : index<100 ? "D-0"+index :"D-"+index;
        }
        return "D-001";
    }

    @Override
    public List<DriverDTO> selectDriver(String status) {
        PageRequest p = PageRequest.of(0, 1);
        return mapper.map(repo.selectDriver(status), new TypeToken<List<DriverDTO>>() {
        }.getType());

    }

    @Override
    public Integer availableDriverCount() {
        List<Driver> available = repo.selectDriver("Available");
        return available.size();
    }
}
