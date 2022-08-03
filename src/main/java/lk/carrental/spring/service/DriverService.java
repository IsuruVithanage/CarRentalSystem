package lk.carrental.spring.service;

import lk.carrental.spring.dto.CustomerDTO;
import lk.carrental.spring.dto.DriverDTO;
import lk.carrental.spring.entity.Driver;

import java.util.List;

public interface DriverService {
    void saveDriver(DriverDTO dto);

    List<DriverDTO> getAllDrivers();

    void deleteDriver(String id);
    void updateDriver(DriverDTO dto);
    String generateDriverID();
    List<DriverDTO> selectDriver(String status);
    Integer availableDriverCount();
    void setDriverAvailable(String id);
}
