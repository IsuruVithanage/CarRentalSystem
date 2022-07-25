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
}
